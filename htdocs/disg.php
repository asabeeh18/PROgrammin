<html>
	<head><link rel="stylesheet" type="text/css" href="chat.css"/>
		<title id="tab">Private Group Chats</title>
		<style>
		body{
			background-image:url(/img/logo.jpg);
		}
			#msgspan{
			top:20px;
			width:600px;
			margin-left:400px;
			border:2px white;
		}
		#box{
			bottom:100px;
			left:500px;
		}
		.nmae{
			font-family: Papyrus, fantasy;
			text-align:left;
			font-size:14px;
		}
		ul#menu {
    padding: 0;
}
	ul#menu li a {
		background-color: black;
		line-height: 300%;
		color: white;
		padding: 10px 20px;
		text-decoration: none;
		border-radius: 5px 5px 5px 5px;
	}
	#menu{
		position:absolute;
		left:10px;
	}
	ul#menu li a:hover{
		background-color:white;
		color:black;
	}
	
	</style>
	</head>
	<body>
	<ul id=menu>
		<li><a href="Profile.php">My Profile</a></li>
		<li><a href="ref.php">References</a></li>
		<li><a href="event.php">Events</a></li>
		<li><a href="discl.html">Discussions</a></li>
		<li><div id="Create"><a href="creategroup.php">Create new Group</a></div></li>
		<li><a href="logout.php">Logout</a></li>
	
	</ul>
	<?php
		//improve indentation of js URGENT!!!!!
		include 'redirect.php';	
		$me=$_COOKIE['username'];
		//echo $me;
		$result=$connection->query("select distinct `name` from `pnmanager` where `member` like '$me'");
		if(!$result) echo "Query Error!!";
		echo "<div id=\"list\">";
		for($i=0;$i<$result->num_rows;$i++)
		{
			$nmae=$result->fetch_row();
			$nm=$nmae[0];
			echo "<div class=\"listEle\" onclick=\"selector('$nmae[0]')\">$nmae[0]</div>";
		}
		echo "</div>";
	?>
	
	<div id="msgSpan">RepLaCE</div>
	
	<form onsubmit="return false" id="box">
                <input type=text id="message_input">
                <input onclick="fire()" type="submit" id="send_button">
	</form>
	<script>
		var me=0;
		//this function loads only when the partner is selected
		function selector(roll_no)
		{
			document.getElementById('tab').innerHTML=roll_no
			//alert("alive"+me);
			me=roll_no;
			
	//		alert("alive"+me);
			request = new ajaxRequest()
			request.open("POST", "privnmsg.php",true)
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
			request.send("roll="+me)
			//alert("alive0"+me);
			request.onreadystatechange = function()
			{
				//alert("alive1 :"+this.readyState);
				if (this.readyState == 4)
				{
					//alert("alive2: "+this.status);
					if (this.status == 200)
					{
						//alert("alive3"+me);
						if (this.responseText != null)
						{
							
							document.getElementById('msgSpan').innerHTML =this.responseText
							setInterval(function(){freeze(me)},1000);			
						}
						else alert("Ajax error: No data received")
					}
					else alert( "Ajax error: " + this.statusText)
				}
			}
			
		}
		var params;
		var request;
		//when  a msg is sent
		function fire()
		{
		x=document.getElementById("message_input");
		
		request = new ajaxRequest()
		request.open("POST", "privnmsg.php",true)
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
		//alert("msg="+x.value+"&me="+me);
		
			//alert("send");
			request.send("msg="+x.value+"&me="+me)
			document.getElementById("message_input").value = "";
		request.onreadystatechange = function()
		{
		//	alert(this.readyState);
			if (this.readyState == 4)
			{
				if (this.status == 200)
				{
					if (this.responseText != null)
					{
						//alert("fired");
						document.getElementById('msgSpan').innerHTML =document.getElementById('msgSpan').innerHTML+"<br>"+this.responseText
						document.getElementById("msgSpan").scrollTop= document.getElementById("msgSpan").scrollHeight;
					}
					else alert("Ajax error: No data received")
				}
				else alert( "Ajax error: " + this.statusText)
			}
		}
		}
		//check for new msgs
		function freeze(isTmsgSpan)
		{
			//x=document.getElementById("message_input");
			params="check="+isTmsgSpan;
			request = new ajaxRequest()
			request.open("POST", "privnmsg.php",true)
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
			//alert(params);
			
			request.onreadystatechange = function()
			{
				if (this.readyState == 4)
				{
					if (this.status == 200)
					{
						if (this.responseText != null)
						{
							document.getElementById('msgSpan').innerHTML =this.responseText
							document.getElementById("msgSpan").scrollTop= document.getElementById("msgSpan").scrollHeight;
						}
						else alert("Ajax error: No data received")
					}
					else alert( "Ajax error: " + this.statusText)
				}
			}
				request.send(params)
		}	
		//document.getElementById("msgSpan").innerHTML=x;
		//alert(x);
		//params = "url=localhost/aja.html"
		function ajaxRequest()
		{
			try
			{
				var request = new XMLHttpRequest()
			}
			catch(e1)
			{
				try
				{
					request = new ActiveXObject("Msxml2.XMLHTTP")
				}
				catch(e2)
				{
					try
					{		
						request = new ActiveXObject("Microsoft.XMLHTTP")
					}
					catch(e3)
					{	
						request = false
					}
				}
			}
			return request
		}
	</script>
</body>
</html>
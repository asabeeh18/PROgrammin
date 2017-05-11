<html>
	<head><title id="tab">Single Chats</title>
		<link rel=stylesheet type=text/css href=chat.css>
		<style>
			#msgspan{
			top:-200px;
			width:400px;
			margin-left:300px;
			border:2px white;
		}
		#box{
			top:200px;
			left:400px;
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
		<li><a href="logout.php">Logout</a></li>
	</ul>
	<?php
		
		require_once 'login.php';
		$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
		if($connection->connect_error) 
		echo "connect_error:".$db_database.'<br>';
		if(!isset($_COOKIE['username']))
		{
			echo "HAGA NA!";
			header('Location: /enter.php');
		}	
		$me= $_COOKIE['username'];
		echo $me;
		$result=$connection->query("select `name`,`roll_no` from `user` where `roll_no` not like '$me'");
		if(!$result) echo "Query Error!!";
		echo "<div id=\"list\">";
		for($i=0;$i<$result->num_rows;$i++)
		{
			$nmae=$result->fetch_row();
			$nm=$nmae[0];
			echo "<div class=\"listEle\" onclick=\"selector('$nmae[1]','$nm')\">$nmae[0]</div>";
		}
		echo "</div>";
	?>
	<div id="collect">
		<div id="msgSpan"></div>
		<form onsubmit="return false" id="box">
					<input type=text id="message_input">
					<input onclick="fire()" type="submit" id="send_button">
		</form>
	</div>
	<script>
		var me=0;
		//this function loads only when the partner is selected
		function niche()
		{
			document.getElementById("msgSpan").scrollTop= document.getElementById("msgSpan").scrollHeight;
		}
		function selector(roll_no,name)
		{
			document.getElementById('tab').innerHTML=name
//			alert("alive"+me);
			me=roll_no;
			
	//		alert("alive"+me);
			request = new ajaxRequest()
			request.open("POST", "msgpost.php",true)
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
			
			//alert("alive0"+me);
			request.onreadystatechange = function()
			{
				//alert("alive1"+this.readystate);
				if (this.readyState == 4)
				{
					//alert("alive2"+me);
					if (this.status == 200)
					{
						//alert("alive3"+me);
						if (this.responseText != null)
						{
							document.getElementById('msgSpan').innerHTML =this.responseText
							setInterval(function(){freeze(me)},1000);
							document.getElementById("msgSpan").scrollTop= document.getElementById("msgSpan").scrollHeight;
						}
						else alert("Ajax error: No data received")
					}
					else alert( "Ajax error: " + this.statusText)
				}
			}
			request.send("roll="+me)	
		}
		var params;
		var request;
		function fire()
		{
		x=document.getElementById("message_input");
		params="msg="+x.value;
		document.getElementById("message_input").value = "";
		request = new ajaxRequest()
		request.open("POST", "msgpost.php",true)
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
						document.getElementById('msgSpan').innerHTML =document.getElementById('msgSpan').innerHTML+this.responseText
						document.getElementById("msgSpan").scrollTop= document.getElementById("msgSpan").scrollHeight;
					}
					else alert("Ajax error: No data received")
				}
				else alert( "Ajax error: " + this.statusText)
			}
		}
			request.send(params+"&me="+me)
		}
		function freeze(isThere)
		{
			//x=document.getElementById("message_input");
			params="check="+isThere;
			request = new ajaxRequest()
			request.open("POST", "msgpost.php",true)
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
							document.getElementById('msgSpan').innerHTML =document.getElementById('msgSpan').innerHTML+this.responseText
							document.getElementById("msgSpan").scrollTop= document.getElementById("msgSpan").scrollHeight;
						}
						else alert("Ajax error: No data received")
					}
					else alert( "Ajax error: " + this.statusText)
				}
			}
				request.send(params)
		}	
		//document.getElementById("here").innerHTML=x;
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
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="chat.css"/>
		<title>Public Discussions</title>
		<style>
		#msgspan{
			width:700px;
			margin-left:300px;
		}
		#box{
			top:500px;
			left:400px;
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
	<body onload="getMsg()">
	<ul id=menu>
		<li><a href="Profile.php">My Profile</a></li>
		<li><a href="ref.php">References</a></li>
		<li><a href="event.php">Events</a></li>
		<li><a href="discl.html">Discussions</a></li>
		<li><a href="logout.php">Logout</a></li>
	</ul>
		
	<?php
		//improve indentation of js URGENT!!!!!
		include 'redirect.php';	
		$me=$_COOKIE['username'];
		//echo $me;
	?>
	<div id="msgSpan">RepLaCE</div>
	
	<form onsubmit="return false" id="box">
                <input type=text id="message_input">
                <input onclick="fire()" type="submit" id="send_button">
	</form>
	<script>
		function getMsg()
		{
//			alert("alive"+me);
			
	//		alert("alive"+me);
			request = new ajaxRequest()
			request.open("POST", "publicdisc.php",true)
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
			request.send("load=all")
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
							setInterval(function(){freeze()},1000);			
							document.getElementById("msgSpan").scrollTop= document.getElementById("msgSpan").scrollHeight;
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
		x=x.value
		request = new ajaxRequest()
		request.open("POST", "publicdisc.php",true)
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
		//alert("msg="+x.value);
			//alert(x);
			
			request.send("msg="+x)
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
					}
					else alert("Ajax error: No data received")
				}
				else alert( "Ajax error: " + this.statusText)
			}
		}
		}
		//check for new msgs
		function freeze()
		{
			//x=document.getElementById("message_input");
			request = new ajaxRequest()
			request.open("POST", "publicdisc.php",true)
			request.setRequestHeader("Content-type","application/x-www-form-urlencoded")
			//alert(params);
			request.send("check=now")
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
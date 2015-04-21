<html>
	<head>
		<link rel="icon" type="image/ico" href="favicon.ico"> 
		<title>Login</title>
		<style>
		body
		{
			background-image: url('img/login.jpg');
			 -webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		    background-repeat: repeat-x;
			background-color: #cbc69b;
			background-position:center;
			
  		}
		
		.container {
				
				width: 15%;
				margin: 2em auto;
				box-shadow: 0 0 5px #000;
				padding: 1em;
				text
				text-align: center;
				border-style: solid;
				border-width: medium;
			}
			p {
				margin: 0;
				padding: 0;
			}
		
		</style>
	</head>
	<body>
	   <div class="container"><br>
			<!-- add style to this div in d css or here itself its not visible-->
		    <div id="wrongPass">
			<?php if(isset($_GET['try'])) 
				{
					$try=$_GET['try'];
					//use css to make it red
					echo "<div style='color:red;'>Wrong Roll Number or Password!<br>TRY AGAIN</div>";
				}
				else $try=0;
			?>
			</div> 
			<form method="post" action=logini.php>
			<b><font size="5" color="#fcfdf3"></b>Roll No.</font> :<input type="text" name="name" placeholder="XXXXXAXXXX" required><br /><br />
			<b><font size="5" color="#fcfdf3"></b>Password:</font><input type="password" name="password" placeholder required><br /><br />
			<input type='hidden' name='try' value=<?php echo $try ?>>
			
			<input type="checkbox" name="remmbr"><font color="#fcfdf3">Remember Me</font><br>
			<input type="submit" value="Login"><br /><br />
			</form>
			<p><font size="5S"color="fcfdf3">OR</FONT></p><br />
			<a href=add.html><input type="button" value="SignUp"></a>
		</div>
	</body>
</html>
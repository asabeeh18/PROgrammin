
<html>
<head>
<title> start </title></head>
<body>
<!-- dont change the content of div below just make a css for it <something like red color in bold> the div says WRONG PASSWORD-->
<div id="wrongPass">
<?php if(isset($_GET['try'])) 
	{
		$try=$_GET['try'];
		//use css to make it red
		echo "Wrong Roll Number or Password!<br>TRY AGAIN";
	}
	else $try=0;
	?>
</div>
<form method="post" action=logini.php>
Roll Number<input type='text' name='name' placeholder='Roll Number' required='required'><br>
Password<input type='password' name='password' required='required'><br>
<input type='hidden' name='try' value=<?php echo $try ?>>
<input type="checkbox" name="remmbr">Remember Me<br>


<input type="submit">
</body>
</html>
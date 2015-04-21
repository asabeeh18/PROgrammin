<?php
	require_once 'redirect.php';
	$roll=$_COOKIE['username'];
	echo $roll;
	$n=htmlentities($_POST['name']);
	$d=htmlentities($_POST['detail']);
	$do=htmlentities($_POST['dob']);
	$e=htmlentities($_POST['email']);
	$p=htmlentities($_POST['phno']);
	$g=htmlentities($_POST['gender']);
	//$pi=$_POST['img'];
	$s=$_POST['status'];
	$path="\\images\\$roll.jpg";
	//echo $path." ";
	echo move_uploaded_file($_FILES['img']['tmp_name'],"C:\\xampp\\htdocs".$path);
	$path=$connection->real_escape_string($path);
	$e=$connection->real_escape_string($e);
	//echo $e;
	$sql="UPDATE `user` SET `name`='$n',`about`='$d',`bday`='$do',`email_id`='$e',`phno`='$p',`gender`='$g',`dp`='$path',`status`='$s' where `roll_no` like '$roll'";
	//echo "<br>".$sql."<br>";
	$result=$connection->query($sql);
	if(!$result)
	{
		echo "shit:".$connection->error."<br>";
		echo "<br><a href=editprofile.php>TRY AGAIN</a>";
	}
		
	else
	{	echo "<h1>UPDATE SUCCESS redirecting....</h1>";
		header( "refresh:2; url=Profile.php" ); 
	}
?>
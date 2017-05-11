<?php
	include 'redirect.php';
	//validation and remove html...
	$name=$_POST['name'];
	$pass=$_POST['password'];
	$roll=$_POST['roll_no'];
	$email=$_POST['email'];
	$path="\\images\\$roll.jpg";
	//echo $path." ";
	echo move_uploaded_file($_FILES['img']['tmp_name'],"C:\\xampp\\htdocs".$path);
	$path=$connection->real_escape_string($path);
	$str = "INSERT INTO `user` (`name`, `roll_no`, `pswd`,`dp`,`email_id`) VALUES ('$name','$roll','$pass','$path','$email')";
	echo " -".$str;
	$result=$connection->query($str);
	if(!$result)
		die("FAILED!".$connection->error);
	else
	{
	echo <<<END
			SUCCESSFULLY REGISTERED!!<br>NAME $name<br>Roll No. $roll<br>
END;
			setcookie('username',$roll,time()+300*60*60,'/');
			header('Location: /index.php');
			exit();
	}
?>
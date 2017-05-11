<?php
	require_once 'login.php';
	$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
	if($connection->connect_error)
		echo "COnnect Error:".$db_database."<br>";
	
	//$name=$_POST['name'];
	$str = "INSERT INTO `student` (`name`, `roll_no`, `password`, `pointer`) VALUES ('Jigariajjar', '121137', '123abc', '9')";
	$result=$connection->query($str);
	if(!$result)
		echo "FAILED!";
?>
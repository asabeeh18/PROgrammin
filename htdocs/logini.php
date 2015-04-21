<?php
require_once 'login.php';
$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
if($connection->connect_error) 
	echo "connect_error:".$db_database.'<br>';
	
//add validation and sqlinjection
$name=$_POST['name'];
$password=$_POST['password'];
echo $name;
echo $password;
$result=$connection->query("select `pswd`,`name` from `user` where `roll_no`='$name'");
if(!$result)
	die("ERROR");
$data=$result->fetch_row();
if($data[0]==$password)
{
	echo $data[0]."<br>";
	//die($result->fetch_assoc()['name']);
	if(isset($_POST['remmbr']))
	{
		
		setcookie('username',$name,time()+300*60*60,'/');
		//die("set");
		//if(isset($_COOKIE['username'])) die("sioetting");
		header('Location: /index.php');
		
	}
	else
	{
		
		setcookie('username',$name,0,'/');
		//die("setting1");
		header('Location: /index.php');
		
	}
}
else
{
	$try=$_POST['try'];
	$try=$try+1;
	if($try==3)
		die("Limit Reached");
	header("Location: /enter.php?try=$try");
}

$result->close();
$connection->close();
?>
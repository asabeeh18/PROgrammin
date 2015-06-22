<?php
require_once 'login.php';
$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
if($connection->connect_error) 
echo "connect_error:".$db_database.'<br>';
$gid=$_POST['gid'];
$nmae=$_POST['name'];
$gid=$connection->real_escape_string($gid);
$nmae=$connection->real_escape_string($nmae);
	$result=$connection->query("insert into `pnmanager` (`member`,`name`) values('$nmae','$gid')"); 
	if(!$result)
		echo ":'(";
	else
		echo "ALL OK"
?>
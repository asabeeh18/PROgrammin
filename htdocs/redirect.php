<?php
		
		$db_hostname='localhost';
$db_database='class_network';
$db_username='root';
$db_password='';

		$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
		
		if($connection->connect_error) 
			echo "connect_error:".$db_database.'<br>';
		
?>
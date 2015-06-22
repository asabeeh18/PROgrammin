<?php
	include 'redirect.php';
	
	$name=$_POST['name'];
	$details=$_POST['detail'];
	$time=$_POST['time'];
	$place=$_POST['place'];
	$type=$_POST['type'];
	$org=$_COOKIE['username'];
		$sql="insert into `event` (`name`,`details`,`date`,`place`,`organiser`,`type`) Values ('$name','$details','$time','$place','$org','$type')";
		$result=$connection->query($sql);
		if(!$result) echo "Query Error!";
		else 
		{
			echo "ALL OK";
		}
?>
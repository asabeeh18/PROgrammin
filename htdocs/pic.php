<?php
	require_once 'login.php';
	$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
	if($connection->connect_error)
		echo "COnnect Error:".$db_database."<br>";
	$str=$connection->real_escape_string("select `imgpath` from `student`");
	$pic=$connection->query($str);
	while($row=$pic->fetch_row())
	{
		$str="\"".$row[0]."\"";
		echo $str."=";
		echo "<img src=$str alt='some_text'>"."<br>";
	}
	//$row=$pic->fetch_row();
	//echo $pic;
	if($pic)
		echo "true";
	else
		echo "FF";
?>
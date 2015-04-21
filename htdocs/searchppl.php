<?php

		$db_hostname='localhost';
$db_database='class_network';
$db_username='root';
$db_password='';

		$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
		
		if($connection->connect_error) 
			echo "connect_error:".$db_database.'<br>';
	$roll=$_COOKIE['username'];
	//init
		$n="%";
		$d="%";
		$do="%";
		$e="%";
		$p="%";
		$g="%";
		$s="%";

		if(isset($_POST['name']))
			if($_POST['name']!="")
				$n=$_POST['name'];
		if(isset($_POST['detail']))
			if($_POST['detail']!="")
				$d=$_POST['detail'];
		if(isset($_POST['dob']))
			if($_POST['dob']!="")
				$do=$_POST['dob'];
		if(isset($_POST['email']))
			if($_POST['email']!="")
				$e=$_POST['email'];
		if(isset($_POST['phno']))
			if($_POST['phno']!="")
				$p=$_POST['phno'];
		if(isset($_POST['gender']))
			if($_POST['gender']!="")
				$g=$_POST['gender'];
		if(isset($_POST['status']))
			if($_POST['status']!="")
				$s=$_POST['status'];
		
		//filters list
		//echo $path." ";
		//echo "===".$p;
		$sql="SELECT roll_no from `user` where `name` like '$n' && `about` like '$d' && `bday` like '$do' && `email_id` like '$e' && `phno` like '$p' && `gender` like '$g' && `status` like '$s'";
		//echo "<Sbr>".$sql."<br>";
		$result=$connection->query($sql);
		if(!$result) echo "shit:".$connection->error."<br>";
		else
		{
			//echo $sql;
			$r=$result->fetch_row();
		//	echo "SUCCESS $r[0] $result->num_rows";
			echo "<table class=container><tbody>";
		for($i=0;$i<$result->num_rows;$i++)
			{
				echo "$r[0]<br>";
				$r=$result->fetch_row();
			}
			
		}
?>
</body>
</html>
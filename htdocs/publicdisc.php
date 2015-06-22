<?php // urlpost.php
//message segragation into sender receiver sides left
require_once 'login.php';
$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
if($connection->connect_error) 
echo "connect_error:".$db_database.'<br>';
$me=$_COOKIE['username'];
	//echo "inme";
if(isset($_POST['load']))
{
	
	//echo "setroll";
	//$roll=$_POST['roll'];
	//echo "<br>"."<br>"."<br>"."<br>".$roll."<br>".$me."<br>";
	$sql="select `sender`,`msg`,`time` from `publicdisc` where (`sender` not like '$me' )";
	$result1=$connection->query($sql);
	$sql="select `msg`,`time` from `publicdisc` where (`sender` like '$me' )";
	$result2=$connection->query($sql);
	
	if(!$result1 || !$result2) echo "Query Error!!@18";
	//$rows=(($result1->num_rows)<($result2->num_rows))?$result1->num_rows:$result2->num_rows;
	//echo "him          <br>";
	$r2=$result2->fetch_row();
	$r1=$result1->fetch_row();
	//echo "in";
	for($i=0,$j=0;$i<$result1->num_rows || $j<$result2->num_rows;)
	{
		//echo "in";
		if(($r1[1]<$r2[1] && $i<$result1->num_rows) || $j==$result2->num_rows)
		{
			echo "<div class=\"nmae\">".$r1[0]."</div>";
			echo "<div class=\"him\">".$r1[1]."</div>";
			$r1=$result1->fetch_row();
			$i++;
		}
		else if($j<$result2->num_rows)
		{
			echo "<div class=\"me\">".$r2[0]."</div>";
			$r2=$result2->fetch_row();
			$j++;
		}
	}	
	
 }

 
else if(isset($_POST['msg']))
{
	//echo "setmsg";
	$msg=$_POST['msg'];
	//echo $msg." ".$roll." ".$me;
	$sql = "INSERT INTO `publicdisc` (`sender`, `msg`) VALUES ('$me', '$msg');";
	$result=$connection->query($sql);
	if(!$result) echo "Query Error";
	//else echo "<div class=\"me\">".$msg."</div>";
}
else if(isset($_POST['check']))
{
	//echo "setcheck";
	$roll=$_POST['check'];
	$sql="select `msg` from `publicdisc` where (`status`=0) order by time asc";
	$result=$connection->query($sql);
	if(!$result) echo "Query Error!!@54".$connection->error;
	else
	{
		$r=$result->fetch_row();
		for($i=0;$i<$result->num_rows;$i++)
		{
			echo "<div class=\"him\">".$r[0]."</div>";
			$r=$result->fetch_row();
		}
		//echo "out";
		$sql="UPDATE `publicdisc` SET `status` = 1 WHERE `status`=0";
		$result=$connection->query($sql);
		if(!$result) echo "Query Error";
		//else echo "====";
	}
}

else "Error Big Time";
?>
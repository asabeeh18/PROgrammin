<?php // urlpost.php
//message segragation into sender receiver sides left
require_once 'login.php';
$connection=new mysqli($db_hostname,$db_username,$db_password,$db_database);
if($connection->connect_error) 
echo "connect_error:".$db_database.'<br>';
$me=$_COOKIE['username'];
	//echo "inme";

if(isset($_POST['roll']))
{
	
	//echo "in";
	$roll=$_POST['roll'];
//	echo "<br>"."<br>"."<br>"."<br>".$roll."<br>".$me."<br>";
	$sql="select `msg`,`time` from `priv1disc` where (`receiver` like '$roll' AND `sender` like '$me')";
	$result1=$connection->query($sql);
	$sql="select `msg`,`time` from `priv1disc` where (`sender` like '$roll' AND `receiver` like '$me')";
	$result2=$connection->query($sql);
	if(!$result1 || !$result2) echo "Query Error!!@18";
	//$rows=(($result1->num_rows)<($result2->num_rows))?$result1->num_rows:$result2->num_rows;
	//echo "him          ".$roll."<br>";
	$r2=$result2->fetch_row();
	$r1=$result1->fetch_row();
	//header('Location: /enter.php');
	for($i=0,$j=0;$i<$result1->num_rows || $j<$result2->num_rows;)
	{
		//echo "in";
		if(($r1[1]<$r2[1] && $i<$result1->num_rows) || $j==$result2->num_rows)
		{
			echo "<div class=\"me\">".$r1[0]."</div>";
			$r1=$result1->fetch_row();
			$i++;
		}
		else if($j<$result2->num_rows)
		{
			echo "<div class=\"him\">".$r2[0]."</div>";
			$r2=$result2->fetch_row();
			$j++;
		}
	}	
}
else if(isset($_POST['msg']))
{
	$msg=$_POST['msg'];
	$roll=$_POST['me'];
	//echo $roll."---".$msg;
	$sql = "INSERT INTO `priv1disc` (`receiver`, `sender`, `msg`, `time`) VALUES ('$roll', '$me', '$msg', sysdate(6));";
	$result=$connection->query($sql);
	if(!$result) die("Query Error 50".$connection->error);
	else echo "<div class=\"me\">".$msg."</div>";
}
else if(isset($_POST['check']))
{
	$roll=$_POST['check'];
	//echo $roll."-".$me."<br>";
	$sql="select msg,count(*) from `priv1disc` where (`sender` like '$roll' AND `receiver` like '$me' AND `status`=0) order by time asc";
	$result=$connection->query($sql);
	if(!$result) echo "Query Error!!@54";
	else
	{
		$r=$result->fetch_row();
		if($r[1]==0)
			exit();
		for($i=0;$i<$r[1];$i++)
		{
			echo "<div class=\"him\">".$r[0]."</div>";
		}
		//echo "out";
		$sql="UPDATE `priv1disc` SET `status` = 1 WHERE `sender` = '$roll' AND `receiver`='$me' AND `status`=0";
		$result=$connection->query($sql);
		if(!$result) echo "Query Error @72";
	}
}

else echo "Error Big Time";
?>
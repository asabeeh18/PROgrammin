<?php // urlpost.php
//message segragation into sender receiver sides left
include 'redirect.php';
$me=$_COOKIE['username'];
	//echo "inme";
function firsttime($roll)
{
	include 'redirect.php';
	$me=$_COOKIE['username'];
	echo "IN first tym";
	//echo "<br>"."<br>"."<br>"."<br>".$roll."<br>".$me."<br>";
	$sql="select `sender`,`msg`,`time` from `privndisc` where (`dname` like '$roll' AND `sender` not like '$me' ) order by time asc";
	$result1=$connection->query($sql);
	$sql="select `sender`,`msg`,`time` from `privndisc` where (`dname` like '$roll' AND `sender` like '$me' ) order by time asc";
	$result2=$connection->query($sql);
	if(!$result1 || !$result2) echo "Query Error!!@21";
	//$rows=(($result1->num_rows)<($result2->num_rows))?$result1->num_rows:$result2->num_rows;
	//echo "him          ".$roll."<br>";
	$r2=$result2->fetch_row();
	$r1=$result1->fetch_row();
	//echo "in";
	
	$sql="UPDATE `pnmanager` SET `status` = 1 WHERE `name` = '$roll'  AND `member`='$me'";
		$result=$connection->query($sql);
			if(!$result) echo "Query Error 27";
			
	
	for($i=0,$j=0;$i<$result1->num_rows || $j<$result2->num_rows;)
	{
		//echo "in";
		if(($r1[2]<$r2[2] && $i<$result1->num_rows) || $j==$result2->num_rows)
		{
			echo "<div class=\"nmae\">".$r1[0]."</div>";
			echo "<div class=\"him\">".$r1[1]."</div>";
			$r1=$result1->fetch_row();
			$i++;
		}
		else if($j<$result2->num_rows)
		{
			
			echo "<div class=\"me\">".$r2[1]."</div>";
			$r2=$result2->fetch_row();
			$j++;
		}
	}
}	
if(isset($_POST['roll']))
{
	firsttime($_POST['roll']);
}
	//echo "setroll";
/*	$roll=$_POST['roll'];
	echo $me;
	//echo "<br>"."<br>"."<br>"."<br>".$roll."<br>".$me."<br>";
	$sql="select `sender`,`msg`,`time` from `privndisc` where (`dname` like '$roll' AND `sender` not like '$me' )";
	$result1=$connection->query($sql);
	$sql="select `sender`,`msg`,`time` from `privndisc` where (`dname` like '$roll' AND `sender` like '$me' )";
	$result2=$connection->query($sql);
	$sql="UPDATE `privndisc` SET `status` = 1 WHERE `dname` = '$roll'  AND `member`='$me'";
		$result=$connection->query($sql);
		if(!$result) echo "Query Error 75";
	if(!$result1 || !$result2) echo "Query Error!!@18";
	//$rows=(($result1->num_rows)<($result2->num_rows))?$result1->num_rows:$result2->num_rows;
	//echo "him          ".$roll."<br>";
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
			
			echo "<div class=\"me\">".$r2[1]."</div>";
			$r2=$result2->fetch_row();
			$j++;
		}
	}	
*/	


 
else if(isset($_POST['msg']))
{
	//echo "setmsg";
	$msg=$_POST['msg'];
	$roll=$_POST['me'];
	
	//echo $msg." ".$roll." ".$me;
	$sql = "INSERT INTO `privndisc` (`dname`,`sender`, `msg`) VALUES ('$roll','$me','$msg');";
	$result=$connection->query($sql);
	if(!$result) die("Query Error 55");
	else echo "<div class=\"me\">".$msg."</div>";
	$sql="UPDATE `pnmanager` SET `status` = 0 WHERE `name` = '$roll'  AND `member`!='$me'";
		$result=$connection->query($sql);
			if(!$result) echo "Query Error 106";
	
}
else if(isset($_POST['check']))
{
	//echo "setcheck";
	$roll=$_POST['check'];
	firsttime($roll);
			
		/*for($i=0;$i<$result->num_rows;$i++)
		{
			echo "<div class=\"nmae\">".$r[1]."</div>";
			echo "<div class=\"him\">".$r[0]."</div>";		
		}
		//echo "out";
		$sql="UPDATE `privndisc` SET `status` = 1 WHERE `dname` like '$roll'  AND `status`=0";
		$result=$connection->query($sql);
		if(!$result) echo "Query Error 75";*/
}

else echo "Error big tine hu(Y) ";
	
?>
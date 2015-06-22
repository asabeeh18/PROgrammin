<!DOCTYPE html>
<html>
<head><title>HOME</title>
<link rel=stylesheet href=style.css>
<style>
body{
	background-image:url(/img/logo.jpg);
}
ul#menu {
    padding: 0;
}


ul#menu li a {
    background-color: orange;
    line-height: 300%;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 5px 5px 5px 5px;
}

ul#menu li a:hover {
    background-color: #996666;
}

div.container {
    width: 40em;
    border: 0.5em solid;
}

div.box {
    box-sizing: border-box;
    width: 50%;
    padding: 100px;
    border: 0.5em solid black;
    float: left;
}
#pikachu{

  width:200px;
  height:200px;
  padding:0px;
  margin: 0 auto;
  overflow: hidden;
  position:float;
}
#me{
	position:absolute;
	max-width:400px;
	left:300px;
}
#menu{
	position:absolute;
	left:10px;
}

</style>
</head>
<body>
<?php 
include 'redirect.php';
		$roll=$_COOKIE['username']; 
		$str="select `dp`,`name` from `user` where '$roll'=`roll_no`";
		$result=$connection->query($str);
		if($result)
		{
			$pic=$result->fetch_row();
			echo "<h1 class=container id=me>$pic[1]</h1>";
			echo "<img src=$pic[0] class='container' id='pikachu'>"."<br>";
		}
		else echo "hAGA NA!".$connection->error;
?>
		
		<ul id=menu>
		<li><a href="Profile.php">My Profile</a></li>
		<li><a href="ref.php">References</a></li>
		<li><a href="event.php">Events</a></li>
		<li><a href="discl.html">Discussions</a></li>
		<li><a href="logout.php">Logout</a></li>
		</ul>
		
		<div class="container" id=tabl><h1>Todays TimeTable</h1>
		<?php
		$today = getdate();
		$today=$today['wday'];
		if($today==6 || $today==0)
		{
			echo "<h1>REJOICE! Its a Holiday!</h1>";
		}
		else 
		{
			$sql="select `mon`,`tue`,`wed`,`thur` from `time_table`";
			$result=$connection->query($sql);
			if($result)
			{
				while($today--)
				{
					$r=$result->fetch_row();
				}
				echo <<< _GO
					<table>
					<tr>
						<th>9-11</th>
						<th>11:15-1:15</th>
						<th>1:45-3:45</th>
						<th>3:45-</th>
					</tr>
					<tr>
					<th>$r[0]</th>
					<th>$r[1]</th>
					<th>$r[2]</th>
					<th>$r[3]</th>
					</tr>		
					</table
_GO;
			}
			else
			{
				echo "-_-".$connection->error;
			}
		}
		//References
?>
</div>
		</div>		
	</body>
</html>
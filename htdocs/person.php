<html>
	<head><title>User Profile</title>
	<link rel="stylesheet" href="style.css">
	<style>
		table, tr, th, td 
		{
			border: 0;
		}
body{
	 background-image: url('img/profile.png');
}
ul#menu {
    padding: 0;
	width:150px;
	position:absolute;
	left:0px;
}

ul#menu li a {
    background-color: black;
    line-height: 300%;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 5px 5px 5px 5px;
}

ul#menu li a:hover {
    background-color: purple;
}
ul{
	margin-top:20px;
	margin-left:20px;
}
.pikachu{
	width:400px;
  height:400px;
  padding:0px;
  margin-left:200px;
  overflow: hidden;
  position:float;
}
tr{
	padding:0px;
}
	</style>
	</head>
	<body>
	<ul id=menu>
		<li><a href="Profile.php">My Profile</a></li>
		<li><a href="ref.php">References</a></li>
		<li><a href="event.php">Events</a></li>
		<li><a href="discl.html">Discussions</a></li>
		<li><a href="logout.php">Logout</a></li>
		</ul>
		

<?php
	include 'redirect.php';
		$name="YO";	
	$me=$_GET['roll'];
	$sql="select `dp`,`roll_no`,`email_id`,`name`,`phno`,`gender`,`bday`,`status`,`about` from `user` where `roll_no` like '$me'";
	$result=$connection->query($sql);
	$r=$result->fetch_row();
	$pic=$r[0];
	$name=$r[3];
	$roll=$r[1];
	$detail=$r[8];
	$email=$r[2];
	$dob=$r[6];
	$mob=$r[4];
	$status=$r[7];
	$gender=$r[5];
//	echo $pic;

	echo <<< _GO
	
		<div class="profile">
			<table>
				<tr>
					<td>
					
						<img src=$pic class=pikachu>
					
					</td>
					<td>
		
						<h1>$name</h1>
		
					</td>
				</tr>
			</table>
		</div>
		<div class="container">
		<div class="status">
			<h2>Status: $status</h2>
		</div>
		
			<div class="container" style='position:relative;width:400px;height:auto;left:10px;'>
				<table style=border-width:0px;>
					<tr>
						<td>
							Date Of Birth:
						</td>
						<td>
							$dob
						</td>
					</tr>
					<tr>
						<td>
							Roll No.:
						</td>
						<td>
							$roll
						</td>
					</tr>
					<tr>
						<td>
							Email:
						</td>
						<td>
							$email
						</td>
					</tr>
					<tr>
						<td>
							Phone No.:
						</td>
						<td>
							$mob
						</td>
					</tr>
					<tr>
						<td>
							Gender:
						</td>
						<td>
							$gender
						</td>
					</tr>
					<tr>
						<td>
							About Me:
						</td>
						<td>
							$detail
						</td>
					</tr>
				</table>
			</div>
		
	</div>
	
_GO;

?>
</body>
</html>

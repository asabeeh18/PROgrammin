<html>
	<head><title>Events</title>
	<link rel=stylesheet href=style.css>
	<style>
		header 
		 {
			background-color:#901C1D;
			color:white;
			text-align:center;
			padding:5px;
		}
		body
		{
			background-image:url(/img/logo.jpg);
  		}
		#create{
			width:500px;
		}
		footer{
			
color: rgb(20, 18, 18);
font-size: 23px;

text-shadow: rgb(224, 224, 224) 1px 1px 0px;

			text-align:center;
			position:absolute;
			bottom:0px;
		}
		ul#menu {
    padding: 0;
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
			<header>
	<h1>EVENTS</h1>
	</header>
	</div>
			<ul id=menu>
		<li><a href=index.php>Homepage</a></li>
		<li><a href="ref.php">References</a></li>
		<li><a href="event.php">Events</a></li>
		<li><a href="discl.html">Discussions</a></li>
		<li><a href="logout.php">Logout</a></li>
		</ul>
<?php
	//events
	include 'redirect.php';
	//show the top/side bar 
	
	$sql="select `name`,`place`,`organiser`,`details`,`date`,`type` from `event` order by time desc";
	$result=$connection->query($sql);
	if(!$result) die("Query Error!");
	echo <<< _GO
			<div class="auth_table">
			<table border="1" class="container">
			<tr>
					<th>Name</th>
					<th>Type</th>
					<th>Place</th>
					<th>Date</th>
					<th>Organiser</th>
					<th>Details</th>
			</tr>
_GO;
	$r=$result->fetch_row();
	for($i=0;$i<$result->num_rows;$i++)
	{
		echo <<< _GO
			<tr>
				<td>$r[0]</td>
				<td>$r[5]</td>
				<td>$r[1]</td>
				<td>$r[4]</td>
				<td>$r[2]</td>
				<td>$r[3]</td>
			</tr>
_GO;
		$r=$result->fetch_row();
	}
	echo "</table><div id='create' class='container' style='margin-top:10px;'>OR CREATE EVENT";
	echo <<< _GO
	<form method=POST action="addevent.php">
	Name<input type="text" name="name"><br>
	Place<input type="text" name="place"><br>
	Date<input type="date" name="time"><br>
	Details<input type="text" name="detail"><br>
	Type<input type="text" name="type"><br>
	<input type="submit">
	</form>
	</div>
_GO;
	//footer
?>
<footer>
<a href=about.html>About Us</a>
</footer>
</body>
</html>
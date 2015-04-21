<html>
	<head><title>Reference Books</title>
	<link rel=stylesheet href=style.css>
	<style>
		body
		{
	background-image:url(/img/logo.jpg);	

  		}
		 header 
		 {
			background-color:#e74c3c;
			color:white;
			text-align:center;
			padding:5px;
			margin-bottom:10px
		}
ul#menu {
    padding: 0;
	width:170px;
	position:absolute;
	left:0px;
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
ul{
	margin-top:20px;
	margin-left:20px;
}
	</style>	
	</head>
	<body>
	<ul id=menu>
		<li><a href=index.php>Homepage</a></li>
		<li><a href="ref.php">References</a></li>
		<li><a href="event.php">Events</a></li>
		<li><a href="discl.html">Discussions</a></li>
		<li><a href=searchppl.php>Search for people</a></li>
		<li><a href=editprofile.php>Edit my profile</a></li>
		<li><a href="logout.php">Logout</a></li>
		</ul>
	
<?php
	//references
	include 'redirect.php';
	$auth="%";
	$subj="%";
	if(isset($_POST['auth']))
	if($_POST['auth']!="")
		$auth=$_POST['auth'];
	if(isset($_POST['subj']))
	if($_POST['subj']!="")
		$subj=$_POST['subj'];
	//show the top/side bar 
	echo <<< _GO
	<!--Style the text and colors of this page inline is preferred-->
	<header><H1>Reference Books</H1></header>
	<form method=POST action=ref.php class="container">
		Author<input type="text" name="auth"><br>
		Subject<input type="text" name="subj"><br>
		<input type="submit" value=Search>
	</form>
_GO;
	$sql="select * from `reference` where `author` like '$auth' AND `subject` like '$subj'";
	$result=$connection->query($sql);
	if(!$result) die("Query Error!");
	if($result->num_rows==0)
		echo "<div id='error'>NO RESULT MATCH</div>";
	echo <<< _GO
			<div class="auth_table">
			<table border="1" class="container">
			<tr>
					<th>Author</th>
					<th>Name</th>
					<th>Subject</th>
					<th>Link</th>
			</tr>
_GO;
	$r=$result->fetch_row();
	for($i=0;$i<$result->num_rows;$i++)
	{
		echo <<< _GO
			<tr>
				<td>$r[1]</td>
				<td>$r[0]</td>
				<td>$r[2]</td>
				<td><a href='$r[3]'>Download</a></td>
			</tr>
_GO;
		$r=$result->fetch_row();
	}
	echo "</table></div></body></html>";
	//footer and shit
?>	
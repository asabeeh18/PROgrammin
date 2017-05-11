<?php
	setcookie('username', 'Xeroo', time() - 2592000, '/');
	if(!isset($_COOKIE['username'])) echo "Logout Successfull";
	header('Location: /enter.php');
?>
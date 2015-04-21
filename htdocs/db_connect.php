<?php

class DB_Connect {

// constructor
function __construct() {

}

// destructor
function __destruct() {
// $this->close();
}

// Connecting to database
public function connect() {

$db_hostname='localhost';
$db_database='class_network';
$db_username='root';
$db_password='';

// connecting to mysql
$con = mysql_connect($db_hostname,$db_username,$db_password);
// selecting database
mysql_select_db($db_database);

// return database handler
return $con;
}

// Closing database connection
public function close() {
mysql_close();
}

} 
?>	
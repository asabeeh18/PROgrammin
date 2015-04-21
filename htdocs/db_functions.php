<?php

class DB_Functions {

private $db;



//put your code here
// constructor
function __construct() {
include_once './db_connect.php';
// connecting to database
$this->db = new DB_Connect();
$this->db->connect();


}

// destructor
function __destruct() {

}

/**
* Storing new user
* returns user details
*/
public function storeUser($name, $gcm_regid) {
// insert user into database
$result = mysql_query("INSERT INTO gcm_users(name, gcm_regid, created_at) VALUES('$name', '$gcm_regid', NOW())");
// check for successful store
if ($result) 
{
echo "inserted";
return;
} else {
return false;
}

}

public function listAll()
{
$a=array();

$query="Select gcm_regid from gcm_users";
$res=mysql_query($query);

if(!$res)
 echo "List Query Failed";


while ($row = mysql_fetch_assoc($res)) 
{
    array_push($a,$row['gcm_regid']);
}
return $a;
}


/**
* Getting all users
*/
public function getAllUsers() {
$a="";
$res = mysql_query("select name FROM gcm_users");
if(!$res)
 echo "List Query Failed";


while ($row = mysql_fetch_assoc($res)) 
{
    $a=$row['name']."&".$a;
}
return $a;

}

}//end class

?>			
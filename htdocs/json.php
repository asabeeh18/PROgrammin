<?php
include_once './GCM.php';
include_once './db_functions.php';


$msg=$_GET["message"];

$db = new DB_Functions();
$list=$db->listAll();
$gcm = new GCM();
$gcm->send_notification($list,$msg);
?>
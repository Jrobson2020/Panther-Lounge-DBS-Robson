<?php
session_start();
session_register('club');
$_SESSION['club']=$_POST['clubChoice'];
session_destroy();
?>

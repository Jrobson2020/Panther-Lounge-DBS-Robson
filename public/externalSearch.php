<?php
session_start();
session_register('searchBar');
$_SESSION['searchBar']=$_POST['query'];
session_destroy();
?>

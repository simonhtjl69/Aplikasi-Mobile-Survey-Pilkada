<?php
session_start();

$conn = mysqli_connect(
  'localhost',
  'root',
  '',
  'surveipilkada'
) or die(mysqli_erro($mysqli));

?>

<?php

include('db.php');

if (isset($_POST['save_task'])) {
  $unique_id = $_POST['unique_id'];
  $nama = $_POST['nama'];
  $email = $_POST['email'];
  $encrypted_password = $_POST['encrypted_password'];
  $salt = $_POST['salt'];
  $query = "INSERT INTO tbl_user(unique_id,nama,email,encrypted_password,salt) VALUES ('$unique_id','$nama','$email','$encrypted_password','$salt')";
  $result = mysqli_query($conn, $query);
  if(!$result) {
    die("Query Failed.");
  }

  $_SESSION['message'] = 'Task Saved Successfully';
  $_SESSION['message_type'] = 'success';
  header('Location: index.php');
 
}

?>
  
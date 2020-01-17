<?php

include('db.php');

if (isset($_POST['savePengumuman'])) {
  $judul = $_POST['judul'];
  $isi = $_POST['isi'];

  $query = "INSERT INTO tbl_pengumuman(judul,isi) VALUES ('$judul','$isi')";
  $result = mysqli_query($conn, $query);
  if(!$result) {
    die("Query Failed.");
  }

  $_SESSION['message'] = 'Task Saved Successfully';
  $_SESSION['message_type'] = 'success';
  header('Location: pengumuman.php');
 
}

?>
  
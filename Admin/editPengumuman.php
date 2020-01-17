<?php
include("db.php");
// $title = '';
// $description= '';

if  (isset($_GET['id'])) {
  $id = $_GET['id'];
  $query = "SELECT * FROM tbl_pengumuman WHERE id=$id";
  $result = mysqli_query($conn, $query);
  if (mysqli_num_rows($result) == 1) {
    $row = mysqli_fetch_array($result);
    $judul = $row['judul'];
    $isi = $row['isi'];
  }
}

if (isset($_POST['update'])) {
  $id = $_GET['id'];
  $judul= $_POST['judul'];
  $isi = $_POST['isi'];

  $query = "UPDATE tbl_pengumuman set judul = '$judul', isi = '$isi' WHERE id=$id";
  mysqli_query($conn, $query);
  $_SESSION['message'] = 'Task Updated Successfully';
  $_SESSION['message_type'] = 'warning';
  header('Location: pengumuman.php');
}

?>
<?php include('includes/header.php'); ?>
<div class="container p-4">
  <div class="row">
    <div class="col-md-4 mx-auto">
      <div class="card card-body">
      <form action="editPengumuman.php?id=<?php echo $_GET['id']; ?>" method="POST">
        <div class="form-group">
          <input name="judul" type="text" class="form-control" value="<?php echo $judul; ?>" placeholder="Update Title">
        </div>

        <div class="form-group">
          <input name="isi" type="text" class="form-control" value="<?php echo $isi; ?>" placeholder="Update Title">
        </div>
        <button class="btn-success" name="update">Update</button>
      </form>
      </div>
    </div>
  </div>
</div>
<?php include('includes/footer.php'); ?>

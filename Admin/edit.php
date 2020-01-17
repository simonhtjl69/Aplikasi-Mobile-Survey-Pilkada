<?php
include("db.php");
// $title = '';
// $description= '';

if  (isset($_GET['id'])) {
  $id = $_GET['id'];
  $query = "SELECT * FROM tbl_user WHERE id=$id";
  $result = mysqli_query($conn, $query);
  if (mysqli_num_rows($result) == 1) {
    $row = mysqli_fetch_array($result);
    $unique_id = $row['unique_id'];
    $nama = $row['nama'];
    $email = $row['email'];
    $encrypted_password = $row['encrypted_password'];
    $salt = $row['salt'];
  }
}

if (isset($_POST['update'])) {
  $id = $_GET['id'];
  $unique_id= $_POST['unique_id'];
  $nama = $_POST['nama'];
  $email= $_POST['email'];
  $encrypted_password = $_POST['encrypted_password'];
  $salt = $_POST['salt'];

  $query = "UPDATE tbl_user set unique_id = '$unique_id', nama = '$nama',email = '$email', encrypted_password = '$encrypted_password',salt ='$salt' WHERE id=$id";
  mysqli_query($conn, $query);
  $_SESSION['message'] = 'Task Updated Successfully';
  $_SESSION['message_type'] = 'warning';
  header('Location: index.php');
}

?>
<?php include('includes/header.php'); ?>
<div class="container p-4">
  <div class="row">
    <div class="col-md-4 mx-auto">
      <div class="card card-body">
      <form action="edit.php?id=<?php echo $_GET['id']; ?>" method="POST">
        <div class="form-group">
          <input name="unique_id" type="text" class="form-control" value="<?php echo $unique_id; ?>" placeholder="Update Title">
        </div>

        <div class="form-group">
          <input name="nama" type="text" class="form-control" value="<?php echo $nama; ?>" placeholder="Update Title">
        </div>

        <div class="form-group">
          <input name="email" type="text" class="form-control" value="<?php echo $email; ?>" placeholder="Update Title">
        </div>
        <div class="form-group">
          <input name="encrypted_password" type="text" class="form-control" value="<?php echo $encrypted_password; ?>" placeholder="Update Title">
        </div>
          <div class="form-group">
          <input name="salt" type="text" class="form-control" value="<?php echo $salt; ?>" placeholder="Update Title">
        </div>
        <button class="btn-success" name="update">
          Update
</button>
      </form>
      </div>
    </div>
  </div>
</div>
<?php include('includes/footer.php'); ?>

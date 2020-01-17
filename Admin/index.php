<?php include("db.php"); ?>

<?php include('includes/header.php'); ?>

<main class="container p-4">
  <div class="row">
    <div class="col-md-4">
      <!-- MESSAGES -->

      <?php if (isset($_SESSION['message'])) { ?>
      <div class="alert alert-<?= $_SESSION['message_type']?> alert-dismissible fade show" role="alert">
        <?= $_SESSION['message']?>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <?php session_unset(); } ?>

      <!-- ADD TASK FORM -->
      <div class="card card-body">
        <form action="save_task.php" method="POST">
          <div class="form-group">
            <input type="text" name="unique_id" class="form-control" placeholder="Unique ID" autofocus>
          </div>

          <div class="form-group">
            <input type="text" name="nama" class="form-control" placeholder="Nama" autofocus>
          </div>

          <div class="form-group">
            <input type="text" name="email" class="form-control" placeholder="Email" autofocus>
          </div>

          <div class="form-group">
            <input type="text" name="encrypted_password" class="form-control" placeholder="Password" autofocus>
          </div>

          <div class="form-group">
            <input type="text" name="salt" class="form-control" placeholder="Salt" autofocus>
          </div>

          <input type="submit" name="save_task" class="btn btn-success btn-block" value="Save Task">
        </form>
      </div>

    </div>
    <div class="col-md-8">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>Unique ID</th>
            <th>nama</th>
            <th>Email</th>
            <th>Password</th>
            <th>Salt</th>
          </tr>
        </thead>
        <tbody>

          <?php
          $query = "SELECT * FROM tbl_user";
          $result_tasks = mysqli_query($conn, $query);    

          while($row = mysqli_fetch_assoc($result_tasks)) { ?>
          <tr>
            <td><?php echo $row['unique_id']; ?></td>
            <td><?php echo $row['nama']; ?></td>
            <td><?php echo $row['email']; ?></td>
            <td><?php echo $row['encrypted_password']; ?></td>
            <td><?php echo $row['salt']; ?></td>
            <td>
              <a href="edit.php?id=<?php echo $row['id']?>" class="btn btn-secondary">
                <i class="fas fa-marker"></i>
              </a>
              <a href="delete_task.php?id=<?php echo $row['id']?>" class="btn btn-danger">
                <i class="far fa-trash-alt"></i>
              </a>
            </td>
          </tr>
          <?php } ?>
        </tbody>
      </table>
    </div>
  </div>
</main>

<?php include('includes/footer.php'); ?>

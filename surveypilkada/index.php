<?php 
require __DIR__ . '/vendor/autoload.php';
require 'libs/NotORM.php'; 

use \Slim\App;

$app = new App();

$dbhost = '127.0.0.1';
$dbuser = 'root';
$dbpass = '';
$dbname = 'surveipilkada';
$dbmethod = 'mysql:dbname=';

$dsn = $dbmethod.$dbname;
$pdo = new PDO($dsn, $dbuser, $dbpass);
$db  = new NotORM($pdo);

$app-> get('/', function(){
    echo "API Survei Pilkada";
});


$app ->get('/pengumuman', function() use($app, $db){
    if ($db->tbl_pengumuman()->count() == 0) {
        $responseJson["error"] = true;
        $responseJson["message"] = "Belum ada pengumuman";
    } else {
        $responseJson["error"] = false;
        $responseJson["message"] = "Berhasil mendapatkan data pengumuman";
        foreach($db->tbl_pengumuman() as $data){
        $responseJson['semuapengumuman'][] = array(
            'id' => $data['id'],
            'judul' => $data['judul'],
            'isi' => $data['isi']
            );
        }
    }
    echo json_encode($responseJson);
});

$app->post('/pengumuman', function($request, $response, $args) use($app, $db){
    $pengumuman = $request->getParams();
    $result = $db->tbl_pengumuman->insert($pengumuman);

    $responseJson["error"] = false;
    $responseJson["message"] = "Berhasil menambahkan ke database";
    echo json_encode($responseJson);
});

$app->delete('/pengumuman/{id}', function($request, $response, $args) use($app, $db){
    $pengumuman = $db->tbl_pengumuman()->where('id', $args);
    if($pengumuman->fetch()){
        $result = $pengumuman->delete();
        echo json_encode(array(
            "error" => false,
            "message" => "Pengumuman berhasil dihapus"));
    }
    else{
        echo json_encode(array(
            "error" => true,
            "message" => "Pengumuman ID tersebut tidak ada"));
    }
});

//run App
$app->run();
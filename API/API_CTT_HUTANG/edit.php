<?php
 $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_hutang";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }

 if($_SERVER['REQUEST_METHOD'])
{
   $nm_penghutang=$_POST['nm_penghutang'];
   $catatan=$_POST['catatan'];
   $jumlah=$_POST['jumlah'];

   $query="UPDATE tb_hutang SET nm_penghutang='$nm_penghutang',catatan='$catatan',jumlah='$jumlah' WHERE id='$id'";
   
   $exeQuery=mysqli_query($konek,$query);
   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'data berhasil update'
   	)
   ):json_encode(array('kode'=>2,'pesan'=>'Datanya Gk Bisa Di Edit'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak nya gk valid'));
}

header('Content-Type: application/json');
?>
                     
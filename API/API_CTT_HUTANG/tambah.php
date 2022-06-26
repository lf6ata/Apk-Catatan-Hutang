<?php
  $server = "localhost";
   $username = "root";
   $password = "";
   $database = "db_hutang";

   $konek = mysqli_connect($server,$username,$password,$database);

   if (mysqli_connect_error()) {
      echo "Gagal konek dengan Database" . mysqli_connect_error();
   }

 if($_SERVER['REQUEST_METHOD']=='POST')
{
   $nm_penghutang=$_POST['nm_penghutang'];
   $catatan=$_POST['catatan'];
   $jumlah=$_POST['jumlah'];

   $query="INSERT INTO tb_hutang(nm_penghutang,catatan,jumlah) VALUES('$nm_penghutang','$catatan','$jumlah')";
   $exeQuery=mysqli_query($konek,$query);

   echo($exeQuery)?json_encode(
   	array(
   		'kode'=>1,
   		'pesan'=>'Data berhasi di tambahkan'

      )
   ):json_encode(array('kode'=>2,'pesan'=>'data gagal ditambahkan'));
}

else
{
    echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}

?>
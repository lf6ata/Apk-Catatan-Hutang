<?php

    $server = "localhost";
	$username = "root";
	$password = "";
	$database = "db_hutang";

   $konek = mysqli_connect($server,$username,$password,$database);

	if (mysqli_connect_error()) {
		echo "Gagal konek dengan Database" . mysqli_connect_error();
	}
 
$query="SELECT*FROM tb_hutang ORDER BY nm_penghutang";
$hasil=mysqli_query($konek,$query);
$array=array();

while($row=mysqli_fetch_assoc($hasil))
{
    $array[]=$row;
}
echo($hasil)?
json_encode(
	array(
		"kode"=>1,
		"hasil"=>$array
	)
):json_encode(
	array(
		"kode"=>0,
		"pesan"=>"data tidak ditemukan"
	)
);

header('Content-Type: application/json');
                         
?>
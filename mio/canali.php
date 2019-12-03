<?php
	$conn = mysqli_connect('localhost','root','','canali');
	if (mysqli_connect_errno($conn))
	{
		
		echo "<p>Errore di connessione</p>";
		die();
	}

	$whereQuery="";
	$query="SELECT* FROM programma ORDER BY nome";
	$result = mysqli_query($conn,$query);
	$num_rows = mysqli_num_rows($result);
	$jsonResult='';


if($num_rows>0){
		$jsonResult.='{"canali":[';
$cntrow=0;
while($row = mysqli_fetch_array($result) ){
	$canali = $row['canali'];
    	$programma = $row['programma'];
	$idprogramma = $row['idprogramma'];
if($cntrow ==0)
{
	$cntrow++;
}
else{
		$jsonResult.=',';
	}
$jsonResult.='{"idprogramma":"'.$idprogramma.'","canali":"'.$canali.'","programma":"'.$programma.'"}';
    
}
		$jsonResult.=']}';
}
//echo $jsonResult;
	echo $jsonResult;
	function my_htmlentities($var, $qs = ENT_COMPAT, $charset = 'ISO-8859-1')

{
    $search = array('ì', 'è', 'é', 'ò', 'à', 'ù');
    $replace = array('&igrave;', '&egrave;', '&eacute;', '&ograve;', '&agrave;', '&ugrave;');
    $var = str_replace($search, $replace, $var);
    $var = htmlentities($var, $qs, $charset, false);
    return $var;
}  

?>


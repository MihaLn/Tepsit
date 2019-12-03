<?php
	$conn = mysqli_connect('localhost','root','','registro');
	if (mysqli_connect_errno($conn))
	{
		
		echo "<p>Errore di connessione</p>";
		die();
	}

	$whereQuery="";
	$query="SELECT* FROM studente ORDER BY cognome";
	$result = mysqli_query($conn,$query);
	$num_rows = mysqli_num_rows($result);
	$jsonResult='';


if($num_rows>0){
		$jsonResult.='{"registro":[';
$cntrow=0;
while($row = mysqli_fetch_array($result) ){
	$Nome = $row['Nome'];
    	$Cognome = $row['Cognome'];
	$IDStudente = $row['IDStudente'];
if($cntrow ==0)
{
	$cntrow++;
}
else{
		$jsonResult.=',';
	}
$jsonResult.='{"IDStudente":"'.$IDStudente.'","Cognome":"'.$Cognome.'","Nome":"'.$Nome.'"}';
    
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


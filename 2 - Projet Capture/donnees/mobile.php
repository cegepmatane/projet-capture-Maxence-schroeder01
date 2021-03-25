<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);

    $usager = 'root';
    $motdepasse = 'password123';
    $hote = 'localhost';
    $base = 'meteo';

    $dsn = 'pgsql:dbname='.$base.';host=' . $hote;
    $basededonnees = new PDO($dsn, $usager, $motdepasse);

    //$SQL_MOYENNES = "SELECT * FROM temperature";
    $SQL_MOYENNES = "SELECT AVG(tauxtemperature) as moyenne FROM temperature
    WHERE date_part('year', moment) = date_part('year', moment)
    GROUP BY date_part('month',moment) LIMIT 1";
    $requete = $basededonnees->prepare($SQL_MOYENNES);
    $requete->execute();
    $moyennes = $requete->fetchAll(PDO::FETCH_OBJ);
    ?><?php

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';
    ?>

    <temperature>
        <mobile>

<?php
    //print_r($moyennes);
    foreach ($moyennes as $moyenne) 
    {
?>           
                <apercu>                	
	                    <mesureactuelle>56</mesureactuelle>
	                    <moyenne>
	                   		<journee>44</journee>  
	                    	<annee><?=round($moyenne->moyenne)?></annee>  
	                	</moyenne>
                </apercu>
<?php
    }
?>
        </mobile>
    </temperature>
<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);

    $usager = 'root';
    $motdepasse = 'password123';
    $hote = 'localhost';
    $base = 'meteo';

    $dsn = 'pgsql:dbname='.$base.';host=' . $hote;
    $basededonnees = new PDO($dsn, $usager, $motdepasse);

    //$SQL_LISTE_TEMPERATURE = "SELECT * FROM temperature";
    $SQL_LISTE_TEMPERATURE = "SELECT date_part('month',moment) as mois, MAX(tauxtemperature) as maximum, MIN(tauxtemperature) as minimum,
    AVG(tauxtemperature) as moyenne FROM temperature WHERE date_part('year', moment) = date_part('year', moment) 
    GROUP BY date_part('month',moment)";
    $requete = $basededonnees->prepare($SQL_LISTE_TEMPERATURE);
    $requete->execute();
    $humidites = $requete->fetchAll(PDO::FETCH_OBJ);
    ?><?php

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';
    ?>
    <temperature>
        <bureau>
            <annee>

<?php
    foreach ($temperature as $temperature) 
    {
?>         
                <mois>
	                <valeur><?=$temperature->mois?></valeur>
	                <min><?=$temperature->minimum?></min>
	                <moyenne><?=round($temperature->moyenne)?></moyenne>  
	                <max><?=$temperature->maximum?></max>  
	            </mois>           
<?php
    }
?>
            </annee>
        </bureau>
    </temperature>

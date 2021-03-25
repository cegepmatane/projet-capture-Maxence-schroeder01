<?php   

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "connection.php";
    
    //$SQL_LISTE_TEMPERATURE = "SELECT * FROM temperature";
    $SQL_LISTE_Temperature = "SELECT date_part('day',moment) as jour, MAX(tauxtemperature) as maximum, MIN(tauxtemperature) as minimum,
    AVG(tauxtemperature) as moyenne FROM temperature WHERE date_part('month', moment) = date_part('month', moment) 
    GROUP BY date_part('day',moment)";
    $requete = $basededonnees->prepare($SQL_LISTE_TEMPERATURE);
    $requete->execute();
    $temperature = $requete->fetchAll(PDO::FETCH_OBJ);

    $SQL_MOYENNES = "SELECT MAX(tauxtemperature) as maximum, MIN(tauxtemperature) as minimum, 
    AVG(tauxtemperature) as moyenne FROM temperature LIMIT 720";
    $requete2 = $basededonnees->prepare($SQL_MOYENNES);
    $requete2->execute();
    $moyennes = $requete2->fetchAll(PDO::FETCH_OBJ);
    ?><?php

    //print_r($moyennes);
    foreach ($moyennes as $moyenne) 
    {
    ?>
    <temperature>
        <bureau>
            <mois>
                <min><?=$moyenne->minimum?></min>
                <moyenne><?=round($moyenne->moyenne)?></moyenne>  
                <max><?=$moyenne->maximum?></max> 
<?php
    }
    foreach ($temperatures as $temperature) 
    {
?>         
                <jour>
                    <valeur><?=$temperatures->jour?></valeur>
                    <min><?=$temperature->minimum?></min>
                    <moyenne><?=round($moyenne->moyenne)?></moyenne>  
                    <max><?=$temperature->maximum?></max>  
                </jour>        
<?php
    }
?>
                </mois>
            </bureau>
    </temperature>

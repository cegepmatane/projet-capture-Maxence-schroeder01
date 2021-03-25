<?php

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "connection.php";
    //$SQL_LISTE_TEMPERATURE = "SELECT * FROM temperature";
    $SQL_LISTE_TEMPERATURE = "SELECT date_part('hour',moment) as heures, MAX(tauxtemperature) as maximum, MIN(tauxtemperature) as minimum,
    AVG(tauxtemperature) as moyenne FROM temperature WHERE date_part('day', moment) = date_part('day', moment) GROUP BY date_part('hour',moment)";
    $requete = $basededonnees->prepare($SQL_LISTE_TEMPERATURE);
    $requete->execute();
    $temperature = $requete->fetchAll(PDO::FETCH_OBJ);

    $SQL_MOYENNES = "SELECT MAX(tauxtemperature) as maximum, MIN(tauxtemperature) as minimum, 
    AVG(tauxtemperature) as moyenne FROM temperature LIMIT 24";
    $requete2 = $basededonnees->prepare($SQL_MOYENNES);
    $requete2->execute();
    $moyennes = $requete2->fetchAll(PDO::FETCH_OBJ);
    ?><?php

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';

    //print_r($moyennes);
    foreach ($moyennes as $moyenne) 
    {
    ?>    
        <temperature>
            <bureau>
                <jour>
                    <min><?=$moyenne->minimum?></min>
                    <moyenne><?=round($moyenne->moyenne)?></moyenne>  
                    <max><?=$moyenne->maximum?></max>  
<?php
    }
    //print_r($temperature);
    foreach ($temperature as $temperature) 
    {
?>             
                <heure>
                    <valeur><?=$temperature->heures?></valeur>
                    <min><?=$temperature->minimum?></min>
                    <moyenne><?=round($temperature->moyenne)?></moyenne>  
                    <max><?=$temperature->maximum?></max>  
                </heure>                  
<?php
    }
?>
        </jour>
    </bureau>     
</temperature>
<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);

    $usager = 'root';
    $motdepasse = 'password123';
    $hote = 'localhost';
    $base = 'meteo';

    $dsn = 'pgsql:dbname='.$base.';host=' . $hote;
    $basededonnees = new PDO($dsn, $usager, $motdepasse);

    $SQL_LISTE_TEMPERATURE = "SELECT tauxtemperature FROM temperature ORDER BY id ASC LIMIT 1";
    $requete = $basededonnees->prepare($SQL_LISTE_TEMPERATURE);
    $requete->execute();
    $temperatures = $requete->fetchAll();
    ?><?php

    header ("Content-Type:text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>'; 

    $valeurSeuil = 60;
    $activerAlerte = 0;

    if($temperatures >= $valeurSeuil){
        $activerAlerte = 1;
    }else{
        $activerAlerte = 0;
    }

    //print_r($temperatures);
    ?>
    
    <temperature>
        <mobile>
            <alerte><?=$activerAlerte?></alerte>  
	        <seuil><?=$valeurSeuil?></seuil>  
        </mobile>
    </temperature>
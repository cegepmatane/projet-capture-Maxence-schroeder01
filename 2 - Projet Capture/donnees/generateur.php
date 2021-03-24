<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);

    $usager = 'postgres';
    $motdepasse = 'testtest';
    $hote = 'localhost';
    $base = 'meteo';
    //$charset = 'utf8mb4'; // $charset = 'utf8';

    $dsn = "pgsql:host=$hote;dbname=$base;";
    $basededonnees = new PDO($dsn, $usager, $motdepasse);

    //$mesure = 100;
    //$heure = 1;
    
    
    $jourparmois = [31,28,31,30,31,30,31,31,30,31,30,31];
    
    for($mois = 1; $mois <=9; $mois++)
    {
        for($jour = 1; $jour < $jourparmois[$mois]; $jour++)
        {
            for($heure = 1; $heure <=12; $heure+=4)
            {
                $minutes = rand(1,15);
                $secondes = rand(1,60);
                $moment = "2020-$mois-$jour $heure:$minutes:$secondes";
                $mesure = rand(20,50);
                $SQL_AJOUTER_MESURE = "INSERT into radioactivite(mesure, moment) VALUES('$mesure','$moment')";
                echo $SQL_AJOUTER_MESURE;
                $requete = $basededonnees->prepare($SQL_AJOUTER_MESURE);
                $requete->execute();
            }
        }
    }
        
?>

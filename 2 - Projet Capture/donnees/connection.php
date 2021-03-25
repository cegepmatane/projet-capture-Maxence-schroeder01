<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);

    $usager = 'root';
    $motdepasse = 'password123';
    $hote = 'localhost';
    $base = 'meteo';

    $dsn = 'pgsql:dbname='.$base.';host=' . $hote;
    $basededonnees = new PDO($dsn, $usager, $motdepasse);
?>
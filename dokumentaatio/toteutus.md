# **Toteutusdokumentti**

## **Ohjelman rakenne**

Ohjelman runko koostuu luokista Maze, DeadendFiller, BreadthFirst ja Wallfollower. Tämän lisäksi ohjelma sisältää luokat itsetoteutetuille tietorakenteille, jotka ovat Tile, MazeQueue ja SimpleStack. Yksinkertainen luokka Tile mukailee Javan luokkaa Point. Tile kuvastaa yhtä labyrintin ruutua, joka on joko sallittu tilasiirtymä, ns. käytävä, tai seinä. MazeQueue on nimensämukaisesti jonorakenne, jota hyödynnetään osana leveyshakua. SimpleStack taas on yksinkertaistettu versio pinorakenteesta. Yksinkertaistus tarkoittaa lähinnä sitä, ettei rakenteelle ole toteutettu erillistä peek-metodia, koska sitä ei projektissa tarvita. Rakenteen käyttötarkoitus on tallettaa labyrintin umpikujat odottamaan käsittelyä (täyttämistä).

## **Algoritmien vertailu ja analyysi**

Ensimmäiset testit osoittivat, että DeadendFiller olisi odotetusti hitain ja leveyshaku keskimäärin nopein. Kuitenkin vaihtaessani omat tietorakenteeni algoritmeihin, huomasin, että etenkin leveyshaku hidastui merkittävästi. Vaikuttaisikin siltä, että näiden tietorakenteiden toteutuksissa on vielä hiomista, jotta vertailu tuottaisi "oikean" tuloksen.

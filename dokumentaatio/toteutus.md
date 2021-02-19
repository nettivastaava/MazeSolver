# **Toteutusdokumentti**

## **Ohjelman rakenne**

Ohjelman runko koostuu luokista Maze, DeadendFiller, BreadthFirst ja Wallfollower. Tämän lisäksi ohjelma sisältää luokat itsetoteutetuille tietorakenteille, jotka ovat Tile, MazeQueue ja SimpleStack. Yksinkertainen luokka Tile mukailee Javan luokkaa Point. Tile kuvastaa yhtä labyrintin ruutua, joka on joko sallittu tilasiirtymä, ns. käytävä, tai seinä. MazeQueue on nimensämukaisesti jonorakenne, jota hyödynnetään osana leveyshakua. SimpleStack taas on yksinkertaistettu versio pinorakenteesta. Yksinkertaistus tarkoittaa lähinnä sitä, ettei rakenteelle ole toteutettu erillistä peek-metodia, koska sitä ei projektissa tarvita. Rakenteen käyttötarkoitus on tallettaa labyrintin umpikujat odottamaan käsittelyä (täyttämistä).

## **Algoritmien vertailu ja analyysi**

Algoritmitmien alustavat toteutukset ovat vasta valmistuneet eikä vertailua ole päästy vielä toteuttamaan kovin laajasti. Alustavat testit viittaavat siihen, että leveyshaku on isossa osaa tapauksia nopein. Wallfollower vaikuttaa (odotetusti) olevan tehokas suoraviivaisissa labyrinteissä, joissa on vähän haarautumia. Olin olettanut, että DeadendFiller olisi ollut kaikissa tapauksissa hitain, mutta yllätyksekseni isossa labyrintissä se osoittautui tehokkaimmaksi. Onkin mahdollista, että algoritmien toteutuksissa on vielä vikoja, jotka "vääristävät" tuloksia.

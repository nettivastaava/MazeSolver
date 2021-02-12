# **Toteutusdokumentti**

## **Ohjelman rakenne**

Ohjelman runko koostuu luokista Maze, BreadthFirst ja Wallfollower. DeadendFiller on toistaiseksi osana Maze-luokkaa, mutta se on tarkoitus refaktoroida omaan luokkaansa pikimmiten. Tämän lisäksi ohjelma sisältää luokat itsetoteutetuille tietorakenteille, joita on tällä hetkellä Tile ja StackStructure. Myöhemmin tullaan myös toteuttamaan Javan luokkaa ArrayDeque mukaileva jonorakenne.

## **Algoritmien vertailu ja analyysi**

Algoritmitmien alustavat toteutukset ovat vasta valmistuneet eikä vertailua ole päästy vielä toteuttamaan kovin laajasti. Alustavat testit viittaavat siihen, että leveyshaku on isossa osaa tapauksia nopein. Wallfollower vaikuttaa (odotetusti) olevan tehokas suoraviivaisissa labyrinteissä, joissa on vähän haarautumia. Olin olettanut, että DeadendFiller olisi ollut kaikissa tapauksissa hitain, mutta yllätyksekseni isossa labyrintissä se osoittautui tehokkaimmaksi. Onkin mahdollista, että algoritmien toteutuksissa on vielä vikoja, jotka "vääristävät" tuloksia.

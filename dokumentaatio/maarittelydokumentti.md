# **Määrittelydokumentti**

- Opinto-ohjelma: Tietojenkäsittelytiede (kandidaatti)
- Ohjelmointikieli: Java

Projektini tulee toteuttamaan ja vertailemaan useampaa polunetsintäalgoritmia, jotka etsivät labyrintista lyhyimmän reitin ulos (tai vastaavasti pisteestä A pisteeseen B). Algoritmit toimivat labyrinteissä, jotka on kuvattu ASCII-merkeillä.

## **Algoritmi ja aikavaativuus**

Lyhyimmän reitin etsimisessä tullaan leveyshaun lisäksi käyttämään DeadendFiller ja Wallfollower-algoritmeja. DeadendFiller sisältää myös toteutuksen, jolla reitti voidaan löytää syklejä sisältävästä labyrintistä.

Leveyshaku ja Wallfollower ovat aikavaativuudeltaan O(n + m), missä n on solmujen ja m solmuja yhdistävien kaarten määrä. Tämä on todettavissa sillä, että algoritmit käsittelevät kunkin solmun ja kaaren korkeintaan kerran. 

Myös DeadendFiller on aikavaativuudeltaan samaa luokkaa O(n + m), vaikkei se algoritmin moniosaisuuden vuoksi välttämättä ole täysin ilmeistä. Ensiksi algoritmi käy läpi jokaisen labyrintin solmun ja kaaren tunnistaessaan umpikujia. Tämän jälkeen käydään läpi kaikki ruudut, jotka eivät kuulu reitille S-F. Lopuksi kuljetaan vielä polku S-F. Algoritmin sisältäessä peräkkäisiä osuuksia on kokonaisaikavaativuus vaativimman osuuden aikavaativuus, eli tässä tapauksessa O(n + m). Lisäksi on syytä huomioida, että DeadendFillerin parhain ja huonoin aikavaativuus ovat yksi ja sama, sillä algoritmi käsittelee aina jokaisen labyrintin solmun ja kaaren. 

## **Käytettävät tietorakenteet**

Itse labyrintti kuvataan kaksiulotteisella taulukolla, jossa jokaisen indeksin [i][j] sisältämä ASCII-merkki on joko sallittu tai kielletty tilasiirtymä. Niin ikään toisella kaksiulotteisella taulukolla pidetään kirjaa siitä, missä ruuduissa ollaan jo vierailtu. 

DeadendFiller-algoritmi tarvitsee lisäksi listarakenteen, jolla ylläpidetään luetteloa labyrintin umpikujista. Listalle tullaan lisäämään Javan luokkaa Point mukailevia olioita, joista saa helposti selville sijainnin labyrintissä.

Leveyshaussa tullaan lisäksi hyödyntämään jonorakennetta.

## **Syötteet ja tulosteet**

### **Syötteet**

- Tiedoston nimi, joka sisältää ASCII-merkeistä muodostetun labyrintin

### **Tulosteet**

- Lista tilasiirtymistä, jotka vaadittiin maaliruutuun pääsemiseksi. Esimerkiksi "Vasen, vasen, ylös, ylös, oikea". Lisäksi tulosteessa ilmoitetaan tarvittavien      siirtymien määrä kokonaislukuna.
- Labyrintin kuvaus ASCII-merkkeinä.
- DeadendFiller tulostaa lisäksi kuvauksen labyrintistä, jonka umpikujat on täytetty

#### **Lähteet**

- https://raw.githubusercontent.com/pllk/tirakirja/master/tirakirja.pdf
- https://en.wikipedia.org/wiki/Maze_solving_algorithm





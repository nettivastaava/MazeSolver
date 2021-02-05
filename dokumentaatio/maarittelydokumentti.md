# **Määrittelydokumentti**

- Opinto-ohjelma: Tietojenkäsittelytiede (kandidaatti)
- Ohjelmointikieli: Java

Projektini tulee toteuttamaan ja vertailemaan useampaa polunetsintäalgoritmia, jotka etsivät labyrintista lyhyimmän reitin ulos (tai vastaavasti pisteestä A pisteeseen B). Algoritmit toimivat labyrinteissä, jotka on kuvattu ASCII-merkeillä.

## **Algoritmi ja aikavaativuus**

Lyhyimmän reitin etsimisessä tullaan leveyshaun lisäksi käyttämään DeadendFiller ja Wallfollower-algoritmeja. On myös huomionarvoista, että DeadendFiller käyttää lopullisen reitin löytämiseen leveyshakua, jotta se toimisi myös syklejä sisältävissä labyrinteissä.labyrintin solmujen ja m solmuja yhdistävien kaarien määrä. Tämä on perusteltavissa sillä, että kukin solmu ja kaari käsitellään algoritmissa vain kerran.

Leveyshaku ja DeadendFollower ovat molemmat aikavaativuudeltaan O(n + m), missä n on 

## **Käytettävät tietorakenteet**

Itse labyrintti kuvataan kaksiulotteisella taulukolla, jossa jokaisen indeksin [i][j] sisältämä ASCII-merkki on joko sallittu tai kielletty tilasiirtymä. Niin ikään toisella kaksiulotteisella taulukolla pidetään kirjaa siitä, missä ruuduissa ollaan jo vierailtu. DeadendFiller-algoritmi tarvitsee lisäksi listarakenteen, jolla ylläpidetään luetteloa labyrintin umpikujista. Listalle tullaan lisäämään Javan luokkaa Point mukailevia olioita, joista saa helposti selville sijainnin labyrintissä.

## **Syötteet ja tulosteet**

### **Syötteet**

- Tiedoston nimi, joka sisältää ASCII-merkeistä muodostetun labyrintin
- Tiedostossa kuvatun labyrintin korkeus ja leveys kokonaislukuina

### **Tulosteet**

- Lista tilasiirtymistä, jotka vaadittiin maaliruutuun pääsemiseksi. Esimerkiksi "Vasen, vasen, ylös, ylös, oikea". Lisäksi tulosteessa ilmoitetaan tarvittavien      siirtymien määrä.
- Labyrintin kuvaus ASCII-merkkeinä.
- DeadendFiller tulostaa lisäksi kuvauksen labyrintistä, jonka umpikujat on täytetty

#### **Lähteet**

- https://raw.githubusercontent.com/pllk/tirakirja/master/tirakirja.pdf
- https://en.wikipedia.org/wiki/Maze_solving_algorithm





# **Määrittelydokumentti**

- Opinto-ohjelma: Tietojenkäsittelytiede (kandidaatti)
- Ohjelmointikieli: Java

Projektini tulee toteuttamaan ja vertailemaan useampaa polunetsintäalgoritmia, jotka etsivät labyrintista lyhyimmän reitin ulos (tai vastaavasti pisteestä A pisteeseen B). Algoritmit toimivat labyrinteissä, jotka on kuvattu ASCII-merkeillä.

## **Algoritmi ja aikavaativuus**

Lyhyimmän reitin etsimisessä tullaan leveyshaun lisäksi käyttämään DeadendFiller ja Wallfollower-algoritmeja.

## **Käytettävät tietorakenteet**

Itse labyrintti kuvataan kaksiulotteiselle taulukolla, jossa jokaisen indeksin [i][j] sisältämä ASCII-merkki on joko sallittu tai kielletty tilasiirtymä. Niin ikään toisella kaksiulotteiselle taulukolla pidetään kirjaa siitä, missä ruuduissa ollaan jo vierailtu. DeadendFiller-algoritmi tarvitsee lisäksi listarakenteen, jolla ylläpidetään luetteloa labyrintin umpikujista. Listalle tullaan lisäämään Javan luokkaa Point mukailevia olioita, joista saa helposti selville sijainnin labyrintissä.

## **Syötteet ja tulosteet**

### **Syötteet**

- Tiedoston nimi, joka sisältää ASCII-merkeistä muodostetun labyrintin
- Lähtö- ja maaliruutujen koordinaatit

### **Tulosteet**

- Lista tilasiirtymistä, jotka vaadittiin maaliruutuun pääsemiseksi. Esimerkiksi "Vasen, vasen, ylös, ylös, oikea". Lisäksi tulosteessa ilmoitetaan tarvittavien siirtymien määrä.

#### **Lähteet**

- https://raw.githubusercontent.com/pllk/tirakirja/master/tirakirja.pdf
- https://en.wikipedia.org/wiki/Maze_solving_algorithm





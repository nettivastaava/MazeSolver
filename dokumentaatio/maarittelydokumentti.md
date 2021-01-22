# **Määrittelydokumentti**

- Opinto-ohjelma: Tietojenkäsittelytiede (kandidaatti)
- Ohjelmointikieli: Java

Projektini tulee olemaan polunetsintäalgoritmi, joka etsii labyrintista lyhyimmän reitin ulos (tai vastaavasti pisteestä A pisteeseen B). Algoritmi toimii labyrinteissä, jotka on kuvattu ASCII-merkeillä.

## **Algoritmi ja aikavaativuus**

Lyhyimmän reitin etsimisessä tullaan käyttämään leveyshakua (BFS). Algoritmin aikavaativuus on O(n + m), missä n vastaa verkon solmujen ja m kaarien määrää. Aikavaativuus johtuu siitä, että algoritmi käsittelee jokaisen solmun ja kaaren korkeintaan yhden kerran.

## **Käytettävät tietorakenteet**

Itse labyrintti kuvataan kaksiulotteiselle taulukolla, jossa jokaisen indeksin [i][j] sisältämä ASCII-merkki on joko sallittu tai kielletty tilasiirtymä. Niin ikään toisella kaksiulotteiselle taulukolla pidetään kirjaa siitä, missä ruuduissa ollaan jo vierailtu. Itse leveyshaun toteuttamiseen tarvitaan myös jonorakennetta, johon vierailemattomat naapuriruudut lisätään odottamaan käsittelyvuoroaan.

## **Syötteet ja tulosteet**

### **Syötteet**

- Tiedoston nimi, joka sisältää ASCII-merkeistä muodostetun labyrintin
- Lähtö- ja maaliruutujen koordinaatit

### **Tulosteet**

- Lista tilasiirtymistä, jotka vaadittiin maaliruutuun pääsemiseksi. Esimerkiksi "Vasen, vasen, ylös, ylös, oikea". Lisäksi tulosteessa ilmoitetaan tarvittavien siirtymien määrä.

#### **Lähteet**

- https://raw.githubusercontent.com/pllk/tirakirja/master/tirakirja.pdf
- https://en.wikipedia.org/wiki/Breadth-first_search






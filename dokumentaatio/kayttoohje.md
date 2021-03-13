# **Käyttöohje**

Sovelluksessa on yksinkertainen tekstikäyttöliittymä, joka toimii seuraavalla tavalla:

1. Ensiksi käyttäjältä kysytään syötteenä tiedoston nimi, johon labyrintti on kuvattu. Sovelluksen saa suljettua tässä vaiheessa antamalla tiedoston nimeksi "quit". 
2. Mikäli kyseinen tiedosto löytyy, tulostetaan labyrintin kuvaus nähtäville.
3. Tämän jälkeen käyttäjältä kysytään, millä algoritmilla labyrintti halutaan ratkaista. Vaihtoehdot on listattuna numeroin 1-4.
4. Nyt käyttäjälle näytetään tulosteena ratkaisemiseen kulunut aika sekunteina, vaadittavat tilasiirtymät labyrintin ratkaisemiseen kyseisellä algoritmilla sekä tilasiirtymien määrä kokonaislukuna. Palataan kohtaan 1.

## **Komentorivikomennot**

#### Käynnistys
- Sovellus käynnistetään komennolla: mvn compile exec:java -Dexec.mainClass=mazesolver.ui.Main


#### Testaus
- Testit suoritetaan komennolla: mvn test
- Testikattavuusraportti luodaan komennolla: mvn test jacoco:report
  
#### Checkstyle
- Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla: mvn jxr:jxr checkstyle:checkstyle






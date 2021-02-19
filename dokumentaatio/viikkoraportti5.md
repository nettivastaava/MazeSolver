# **Viikko 5**

## **Viidennellä viikolla tapahtunutta**

- Jonorakenteen toteutus ja testit
- Refaktorointia
- Testien laajennuksia
- Omien tietorakenteiden liittäminen osaksi algoritmeja

Uutta koodia ei tällä viikolla tullut paljoakaan MazeQueue-luokkaa lukuunottamatta. Mielestäni projekti otti kuitenkin selviä askelia eteenpäin ja nyt olen toteuttanut käytännössä kaiken toiminnallisuuden mitä alussa määrittelin tarvittavaksi.

## **Kohdattuja ongelmia**
Huomasin nyt aloitettuani algoritmien vertailun kunnolla, että BFS hidastui melko paljon vaihdettuani Javan ArrayDeque-luokan omaan toteutukseeni. Nähdäkseni hitaus johtuu tavastani muuttaa jonossa käytettävän taulukon kokoa. Olen melko varma, että itse arvojen kopiointi uuteen taulukkoon on toteuttanu ainakin melko tehokkaasti. Arvelenkin, että joudun muuttamaan taulukon oletuskokoa ja ehtoja sen päivittämiseen, jottei operaatiota tarvitse tehdä niin usein. Helpoin ratkaisu olisi tietysti käyttää jo valmiiksi riittävän suurta taulukkoa, mutta tällöin haaskattaisiin muistia.

## **Seuraavan viikon tavoitteet**

Ensi viikolla tavoitteena on kirjoittaa laajemmat analyysit algoritmeista ja niiden vertailusta. Lisäksi aion kommentoida koodin kokonaisuudessaan.


# **Testausdokumentti**

Ohjelmaa varten on toteutettu automatisoituja yksikkötestejä JUnitilla. Tämän lisäksi ohjelmaa on testattu manuaalisesti järjestelmätasolla.

### **Testauskattavuus**

Testauksen ollessa valmis, on testien rivi- ja haaraumakattavuudet todella korkeat (85-95%). Myös manuaalisessa testauksessa on käytetty monipuolisesti erikokoisia ja sisältöisiä labyrinttejä.

### **Huomioita**

Algoritmien oikeellisuus on varmistettu tarkistamalla, että jokainen algoritmi tuottaa saman reitin samassa labyrintissä (poislukien wall follower ja yksinkertainen dead end filler syklillisissä labyrinteissä). Automaattiset testit kattavat vain pari tällaista tapausta, mutta manuaaliset testaukset käsittivät lähemmäs parikymmentä labyrinttiä erilaisilla reittivariaatioilla.


# **Testausdokumentti**

Ohjelmaa varten on toteutettu automatisoituja yksikkötestejä JUnitilla. Tämän lisäksi ohjelmaa on testattu manuaalisesti järjestelmätasolla.

### **Testauskattavuus**

Tällä hetkellä testauksen rivi- ja haaraumakattavuudet ovat melko korkeat: algoritmien osalta noin 70-90%. Tietorakenteille ei ole vielä toteutettu erillisiä JUnit-testejä, vaan niitä on testattu ainoastaan osana algoritmiä.

### **Ongelmat**

Toistaiseksi algoritmeja on testattu vain omatekoisilla, manuaalisesti luoduilla labyrinteilla, joten takeita toimivuudesta erikoistilanteissa ei ole.

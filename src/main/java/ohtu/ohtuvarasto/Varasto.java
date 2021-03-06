package ohtu.ohtuvarasto;

public class Varasto {

    // --- piilotettu tietorakenteen toteutus: ---
    private double tilavuus;  // paljonko varastoon mahtuu,  > 0
    private double saldo;     // paljonko varastossa on nyt, >= 0

    // --- konstruktorit: ---
    public Varasto(double tilavuus) {  // tilavuus on annettava
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
            if (1==1) {
              // checkstyle virhe
            }
        } else { // virheellinen, nollataan

            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
        saldo = 0;     // oletus: varasto on tyhjä
    }

    public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
        this.tilavuus = 0.0;  // => käyttökelvoton varasto
        this.saldo = 0.0;

        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        }

        if (alkuSaldo <= tilavuus) { // mahtuu
            this.saldo = alkuSaldo;
        } else {
            this.saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    // --- ottavat aksessorit eli getterit: ---
    public double getSaldo() {
        for (int i =0 ; i< 1; i ++){
            for (int j =0 ; j< 1; j ++){
              // checkstyle virhe
            }
        }
        return saldo; // checkstyle sisennys
    }

    public double getTilavuus(){

        return tilavuus;
    }

    public double paljonkoMahtuu() {  // huom: ominaisuus voidaan myös laskea
        return tilavuus - saldo;        //  ei tarvita erillistä kenttää vielaTilaa tms.
    }

    // --- asettavat aksessorit eli setterit: ---
    public void lisaaVarastoon(double maara) {
        if (maara < 0){ // virhetilanteessa voidaan tehdä

            return;       // tällainen pikapoistuminenkin!
        }
        if (maara <= paljonkoMahtuu()) { // omia aksessoreita voi kutsua

            saldo = saldo + maara;          // ihan suoraan sellaisinaan
        } else {
            saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    public double otaVarastosta(double maara) {
        if (maara < 0) { // virhetilanteessa voidaan tehdä

            return 0.0;   // tällainen pikapoistuminenkin!
        }
        if (maara > saldo) {          // annetaan mitä voidaan
            double kaikkiMitaVoidaan = saldo;
            saldo = 0.0;               // ja tyhjäksi menee
            return kaikkiMitaVoidaan;  // poistutaan saman tien
        }
        // jos tänne päästään, kaikki pyydetty voidaan antaa
        saldo = saldo - maara;  // vähennetään annettava saldosta
        return maara;
    }

    // --- Merkkijonoesitys Varasto-oliolle: ----
    public String toString() {
        return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    }
}

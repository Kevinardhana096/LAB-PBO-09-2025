class Peluru {
    int kaliber;
    double panjangPeluru;

    public String getPeluru() {
        return "Kaliber: " + kaliber + ", Panjang: " + panjangPeluru + " mm";
    }
}

public class Senjata {
    String namaSenjata;
    Peluru peluru = new Peluru();
    double damageTembakan = 35;

    public String getNamaSenjata() {
        return namaSenjata;
    }

    public void setNamaSenjata(String namaSenjata) {
        this.namaSenjata = namaSenjata;
    }

    public double getDamageTembakan(String target) {
        if (target.equals("Kepala")) {
            return (peluru.kaliber / 10.0) + damageTembakan + 10;
        } else if (target.equals("Badan")) {
            return (peluru.kaliber / 10.0) + damageTembakan + 5;
        } else {
            return (peluru.kaliber / 10.0) + damageTembakan;
        }
    }

    public double getDamageTembakan() {
        return (peluru.kaliber / 10.0) + damageTembakan;
    }

    public void setDamageTembakan(int damageTembakan) {
        this.damageTembakan = damageTembakan;
    }
}

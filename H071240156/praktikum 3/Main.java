public class Main {
    public static void main(String[] args) {
        //KASUS 1
        System.out.println("KASUSU 1");
        Detektif d1 = new Detektif("Dewi", "senior");
        Kasus  k1 = new Kasus("korupsi", "sulit", 0, d1);
        k1.setProgres(d1.getEfektivitas());
        

        AlatInvestigasi alatk1 = new AlatInvestigasi( "pembukuan tidak konsisten", 20);
        Informan inf1 = new Informan("Indi", "rekan kerja", 20);
        Informan inf2 = new Informan("naca", "audit", 30);
        k1.setProgres(inf1.getEfektivitas());
        k1.setProgres(inf2.getEfektivitas());
        k1.setProgres(alatk1.getEfektivitas());
        k1.tampilkanStatus();

        //KASUS 2
        System.out.println("KASUS 2");
        Detektif d2 = new Detektif("Kiya", "junior");
        Kasus k2 = new Kasus("korupsi pabrik", "sulit", 0, d2);
        k2.setProgres(d2.getEfektivitas());
    

        AlatInvestigasi alat2 = new AlatInvestigasi("mobil dinas", 20);
        Informan informan1 = new Informan("penjual mobil", "terlihat membeli menggunakan kartu perusahaan", 30);
        k2.setProgres(alat2.getEfektivitas());
        k2.setProgres(informan1.getEfektivitas());
        k2.tampilkanStatus();

        k2.bandingkanDengan(k1);


    }
}

public class Pelindung {
    String badan;
    String kepala;

    public String getPelindung(){
        return "Kepala: " + kepala + ", Badan: " + badan;
    }

    public int getDef(int random){
        if (random == 0){
            if (badan.equalsIgnoreCase("Rompi Anti Peluru")){
                return 6;
            } else {
                return 3;
            }
        } else {
            if (kepala.equalsIgnoreCase("Fedora")){
                return 4;
            } else {
                return 2;
            }
        }
    }
}
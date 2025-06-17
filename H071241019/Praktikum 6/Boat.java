public class Boat extends Kendaraan implements iBergerak {
    private String jenisPerahu;
    private double dayaMesin;
    private double kecepatan;

    public Boat(String merek, String model) {
        super(merek, model);
    }

    public String getJenisPerahu() {
        return jenisPerahu;
    }

    public void setJenisPerahui(String jenisPerahu) {
        this.jenisPerahu = jenisPerahu;
    }

    public double getDayaMesin() {
        return dayaMesin;
    }

    public void setDayaMesin(double dayaMesin) {
        this.dayaMesin = dayaMesin;
    }

    @Override
    public double hitungPajak() {
        return dayaMesin * 1000;
    }

    @Override
    public boolean mulai() {
        return true;
    }

    @Override
    public boolean berhenti() {
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public String getTipeKendaraan() {
        return "Boat";
    }
}

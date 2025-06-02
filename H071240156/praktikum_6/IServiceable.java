package praktikum_6;

import java.util.Date;

public interface IServiceable {
    boolean periksaKondisi();

    void lakukanService();

    Date getWaktuServiceBerikutnya();

    double hitungBiayaService();
}
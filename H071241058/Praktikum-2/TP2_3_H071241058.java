class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        // Lengkapi
        return height * width * length;
    }
}

public class TP2_3_H071241058 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        // Lengkapi
        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30;

        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}


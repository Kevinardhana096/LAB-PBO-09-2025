class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
       return height * width * length; 
    }
}

public class Task3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 15;
        cuboid.width = 10;
        cuboid.length = 30;
        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}

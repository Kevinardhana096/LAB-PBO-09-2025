class Cuboid{
    double height;
    double widht;
    double length;
    
    double getVolume(){
        return height*length*widht;
    }
}
public class t2n3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height=10;
        cuboid.length=30;
        cuboid.widht=15;
        // System.out.println(format:"Volume = %2.f",cuboid.getVolume());
        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}

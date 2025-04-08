public class Main{
    double height;
    double width;
    double length;
    
    double getVolume(){
        //lengkapi
        return height*width*length;
    }
    public static void main(String[] args) {
        Main cuboid = new Main();
        //lengkapi
        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30;
        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}

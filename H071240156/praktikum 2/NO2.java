public class NO2 {
    private String id;
    private String name;
    private int stock;
    private double price;

    public void setProduct(String id, String name, int stock, double price){
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getProductInfo(){
        return "ID: " + id + "\n"
        + "Nama: " + name + "\n"
        + "Stock: " + stock + "\n"
        + "price: " + price;
    }

    public boolean isAvailable(){
        return stock > 0;
    }
    
    public static void main(String[] args) {
        NO2 p = new NO2();

        p.setProduct("X001", "Book", 70, 5000);

        if (p.isAvailable()){
            System.out.println("Status: Stock produk masih tersedia");
        } else {
            System.out.println("Status: stock produk kosong");
        }
    }
}

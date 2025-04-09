import java.util.ArrayList;

public class TP2_2_H071241058 {
    String productId;
    String productName;
    int stock;
    double price;

    public TP2_2_H071241058(String productId, String productName, int stock, double price) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.price = price;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void displayProductInfo() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Stock        : " + stock);
        System.out.println("Price        : " + price);
        System.out.println("Available    : " + (isAvailable() ? "In Stock" : "Out of Stock"));
    }

    private static ArrayList<TP2_2_H071241058> products = new ArrayList<>();

    public static void addProduct(String productId, String productName, int stock, double price) {
        TP2_2_H071241058 product = new TP2_2_H071241058(productId, productName, stock, price);
        products.add(product);
    }

    public static void displayAllProducts() {
        for (TP2_2_H071241058 product : products) {
            product.displayProductInfo();
            System.out.println("-------------------------");
        }
    }

    public static String checkProductById(String id) {
        for (TP2_2_H071241058 product : products) {
            if (product.productId.equals(id)) {
                return product.isAvailable() ? "Iya" : "Tidak";
            }
        }
        return  "Produk tidak ditemukan"; 
    }

    public static void main(String[] args) {

        addProduct("P001", "Laptop", 10, 7500000);
        addProduct("P002", "Mouse", 0, 150000);
        addProduct("P003", "Keyboard", 5, 300000);

        System.out.println("=== List Produk ===");
        displayAllProducts();

        System.out.println("Apakah produk dengan ID P001 tersedia? " + checkProductById("P001"));
        System.out.println("Apakah produk dengan ID P002 tersedia? " + checkProductById("P002"));
        System.out.println("Apakah produk dengan ID P004 tersedia? " + checkProductById("P004"));
    }
}

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public String getName(){
        return this.name;
    }

    public int getMemberId(){
        return this.memberId;
    }

    public Member(String name, int memberId){
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days){
        if (item.isBorrowed()){
            throw new IllegalArgumentException("Item sudah dipinjam");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        LibraryLogger logger = new LibraryLogger();
        logger.logActivity("Anggota " + name + " (ID: " + memberId + ") meminjam " + item.getTitle());
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate){
        if (!borrowedItems.contains(item)){
            return "Item tidak ditemukan dalam daftar pinjaman";
        }
        String result = item.returnItem();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public void getBorrowedItems(){
        if (borrowedItems.isEmpty()){
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+-----+----------------------+");
        System.out.println("| ID  | Judul                |");
        System.out.println("+-----+----------------------+");

        for (LibraryItem item : borrowedItems){
            System.out.printf("| %-3d | %-20s |\n", item.itemId, item.title);
        }

        System.out.println("+-----+----------------------+");
    }

    
}

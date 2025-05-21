import java.util.*;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) throw new IllegalStateException("Item tidak tersedia.");
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) return "Item tidak ditemukan dalam daftar pinjaman";
        borrowedItems.remove(item);
        String result = item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + (int) fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        } else {
            for (LibraryItem item : borrowedItems) {
                System.out.println(item.getDescription());
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}

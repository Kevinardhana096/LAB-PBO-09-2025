import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem() {
        isBorrowed = false;
        return title + " dikembalikan";
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }
}

class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed || days > 14) {
            throw new IllegalArgumentException("Peminjaman tidak valid");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000.0;
    }

    public void printBooks() {
        System.out.println(getDescription());
    }
}

class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed || days > 7) {
            throw new IllegalArgumentException("Peminjaman tidak valid");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000.0;
    }
}

class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item sudah dipinjam");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            throw new IllegalArgumentException("Item tidak sedang dipinjam oleh member ini");
        }
        double fine = item.calculateFine(daysLate);
        borrowedItems.remove(item);
        item.returnItem();
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + (int)fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        } else {
            System.out.println("+-----+----------------------+\n| ID  | Judul               |\n+-----+----------------------+");
            for (LibraryItem item : borrowedItems) {
                System.out.printf("| %-3d | %-20s |\n", item.getItemId(), item.getTitle());
            }
            System.out.println("+-----+----------------------+\n");
        }
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}

class LibraryLogger {
    private List<String> logs;

    public LibraryLogger() {
        logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String log = timestamp + " " + activity;
        logs.add(log);
        return log;
    }

    public String getLogs() {
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}

class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream().filter(i -> i.getItemId() == itemId)
                .findFirst().orElseThrow(NoSuchElementException::new);
    }

    public String getLibraryStatus() {
        StringBuilder status = new StringBuilder();
        status.append("+-----+----------------------+-----------+\n");
        status.append("| ID  | Judul               | Status    |\n");
        status.append("+-----+----------------------+-----------+\n");
        for (LibraryItem item : items) {
            status.append(String.format("| %-3d | %-20s | %-9s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    item.isBorrowed() ? "Dipinjam" : "Tersedia"));
        }
        status.append("+-----+----------------------+-----------+\n");
        return status.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member getMemberById(int memberId) {
        return members.stream().filter(m -> m.getMemberId() == memberId)
                .findFirst().orElseThrow(NoSuchElementException::new);
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Masukkan tipe item (book/dvd): ");
                        String type = scanner.nextLine();
                        System.out.print("Judul: ");
                        String title = scanner.nextLine();
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        if (type.equalsIgnoreCase("book")) {
                            System.out.print("Author: ");
                            String author = scanner.nextLine();
                            library.addItem(new Book(title, id, author));
                        } else {
                            System.out.print("Durasi (menit): ");
                            int duration = scanner.nextInt();
                            scanner.nextLine();
                            library.addItem(new DVD(title, id, duration));
                        }
                        break;
                    case 2:
                        System.out.print("Nama anggota: ");
                        String name = scanner.nextLine();
                        System.out.print("ID anggota: ");
                        int memberId = scanner.nextInt();
                        scanner.nextLine();
                        library.addMember(new Member(name, memberId));
                        break;
                    case 3:
                        System.out.print("ID anggota: ");
                        int memId = scanner.nextInt();
                        System.out.print("ID item: ");
                        int itemId = scanner.nextInt();
                        System.out.print("Jumlah hari pinjam: ");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        Member member = library.getMemberById(memId);
                        LibraryItem item = library.findItemById(itemId);
                        System.out.println(member.borrow(item, days));
                        library.getLogger().logActivity(item.getTitle() + " dipinjam oleh " + member.getName());
                        break;
                    case 4:
                        System.out.print("ID anggota: ");
                        int mId = scanner.nextInt();
                        System.out.print("ID item: ");
                        int iId = scanner.nextInt();
                        System.out.print("Jumlah hari keterlambatan: ");
                        int late = scanner.nextInt();
                        scanner.nextLine();
                        Member m = library.getMemberById(mId);
                        LibraryItem it = library.findItemById(iId);
                        System.out.println(m.returnItem(it, late));
                        library.getLogger().logActivity(it.getTitle() + " dikembalikan oleh " + m.getName());
                        break;
                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;
                    case 6:
                        System.out.println(library.getAllLogs());
                        break;
                    case 7:
                        System.out.print("ID anggota: ");
                        int idAnggota = scanner.nextInt();
                        scanner.nextLine();
                        Member mem = library.getMemberById(idAnggota);
                        mem.getBorrowedItems();
                        break;
                    case 8:
                        System.out.println("Terima kasih telah menggunakan sistem.");
                        return;
                    default:
                        System.out.println("Menu tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> tambahItem();
                case 2 -> tambahAnggota();
                case 3 -> pinjamItem();
                case 4 -> kembalikanItem();
                case 5 -> library.getLibraryStatus();
                case 6 -> System.out.println(library.getLogger().getLogs());
                case 7 -> lihatItemAnggota();
                case 8 -> System.out.println("Keluar dari sistem.");
                default -> System.out.println("Pilihan tidak valid.");
            }
            System.out.println();
        } while (choice != 8);
    }

    private static void tambahItem() {
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        System.out.print("Pilih jenis item: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Judul: ");
        String judul = scanner.nextLine();

        System.out.print("ID item: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        LibraryItem item = null;

        if (jenis == 1) {
            System.out.print("Penulis: ");
            String penulis = scanner.nextLine();
            item = new Book(judul, id, penulis);
        } else if (jenis == 2) {
            System.out.print("Durasi (menit): ");
            int durasi = scanner.nextInt();
            scanner.nextLine();
            item = new DVD(judul, id, durasi);
        }

        if (item != null) {
            System.out.println(library.addItem(item));
        }
    }

    private static void tambahAnggota() {
        System.out.print("ID Anggota: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Anggota: ");
        String nama = scanner.nextLine();

        Member m = new Member(nama, id);
        library.addMember(m);
        library.getLogger().logActivity("Anggota " + nama + " ditambahkan");
        System.out.println("Anggota berhasil ditambahkan.");
    }

    private static void pinjamItem() {
        System.out.print("ID Anggota: ");
        int idAnggota = scanner.nextInt();

        System.out.print("ID Item: ");
        int idItem = scanner.nextInt();

        System.out.print("Jumlah Hari: ");
        int hari = scanner.nextInt();
        scanner.nextLine();

        try {
            Member m = library.findMemberById(idAnggota);
            LibraryItem item = library.findItemById(idItem);
            String result = m.borrow(item, hari);
            library.getLogger().logActivity(item.getDescription() + " dipinjam oleh " + m.getName());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Gagal meminjam: " + e.getMessage());
        }
    }

    private static void kembalikanItem() {
        System.out.print("ID Anggota: ");
        int idAnggota = scanner.nextInt();

        System.out.print("ID Item: ");
        int idItem = scanner.nextInt();

        System.out.print("Jumlah hari keterlambatan: ");
        int telat = scanner.nextInt();
        scanner.nextLine();

        try {
            Member m = library.findMemberById(idAnggota);
            LibraryItem item = library.findItemById(idItem);
            String result = m.returnItem(item, telat);
            library.getLogger().logActivity(item.getDescription() + " dikembalikan oleh " + m.getName());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Gagal mengembalikan: " + e.getMessage());
        }
    }

    private static void lihatItemAnggota() {
        System.out.print("ID Anggota: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            Member m = library.findMemberById(id);
            m.getBorrowedItems();
        } catch (Exception e) {
            System.out.println("Anggota tidak ditemukan.");
        }
    }
}

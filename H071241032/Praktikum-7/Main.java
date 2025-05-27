import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice = 0; // Inisialisasi variabel choice

        do {
            displayMenu();
            try {
                System.out.print("Pilih opsi: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        addItem(library, scanner);
                        break;
                    case 2:
                        addMember(library, scanner);
                        break;
                    case 3:
                        borrowItem(library, scanner);
                        break;
                    case 4:
                        returnItem(library, scanner);
                        break;
                    case 5:
                        viewLibraryStatus(library);
                        break;
                    case 6:
                        viewLogActivity(library);
                        break;
                    case 7:
                        viewBorrowedItemsByMember(library, scanner);
                        break;
                    case 8:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Opsi tidak valid. Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine(); 
                choice = 0; 
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

            System.out.println();

        } while (choice != 8);

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }
    public static void addItem(Library library, Scanner scanner) {
        try {
            System.out.print("Jenis item (1: Buku, 2: DVD): ");
            int itemType = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Judul: ");
            String title = scanner.nextLine();

            System.out.print("ID Item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine(); 

            if (itemType == 1) {
                System.out.print("Penulis: ");
                String author = scanner.nextLine();
                Book book = new Book(title, itemId, author);
                library.addItem(book);
                library.getLogger().logActivity(title + " berhasil ditambahkan");
                System.out.println("Item berhasil ditambahkan");
            } else if (itemType == 2) {
                System.out.print("Durasi (menit): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); 
                DVD dvd = new DVD(title, itemId, duration);
                library.addItem(dvd);
                library.getLogger().logActivity(title + " berhasil ditambahkan");
                System.out.println("Item berhasil ditambahkan");
            } else {
                System.out.println("Jenis item tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka untuk ID dan Durasi.");
            scanner.nextLine(); 
        }
    }

    public static void addMember(Library library, Scanner scanner) {
        System.out.print("Nama Anggota: ");
        String name = scanner.nextLine();
        System.out.print("ID Anggota: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        Member member = new Member(name, memberId);
        library.addMember(member);
        library.getLogger().logActivity("Anggota " + name + " ditambahkan");
        System.out.println("Anggota berhasil ditambahkan");
    }

    public static void borrowItem(Library library, Scanner scanner) {
        try {
            System.out.print("ID Anggota: ");
            int memberId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("ID Item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Jumlah hari peminjaman: ");
            int days = scanner.nextInt();
            scanner.nextLine(); 

            Member member = null;
            for (Member m : library.getMembers()) {
                if (m.getMemberId() == memberId) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                System.out.println("Anggota dengan ID " + memberId + " tidak ditemukan.");
                return;
            }


            LibraryItem item = library.findItemById(itemId);
            String borrowResult = member.borrow(item, days);
            System.out.println("Item " + item.getTitle() + " berhasil dipinjam selama " + days + " hari");
            library.getLogger().logActivity("Buku : " + item.getDescription() + " dipinjam oleh " + member.getName());

        } catch (NoSuchElementException e) {
            System.out.println("Item tidak ditemukan.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void returnItem(Library library, Scanner scanner) {
        try {
            System.out.print("ID Anggota: ");
            int memberId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("ID Item: ");
            int itemId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Jumlah hari keterlambatan: ");
            int daysLate = scanner.nextInt();
            scanner.nextLine(); 

            Member member = null;
            for (Member m : library.getMembers()) {
                if (m.getMemberId() == memberId) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                System.out.println("Anggota dengan ID " + memberId + " tidak ditemukan.");
                return;
            }

            LibraryItem item = library.findItemById(itemId);
            String returnResult = member.returnItem(item, daysLate);
            System.out.println(returnResult);
            library.getLogger().logActivity("Buku : " + item.getDescription() + " dikembalikan oleh " + member.getName());

        } catch (NoSuchElementException e) {
            System.out.println("Item tidak ditemukan.");
        }

    }

    public static void viewLibraryStatus(Library library) {
        System.out.println("-------------------------");
        System.out.println("| ID Item | Judul | Status |");
        System.out.println("-------------------------");
        System.out.print(library.getLibraryStatus());
        System.out.println("-------------------------");
    }

    public static void viewLogActivity(Library library) {
        System.out.println(library.getAllLogs());
    }

    public static void viewBorrowedItemsByMember(Library library, Scanner scanner) {
        try {
            System.out.print("ID Anggota: ");
            int memberId = scanner.nextInt();
            scanner.nextLine(); 

            Member member = null;
            for (Member m : library.getMembers()) {
                if (m.getMemberId() == memberId) {
                    member = m;
                    break;
                }
            }
            if (member == null) {
                System.out.println("Anggota dengan ID " + memberId + " tidak ditemukan.");
                return;
            }

            System.out.println("------------------");
            System.out.println("| ID Item | Judul |");
            System.out.println("------------------");
            member.getBorrowedItems();
            System.out.println("------------------");

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka untuk ID anggota.");
            scanner.nextLine();
        }
    }
}
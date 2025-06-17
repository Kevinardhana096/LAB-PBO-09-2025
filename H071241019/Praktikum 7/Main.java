import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Map<Integer, Member> memberMap = new HashMap<>();

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
            scanner.nextLine(); // flush newline

            try {
                switch (choice) {
                    case 1: 
                        System.out.println("Pilih jenis item:\n1. Buku\n2. DVD");
                        int itemType = Integer.parseInt(scanner.nextLine());

                        System.out.print("Masukkan Judul: ");
                        String title = scanner.nextLine();

                        System.out.print("Masukkan ID: ");
                        int itemId = Integer.parseInt(scanner.nextLine());


                
                        if (itemType == 1) {
                        System.out.print("Masukkan Penulis: ");
                        String author = scanner.nextLine();
                        Book book = new Book(title, itemId, author);
                        System.out.println(library.addItem(book));

                        } else if (itemType == 2) {
                        System.out.print("Masukkan Durasi (menit): ");
                        int duration = Integer.parseInt(scanner.nextLine());
                        DVD dvd = new DVD(title, itemId, duration);
                        System.out.println(library.addItem(dvd));
                        }
                        else {
                        System.out.println("Jenis item tidak valid.");
                        }
                        break;
  

                    case 2:
                        System.out.print("Masukkan ID Anggota: ");
                        int memberId = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Masukkan Nama Anggota: ");
                        String name = scanner.nextLine();
                        Member member = new Member(name, memberId);
                        memberMap.put(memberId, member);
                        library.addMember(member);
                        System.out.println("Anggota berhasil ditambahkan.");
                        break;

                    case 3:
                        System.out.print("Masukkan ID Anggota: ");
                        int borrowerId = scanner.nextInt();
                        System.out.print("Masukkan ID Item: ");
                        int borrowitemId = scanner.nextInt();
                        System.out.print("Masukkan Durasi Pinjam (hari): ");
                        int days = scanner.nextInt();

                        Member borrower = memberMap.get(borrowerId);
                        LibraryItem item = library.findItemById(borrowitemId);
                        System.out.println(borrower.borrow(item, days));
                        break;

                    case 4:
                        System.out.print("Masukkan ID Anggota: ");
                        int returnerId = scanner.nextInt();
                        System.out.print("Masukkan ID Item: ");
                        int returnItemId = scanner.nextInt();
                        System.out.print("Masukkan Keterlambatan (hari): ");
                        int daysLate = scanner.nextInt();

                        Member returner = memberMap.get(returnerId);
                        LibraryItem returnItem = library.findItemById(returnItemId);
                        System.out.println(returner.returnItem(returnItem, daysLate));
                        break;

                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(library.getAllLogs());
                        break;

                    case 7:
                        System.out.print("Masukkan ID Anggota: ");
                        int checkId = scanner.nextInt();
                        Member m = memberMap.get(checkId);
                        m.getBorrowedItems();
                        break;

                    case 8:
                        System.out.println("Terima kasih telah menggunakan sistem.");
                        return;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println(); 

            //scanner.close();
        }
    }
}

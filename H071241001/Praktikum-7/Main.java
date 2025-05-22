import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int itemCounter = 1, memberCounter = 1;

        while (true) {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item\n2. Tambah Anggota\n3. Pinjam Item\n4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan\n6. Lihat Log Aktivitas\n7. Lihat Item yang Dipinjam Anggota\n8. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi;
            if (sc.hasNextInt()) {
                opsi = sc.nextInt(); sc.nextLine();
            } else {
                System.out.println("Input tidak valid. Masukkan angka.");
                sc.nextLine(); // buang input yang salah
                continue;
            }


            try {
                if (opsi == 1) {
                    System.out.print("Jenis item (1: Buku, 2: DVD): ");
                    int jenis = sc.nextInt(); sc.nextLine();
                    System.out.print("Judul: ");
                    String judul = sc.nextLine();
                    if (jenis == 1) {
                        System.out.print("Penulis: ");
                        String penulis = sc.nextLine();
                        lib.addItem(new Book(judul, itemCounter++, penulis));
                    } else {
                        System.out.print("Durasi (menit): ");
                        int durasi = sc.nextInt(); sc.nextLine();
                        lib.addItem(new DVD(judul, itemCounter++, durasi));
                    }
                } else if (opsi == 2) {
                    System.out.print("Nama Anggota: ");
                    String nama = sc.nextLine();
                    System.out.println(lib.addMember(new Member(nama, memberCounter++)));
                } else if (opsi == 3) {
                    System.out.print("ID Item: ");
                    int idItem = sc.nextInt();
                    System.out.print("ID Anggota: ");
                    int idAnggota = sc.nextInt();
                    System.out.print("Jumlah hari peminjaman: ");
                    int hari = sc.nextInt(); sc.nextLine();

                    LibraryItem item = lib.findItemById(idItem);
                    Member m = lib.findMemberById(idAnggota);
                    String hasil = m.borrow(item, hari);
                    lib.getLogger().logActivity(item.getDescription() + " dipinjam oleh " + m.getName());
                    System.out.println(hasil);

                } else if (opsi == 4) {
                    System.out.print("ID Item: ");
                    int idItem = sc.nextInt();
                    System.out.print("ID Anggota: ");
                    int idAnggota = sc.nextInt();
                    System.out.print("Jumlah hari keterlambatan: ");
                    int terlambat = sc.nextInt(); sc.nextLine();

                    LibraryItem item = lib.findItemById(idItem);
                    Member m = lib.findMemberById(idAnggota);
                    String hasil = m.returnItem(item, terlambat);
                    lib.getLogger().logActivity(item.getDescription() + " dikembalikan oleh " + m.getName());
                    System.out.println(hasil);

                } else if (opsi == 5) {
                    System.out.println(lib.getLibraryStatus());
                } else if (opsi == 6) {
                    System.out.println(lib.getLogger().getLogs());
                } else if (opsi == 7) {
                    System.out.print("ID Anggota: ");
                    int idAnggota = sc.nextInt(); sc.nextLine();
                    Member m = lib.findMemberById(idAnggota);
                    System.out.println(m.getBorrowedItems());
                } else if (opsi == 8) {
                    System.out.println("Keluar dari sistem.");
                    break;
                } else {
                    System.out.println("Opsi tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
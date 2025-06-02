// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.*;

// abstract class LibraryItem {
// protected String title;
// protected int itemId;

// public int getItemId() {
// return itemId;
// }

// protected boolean isBorrowed;

// public LibraryItem(String title, int itemId) {
// this.title = title;
// this.itemId = itemId;
// this.isBorrowed = false;
// }

// public abstract String getDescription();

// public abstract String borrowItem(int days);

// public abstract double calculateFine(int daysLate);

// public String returnItem() {
// this.isBorrowed = false;
// return title + " dikembalikan";
// }

// public boolean getIsBorrowed() {
// return isBorrowed;
// }

// public String getTitle() {
// return title;
// }
// }

// class Book extends LibraryItem {
// private String author;

// public Book(String title, int itemId, String author) {
// super(title, itemId);
// this.author = author;
// }

// @Override
// public String getDescription() {
// return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
// }

// @Override
// public String borrowItem(int days) {
// if (isBorrowed)
// throw new IllegalArgumentException("Item sudah dipinjam.");
// if (days > 14)
// throw new IllegalArgumentException("Maksimal 14 hari peminjaman.");
// isBorrowed = true;
// return "Item " + title + " berhasil dipinjam selama " + days + " hari";
// }

// @Override
// public double calculateFine(int daysLate) {
// return daysLate * 10000;
// }
// }

// class DVD extends LibraryItem {
// private int duration;

// public DVD(String title, int itemId, int duration) {
// super(title, itemId);
// this.duration = duration;
// }

// @Override
// public String getDescription() {
// return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
// }

// @Override
// public String borrowItem(int days) {
// if (isBorrowed)
// throw new IllegalArgumentException("Item sudah dipinjam.");
// if (days > 7)
// throw new IllegalArgumentException("Maksimal 7 hari peminjaman.");
// isBorrowed = true;
// return "Item " + title + " berhasil dipinjam selama " + days + " hari";
// }

// @Override
// public double calculateFine(int daysLate) {
// return daysLate * 25000;
// }
// }

// class Member {
// private String name;
// private int memberId;
// private List<LibraryItem> borrowedItems = new ArrayList<>();

// public Member(String name, int memberId) {
// this.name = name;
// this.memberId = memberId;
// }

// public int getMemberId() {
// return memberId;
// }

// public String borrow(LibraryItem item, int days) {
// if (item.getIsBorrowed()) {
// throw new IllegalStateException("Item tidak tersedia.");
// }
// String result = item.borrowItem(days);
// borrowedItems.add(item);
// return result;
// }

// public String returnItem(LibraryItem item, int daysLate) {
// String result = item.returnItem();
// borrowedItems.remove(item);
// double fine = item.calculateFine(daysLate);
// return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp "
// + (int) fine;
// }

// public void getBorrowedItems() {
// if (borrowedItems.isEmpty()) {
// System.out.println("Belum meminjam item apa pun.");
// return;
// }

// System.out.println("+------------+----------------------+");
// System.out.println("| ID Item | Judul |");
// System.out.println("+------------+----------------------+");
// for (LibraryItem item : borrowedItems) {
// System.out.printf("| %-10s | %-20s |\n", item.getItemId(), item.getTitle());
// }
// System.out.println("+------------+----------------------+");
// }

// public String getName() {
// return name;
// }
// }

// class LibraryLogger {
// private List<String> logs = new ArrayList<>();
// private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd
// HH:mm:ss");

// public String logActivity(String activity) {
// String timestamp = LocalDateTime.now().format(formatter);
// String entry = timestamp + " " + activity;
// logs.add(entry);
// return entry;
// }

// public String getLogs() {
// return String.join("\n", logs);
// }

// public void clearLogs() {
// logs.clear();
// }
// }

// class Library {
// private List<LibraryItem> items = new ArrayList<>();
// private List<Member> members = new ArrayList<>();
// private LibraryLogger logger = new LibraryLogger();

// public String addItem(LibraryItem item) {
// items.add(item);
// return item.getTitle() + " berhasil ditambahkan";
// }

// public LibraryItem findItemById(int itemId) {
// return items.stream()
// .filter(item -> item.itemId == itemId)
// .findFirst()
// .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan"));
// }

// public void getLibraryStatus() {
// System.out.println("+------------+----------------------+-------------+");
// System.out.println("| ID Item | Judul | Status |");
// System.out.println("+------------+----------------------+-------------+");
// for (LibraryItem item : items) {
// System.out.printf("| %-10s | %-20s | %-11s |\n",
// item.getItemId(),
// item.getTitle(),
// item.getIsBorrowed() ? "Dipinjam" : "Tersedia");
// }
// System.out.println("+------------+----------------------+-------------+");
// }

// public void addMember(Member member) {
// members.add(member);
// }

// public Member findMemberById(int id) {
// return members.stream()
// .filter(m -> m.getMemberId() == id)
// .findFirst()
// .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan"));
// }

// public LibraryLogger getLogger() {
// return logger;
// }
// }

// public class Main {
// private static final Scanner scanner = new Scanner(System.in);
// private static final Library library = new Library();

// public static void main(String[] args) {
// int choice;

// do {
// System.out.println("=== Sistem Manajemen Perpustakaan ===");
// System.out.println("1. Tambah Item");
// System.out.println("2. Tambah Anggota");
// System.out.println("3. Pinjam Item");
// System.out.println("4. Kembalikan Item");
// System.out.println("5. Lihat Status Perpustakaan");
// System.out.println("6. Lihat Log Aktivitas");
// System.out.println("7. Lihat Item Anggota");
// System.out.println("8. Keluar");
// System.out.print("Pilih menu: ");
// choice = scanner.nextInt();
// scanner.nextLine();

// switch (choice) {
// case 1 -> tambahItem();
// case 2 -> tambahAnggota();
// case 3 -> pinjamItem();
// case 4 -> kembalikanItem();
// case 5 -> library.getLibraryStatus();
// case 6 -> System.out.println(library.getLogger().getLogs());
// case 7 -> lihatItemAnggota();
// case 8 -> System.out.println("Keluar dari sistem.");
// default -> System.out.println("Pilihan tidak valid.");
// }
// System.out.println();
// } while (choice != 8);
// }

// private static void tambahItem() {
// System.out.println("1. Buku");
// System.out.println("2. DVD");
// System.out.print("Pilih jenis item: ");
// int jenis = scanner.nextInt();
// scanner.nextLine();

// System.out.print("Judul: ");
// String judul = scanner.nextLine();

// System.out.print("ID item: ");
// int id = scanner.nextInt();
// scanner.nextLine();

// LibraryItem item = null;

// if (jenis == 1) {
// System.out.print("Penulis: ");
// String penulis = scanner.nextLine();
// item = new Book(judul, id, penulis);
// } else if (jenis == 2) {
// System.out.print("Durasi (menit): ");
// int durasi = scanner.nextInt();
// scanner.nextLine();
// item = new DVD(judul, id, durasi);
// }

// if (item != null) {
// System.out.println(library.addItem(item));
// }
// }

// private static void tambahAnggota() {
// System.out.print("ID Anggota: ");
// int id = scanner.nextInt();
// scanner.nextLine();

// System.out.print("Nama Anggota: ");
// String nama = scanner.nextLine();

// Member m = new Member(nama, id);
// library.addMember(m);
// library.getLogger().logActivity("Anggota " + nama + " ditambahkan");
// System.out.println("Anggota berhasil ditambahkan.");
// }

// private static void pinjamItem() {
// System.out.print("ID Anggota: ");
// int idAnggota = scanner.nextInt();

// System.out.print("ID Item: ");
// int idItem = scanner.nextInt();

// System.out.print("Jumlah Hari: ");
// int hari = scanner.nextInt();
// scanner.nextLine();

// try {
// Member m = library.findMemberById(idAnggota);
// LibraryItem item = library.findItemById(idItem);
// String result = m.borrow(item, hari);
// library.getLogger().logActivity(item.getDescription() + " dipinjam oleh " +
// m.getName());
// System.out.println(result);
// } catch (Exception e) {
// System.out.println("Gagal meminjam: " + e.getMessage());
// }
// }

// private static void kembalikanItem() {
// System.out.print("ID Anggota: ");
// int idAnggota = scanner.nextInt();

// System.out.print("ID Item: ");
// int idItem = scanner.nextInt();

// System.out.print("Jumlah hari keterlambatan: ");
// int telat = scanner.nextInt();
// scanner.nextLine();

// try {
// Member m = library.findMemberById(idAnggota);
// LibraryItem item = library.findItemById(idItem);
// String result = m.returnItem(item, telat);
// library.getLogger().logActivity(item.getDescription() + " dikembalikan oleh "
// + m.getName());
// System.out.println(result);
// } catch (Exception e) {
// System.out.println("Gagal mengembalikan: " + e.getMessage());
// }
// }

// private static void lihatItemAnggota() {
// System.out.print("ID Anggota: ");
// int id = scanner.nextInt();
// scanner.nextLine();

// try {
// Member m = library.findMemberById(id);
// m.getBorrowedItems();
// } catch (Exception e) {
// System.out.println("Anggota tidak ditemukan.");
// }
// }
// }

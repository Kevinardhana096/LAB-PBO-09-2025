import java.util.*;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.itemId == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan"));
    }

    public void getLibraryStatus() {
        System.out.println("+------------+----------------------+-------------+");
        System.out.println("|  ID Item   |        Judul         |   Status    |");
        System.out.println("+------------+----------------------+-------------+");
        for (LibraryItem item : items) {
            System.out.printf("| %-10s | %-20s | %-11s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    item.getIsBorrowed() ? "Dipinjam" : "Tersedia");
        }
        System.out.println("+------------+----------------------+-------------+");
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(int id) {
        return members.stream()
                .filter(m -> m.getMemberId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan"));
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}

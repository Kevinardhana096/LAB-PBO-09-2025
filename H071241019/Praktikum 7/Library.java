import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library(){
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item){
        items.add(item);
        String message = item.getTitle() + " berhasil ditambahkan";
        logger.logActivity(message);
        return message;
    }

    public void addMember(Member member){
        members.add(member);
        logger.logActivity("Anggota " + member.getName() + " (ID: " + member.getMemberId() + ") berhasil ditambahkan");
    }

    public LibraryItem findItemById(int itemId){
        return items.stream()
            .filter(i -> i.itemId == itemId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan"));
    }

    public String getLibraryStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+----------------------+-----------+\n");
        sb.append("| ID  | Judul                | Status    |\n");
        sb.append("+-----+----------------------+-----------+\n");
        for (LibraryItem item : items){
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-3d | %-20s | %-9s |\n", item.itemId, item.title, status));
        }
        sb.append("+-----+----------------------+-----------+");
        return sb.toString();
    }

    public String getAllLogs(){
        return logger.getLogs();
    }

    public LibraryLogger getLogger(){
        return logger;
    }

}

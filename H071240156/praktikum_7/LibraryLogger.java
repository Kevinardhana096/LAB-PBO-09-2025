import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LibraryLogger {
    private List<String> logs = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(formatter);
        String entry = timestamp + " " + activity;
        logs.add(entry);
        return entry;
    }

    public String getLogs() {
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class LibraryLogger {
    private List<String> logs;

    public LibraryLogger(){
        logs = new ArrayList<>();
    }

    public String logActivity(String activity){
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
        return logEntry;
    }

    public String getLogs(){
        if (logs.isEmpty()){
            return "Tidak ada log";
        }
        return String.join("\n", logs);
    }

    public void clearLogs(){
        logs.clear();
    }
}

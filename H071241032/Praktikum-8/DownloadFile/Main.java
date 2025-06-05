package bentar.TypeRacer.DownloadFile;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    static int successfulDownloads=0;
    static int completedDownloads = 0;
    static int totalFiles;
    static boolean allDone = false;
    static ArrayList<Result> results = new ArrayList<>();

    // TODO (1)
    public static synchronized void recordResult(int fileId, int duration, String threadName) {
        completedDownloads++;
        totalFiles++;
        
        String status = (duration <= 2) ? "Success" : "Timeout";
        if (status.equals("Success")) {
            successfulDownloads++;
        }
        
        results.add(new Result(fileId, threadName, duration, status));
    }

    public static void main(String[] args) {
        // TODO (2)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of files to download: ");
        totalFiles = scanner.nextInt();

        // TODO (3)
        ExecutorService downloadExecutor = Executors.newFixedThreadPool(3);
        ExecutorService uiExecutor = Executors.newSingleThreadExecutor();

        // Mencatat waktu mulai
        long startTime = System.currentTimeMillis();

        // TODO (4)
        uiExecutor.submit(() -> {
            while (!allDone) {
                System.out.println("Downloading files... (" + (System.currentTimeMillis() - startTime) / 1000 + "s)");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // TODO (5)
        for (int i = 1; i <= totalFiles; i++) {
            int fileId = i;
            downloadExecutor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                int duration = new Random().nextInt(3) + 1; // Random duration between 1 and 3 seconds
                try {
                    Thread.sleep(duration * 1000); // Simulate download
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                recordResult(fileId, duration, threadName);
            });
        }

        // TODO (6)
        downloadExecutor.shutdown();

        // TODO (7)
        try {
            downloadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // TODO (8)
        allDone = true;
        uiExecutor.shutdown();
        try {
            uiExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mencatat total waktu proses secara keseluruhan
        long endTime = System.currentTimeMillis();
        int totalTime = (int) ((endTime - startTime) / 1000);

        // Header tabel
        System.out.println("--------------------------------------------------");
        System.out.println("                  Detailed Report                 ");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s | %-18s | %-8s | %-8s%n",
                "File ID", "Thread", "Duration", "Status");
        System.out.println("--------------------------------------------------");

        // Urutkan hasil berdasarkan fileId
        results.sort(Comparator.comparingInt(r -> r.fileId));

        // Tampilan hasil setiap proses download dalam bentuk table
        for (Result r : results) {
            System.out.printf("%-8d | %-18s | %-8s | %-8s%n",
                    r.fileId, r.threadName, r.duration + "s", r.status);
        }

        // Ringkasan Proses
        System.out.println("--------------------------------------------------");
        System.out.println("                     Summary                      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Successful downloads : " + successfulDownloads);
        System.out.println("Failed downloads     : " + (totalFiles - successfulDownloads));
        System.out.printf("Total time           : %ds%n", totalTime);
    }
}

package TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");

        // Hitung waktu mulai
        long startTime = System.currentTimeMillis();

        // Hitung delay per kata berdasarkan WPM (words per minute)
        int delayPerWord = (int) (60.0 / wpm * 1000); // dalam milidetik

        // Ketik satu per satu kata dengan delay
        for (String word : wordsToType) {
            try {
                Thread.sleep(delayPerWord);
            } catch (Exception e) {
                System.out.println(botName + " mengalami gangguan saat mengetik.");
                Thread.currentThread().interrupt();
            }
            this.addWordsTyped(word);
        }

        this.addWordsTyped("(Selesai)");

        // Hitung waktu selesai
        long endTime = System.currentTimeMillis();
        int durationInSeconds = (int) ((endTime - startTime) / 1000);

        // Tambahkan ke hasil race
        typeRacer.addResult(new Result(botName, durationInSeconds));
    }
}

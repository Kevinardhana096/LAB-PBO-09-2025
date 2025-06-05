package bentar.TypeRacer;
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

        // TODO (1)
        // Buatlah variable howLongToType yang memuat waktu yang diperlukan typer
        // The average word length in English is about 5 characters. So, characters per minute (cpm) = wpm * 5.
        // Typing speed is usually measured in words per minute (WPM).
        // To get the time per word in milliseconds: (60 seconds/minute * 1000 milliseconds/second) / wpm = 60000 / wpm.
        // This calculates how long it takes to type one word.
        double howLongToType = 60000 / wpm; // Milliseconds per word

        long startTime = System.currentTimeMillis();

        // TODO (2)
        // Buatlah perulangan untuk menambahkan kata dengan method
        // addWordToTyped setelah interval waktu sebanyak howLongToType
        for (String word : wordsToType) {
            try {
                Thread.sleep((long) howLongToType);
                this.addWordsTyped(word);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.addWordsTyped("(Selesai)");

        long finishTime = System.currentTimeMillis();
        int totalTimeInSeconds = (int) ((finishTime - startTime) / 1000);

        // TODO (3)
        // Tambahkan typer yang telah selesai mengetik semua kata ke list typeRaceTabel 
        // yang ada di class typeRacer. 
        typeRacer.addResult(new Result(this.getBotName(), totalTimeInSeconds));
    }
}
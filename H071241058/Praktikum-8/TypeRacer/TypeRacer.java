package TypeRacer;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    private String[] wordsToTypeList = {
        "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
        "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
        "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
        "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
        "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.
    public synchronized void addFinishedTyper(Typer typer) {
        int finishTime = (int)((System.currentTimeMillis() - startTime) / 1000); // detik
        rareStanding.add(new Result(typer.getBotName(), finishTime));
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");
        // TODO (5)
        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik
        for (int i = 0; i < rareStanding.size(); i++) {
            Result r = rareStanding.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " = " + r.getFinishTime() + " detik");
        }
    }

    private long startTime;


    public void startRace() {
        // TODO (6)
        // Jalankan kompetisi untuk tiap kontestan
        startTime = System.currentTimeMillis();
        for (Typer t : rareContestant) {
            t.start();
        }
    }

    // TODO (7)
    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (rareStanding.size() < rareContestant.size()) {
            System.out.println("\nTyping Progress ...");
            System.out.println("===================");
            for (Typer t : rareContestant) {
                System.out.println(t.getBotName() + " => " + t.getWordsTyped());
            }
            Thread.sleep(2000); // delay 2 detik
        }

        // TODO (8)
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai
        printRaceStanding();
    }
}

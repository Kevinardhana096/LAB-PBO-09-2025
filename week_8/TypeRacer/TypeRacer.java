package TypeRacer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> typeRaceTabel = new ArrayList<>();
    public long startTime;

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

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    public synchronized void addResult(Result result) {
        typeRaceTabel.add(result);
    }

    public void startRace() {
        for (Typer typer : rareContestant) {
            typer.start();
        }
        startTime = System.currentTimeMillis();
    }

    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (true) {
            boolean allDone = true;
            System.out.println("Typing Progress...");
            System.out.println("===================");

            ArrayList<Typer> copy = new ArrayList<>(rareContestant);
            for (Typer typer : copy) {
                System.out.println(typer.getBotName() + " => " + typer.getWordsTyped());
                if (!typer.getWordsTyped().contains("(Selesai)")) {
                    allDone = false;
                }
            }
            System.out.println();

            if (allDone) {
                break;
            }

            Thread.sleep(2000);
        }

        printRaceStanding();
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        typeRaceTabel.sort(Comparator.comparingInt(Result::getFinishTime));
        int posisi = 1;
        for (Result result : typeRaceTabel) {
            System.out.println(posisi + ". " + result.getName() + " = " + result.getFinishTime() + " detik");
            posisi++;
        }
    }
}


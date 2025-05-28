import java.util.Scanner;

// Kelas Hero sebagai superclass
class Hero {
    protected String name;
    protected int health;
    protected int attackPower;

    // Konstruktor Hero
    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }


    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}


class Archer extends Hero {
    
    
    public Archer(String name) {
        super(name, 100, 30); 
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan panah! Kekuatan serangan: " + attackPower);
    }
}


class Wizard extends Hero {
    
    
    public Wizard(String name) {
        super(name, 80, 40); 
    }

    @Override
    public void attack() {
        System.out.println(name + " melemparkan sihir! Kekuatan serangan: " + attackPower);
    }
}


class Fighter extends Hero {
    
    
    public Fighter(String name) {
        this(name, 120, 25); 
    }

    
    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan fisik! Kekuatan serangan: " + attackPower);
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero chosenHero = null;
        
        // Menu Pemilihan Karakter
        System.out.println("Pilih karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Masukkan nama Archer: ");
                String archerName = scanner.next();
                chosenHero = new Archer(archerName);
                break;
            case 2:
                System.out.print("Masukkan nama Wizard: ");
                String wizardName = scanner.next();
                chosenHero = new Wizard(wizardName);
                break;
            case 3:
                System.out.print("Masukkan nama Fighter: ");
                String fighterName = scanner.next();
                chosenHero = new Fighter(fighterName);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("\nPilih aksi:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            
            int action = scanner.nextInt();
            
            switch (action) {
                case 1:
                    if (chosenHero != null) {
                        chosenHero.attack();  
                    }
                    break;
                case 2:
                    gameRunning = false;  
                    System.out.println("Terima kasih telah bermain!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
        
        scanner.close();
    }
}

import java.util.*;

public class TinyTitans {
    // enemys -> 3
    // hero -> 1
    static boolean win = false;

    static class Enemy {
        String name;
        String weaponName;
        int health;
        int weaponHealth;

        Enemy(String n, String wN, int h, int wH) {
            name = n;
            weaponName = wN;
            health = h;
            weaponHealth = wH;
        }
    }

    static class Hero {
        String name;
        String weaponName;
        int health;
        int weaponHealth;

        Hero(String n, String wN, int h, int wH) {
            name = n;
            weaponName = wN;
            health = h;
            weaponHealth = wH;
        }

        void extraHealth() {
            health++;
            System.out.println(" +1 health");
        }

        void fightMode(Hero Hero, Enemy Enemy) throws InterruptedException {
            win = false;
            System.out.println(Hero.name + " vs " + Enemy.name);

            while (Hero.health > 0 && Enemy.health > 0) {

                System.out.println(Hero.name + " shot " + Enemy.name + " with his " + Hero.weaponName);
                System.out.println(Enemy.name + " shot " + Hero.name + " with his " + Enemy.weaponName);

                Enemy.health -= 20;

                if (Enemy.weaponName.equals("Shotgun")) {
                    Hero.health -= 10;
                } else if (Enemy.weaponName.equals("Rifle")) {
                    Hero.health -= 20;
                } else {
                    Hero.health -= 5;
                }

                System.out.println(Hero.name + " health is " + Hero.health +
                        " % and " + Enemy.name + " health is " + Enemy.health + " %");

                Thread.sleep(1000);
                System.out.println("-_-_-_-_-_-_-_-_-");
            }

            if (Hero.health > 0 && Enemy.health <= 0) {
                Enemy.health = 0;
                Hero.extraHealth();
                win = true;
                System.out.println("You defeated " + Enemy.name + "!");
            } else if (Hero.health <= 0) {
                System.out.println("You died...");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Enemy alex = new Enemy("Alex", "Shotgun", 500, 5000);
        Enemy sam = new Enemy("Sam", "Rifle", 900, 9000);
        Enemy max = new Enemy("Max", "Sniper", 1000, 100000);
        Hero laith = new Hero("Laith", "Rpg", 100, 12000);

        Scanner in = new Scanner(System.in);

        System.out.println("=== TinyTitans ===");
        System.out.println("Hero Name: " + laith.name);
        System.out.println("Hero Health: " + laith.health);
        System.out.println("Hero Weapon: " + laith.weaponName);
        System.out.println("-_-_-_-_-_-_-_-_-");

        boolean play = true;

        while (play) {
            System.out.println("Should i 1. Exit Room 2. Stay sleeping: ");
            int roomChoice = in.nextInt();

            if (roomChoice == 1) {
                System.out.println("Im in a wood do i go 1.Left or 2.Right or 3.Straight");
                int woodChoice = in.nextInt();

                if (woodChoice == 2) {
                    System.out.println("Enemyyyyyy " + sam.name + " Do i 1.fight him(gain power) 2.Ignore");
                    int fightSam = in.nextInt();

                    if (fightSam == 1) {
                        laith.fightMode(laith, sam);

                        if (win) {
                            System.out.println("That was a mess PHEW");
                        } else {
                            System.out.println("I needed to prepare");
                        }
                    }
                }
            } else {
                System.out.println("Cave conquered you lose");
                break;
            }
        }
    }
}
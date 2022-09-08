package com.project.game;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();


        //Game Variables
        String[] enemiesName = {"Skeleton","Zombie","Warrior","Thug"};
        int maxEnemyHealth = 120;
        int maxEnemyAttackDamage = 30;

        //Player variables
        int health = 100;
        int playerAttackDamage = 30;
        int numHeathPotion = 3;
        int healthPotionHealAmt = 20;
        int healthPotionDropChance = 25; //Percentage

        //Game Loop
        boolean isRunning = true;

        System.out.println("Welcome to the Dungeon");

        GAME:
        while(isRunning){
            System.out.println("---------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemiesName[rand.nextInt(enemiesName.length)];
            System.out.println("\t# "+enemy+" appeared! #\n");

            while (enemyHealth > 0){
                System.out.println("\t Your HP: "+health);
                System.out.println("\t "+enemy+"'s HP: "+enemyHealth);
                System.out.println("\t What would you like to do?");
                System.out.println("\t1. Attack!");
                System.out.println("\t2. Drink Health Potion.");
                System.out.println("\t3. Run!");

                //User Input
                int input = in.nextInt();
                switch (input){
                    case 1: int damageDealt = rand.nextInt(playerAttackDamage);
                            int damageTaken = rand.nextInt(enemyHealth);
                            enemyHealth -= damageDealt;
                            health -= damageTaken;

                            System.out.println("\t > You strike the "+enemy+" for "+damageDealt+".");
                            System.out.println("\t >You receive "+damageTaken+" damage in retaliation");

                            if(health < 1 ) {
                                System.out.println("\t >You have taken too much damage.");
                                System.out.println("\t >You are dead.");
                                isRunning = false;
                            }
                            break;
                    case 2: if(numHeathPotion > 0){
                                health+= healthPotionHealAmt;
                                numHeathPotion--;
                                System.out.println("\t You drank a health potion healing yourself for "+healthPotionHealAmt
                                                    +".\n\t You now have "+health+"HP"
                                                    +"\n\t Health Potions: "+numHeathPotion);

                            }else{
                                System.out.println("\t You have no health potions left. Find more in the wilderness.");
                            }
                            break;

                    case 3:System.out.println("\t You ran away from the "+enemy+".");
                            continue GAME;

                    default:System.out.println("Invalid Command");
                }

            }

            if(health < 1){
                System.out.println("You limp out of the dungeon.");
                break;
            }

            System.out.println("---------------------------------------");
            System.out.println("#"+enemy+" was defeated.");
            System.out.println("# You have "+health+" HP left.");

            if(rand.nextInt(100)<healthPotionDropChance){
                numHeathPotion++;
                System.out.println("# The enemy dropped a health potion.");
                System.out.println("# You have "+numHeathPotion+" health potions.");
            }
            System.out.println("---------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue Fighting.");
            System.out.println("2. Exit Dungeon");

            int input = in.nextInt();

            while(input != 1 && input != 2){
                System.out.println("# Invalid Command # \n # Enter Again #");
                input = in.nextInt();
            }

            if(input == 1) System.out.println("You move ahead.");
            else if(input == 2){
                System.out.println("You exit the dungeon.");
                break;
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("\t # THANKS FOR PLAYING #");
        System.out.println("---------------------------------------");
    }

}

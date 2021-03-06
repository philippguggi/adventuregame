package com.PhilippGuggi.AdventureGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// System objects
		Scanner in = new Scanner(System.in);
		Random random = new Random();

		// Game variables
		String[] enemies = { "Skeleton", "Zombie", "Warrior", "Assassin" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;

		// Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPots = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50;

		boolean running = true;

		System.out.println("Welcome to the dungeon!");

		// Label
		GAME: 
		while (running) {
			System.out.println("------------------");
			
			int enemyHealth = random.nextInt(maxEnemyHealth);
			String enemy = enemies[random.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while (enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run");
				
				String input = in.nextLine();
				if (input.equals("1")) {
					int damageDealt = random.nextInt(attackDamage);
					int damageTaken = random.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You received " + damageTaken + " in retaliation.");
					System.out.println();
					if (health < 1) {
						System.out.println("\t You have taken too much damage, you are too weak to go on.");
						break;
					}
				} else if (input.contentEquals("2")) {
					
					if (numHealthPots > 0) {
						health += healthPotionHealAmount;
						numHealthPots--;
						System.out.println("\t> You drank a health potion and healed for: " + healthPotionHealAmount + "." 
						+ "\n\t> You now have " + health + " HP."
						+ "\n\t> You now have " + numHealthPots + " health potions left.\n");
					} else {
						System.out.println("\t> You have no health potions, defeat enemies for a chance to get one.");
						System.out.println();
					}
				} else if (input.contentEquals("3")) {
					System.out.println("\t> You run away from the " + enemy + ".");
					continue GAME;
				} else {
					System.out.println("\tInvalid command");
					System.out.println();
				}
			}
			if (health < 1) {
				System.out.println();
				System.out.println("\t> You limp out of the dungeon, weak from battle.");
				break;
			}
			System.out.println("------------------");
			System.out.println(" # " + enemy + " was defeated! #");
			System.out.println(" # You have " + health + " HP left. # ");
			
			if (random.nextInt(100) < healthPotionDropChance) {
				numHealthPots++;
				System.out.println(" # The " + enemy + " dropped a health potion. # ");
				if (numHealthPots == 1) {
					System.out.println(" # You now have " + numHealthPots + " health potion. # ");
				} else {
					System.out.println(" # You now have " + numHealthPots + " health potions. # ");
				}				
			}
			System.out.println("------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon");
			String input = in.nextLine();
			
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("invalid command");
				System.out.println();
				input = in.nextLine();
			}
			if (input.equals("1")) {
				System.out.println("You continue your adventure!");
			} else if (input.equals("2")) {
				System.out.println("You exit the dungeon!");
				break;
			}
		}
		System.out.println();
		System.out.println("##########################");
		System.out.println("# Thank you for playing! #");
		System.out.println("##########################");
	}
}

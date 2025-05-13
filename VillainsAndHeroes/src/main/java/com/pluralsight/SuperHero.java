package com.pluralsight;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SuperHero extends SuperPerson{
    static Scanner scan = new Scanner(System.in);
    //constructor that calls the parent class constructor
    public SuperHero(String name, int health, int heroicPower) {
        //use super keyword as it refers to the parent object and runs parent constructor
        super(name, health);

        //in default superperson XP defaults to 0 but we set XP to Hero's power level
        this.experiencePoints = heroicPower;

        //announces who the hero is
        System.out.println(this.name + " has arrived with a power level of " + heroicPower);

    }

    @Override
    public void fightPerson(SuperPerson opponent) {
        if (!powerInventory.isEmpty()) {
            //create a new list of just the keys from the HashMap (glove, hammer, etc....)
            ArrayList<String> items = new ArrayList<String>(powerInventory.keySet());

            //get a random item name from the above list we just made and store it in randomeItem
            String randomItem = items.get(new Random().nextInt(items.size()));

            //get the point value for that item from the inventory HashMap
            //bonuse would be the int that represents the damage the item will do.
            int bonus = getPowerBonus(randomItem);

            int baseDamage = new Random().nextInt(20);
            int damagePlusXp = baseDamage + this.experiencePoints;
            int damageWBonus = baseDamage + this.experiencePoints + bonus;

            if(baseDamage == 0) {
                System.out.println("The gallant " + this.name + " unfortunately missed their attack");
            }  else {
                opponent.takeDamage(damageWBonus);
                System.out.println("Horray!! The heroic " + this.name + " has used the amazing " + randomItem + " and landed an attack on the evil " + opponent.name);
            }

            //conditional that could be used if bonus was automatically and randomly chose
//            else if(bonus == 0) {
//                opponent.takeDamage(damagePlusXp);
//                System.out.println("Horray!! The heroic " + this.name + " has landed an attack on the evil " + opponent.name);
//            }
        }
    //practice with user input-------------------------
//    @Override
//    public void fightPerson(SuperPerson opponent) {
//        System.out.println("Prepare for battle!");
//        int baseDamage = new Random().nextInt(20);
//        System.out.print("Enter power up: ");
//        String powerUp = scan.nextLine();
//
//        //condition that checks if powerUp is in inventory and adds to damage or skips over it
//        if(this.powerInventory.containsKey(powerUp)) {
//            int damagePlusXp = baseDamage + this.experiencePoints + this.getPowerBonus(powerUp);
//            if(baseDamage == 0) {
//                System.out.println("You're attack missed! But you're heroism and courage is undefeated!!");
//            } else {
//                opponent.takeDamage(damagePlusXp);
//                System.out.println(this.name + " uses the supreme power of their special ability to land a devastating attack on the evil " + opponent.name);
//            }
//        } else {
//            int damagePlusXp = baseDamage + this.experiencePoints;
//            if(baseDamage == 0) {
//                System.out.println("You're attack missed! But you're heroism and courage is undefeated!!");
//            } else {
//                opponent.takeDamage(damagePlusXp);
//                System.out.println(this.name + " heroically lands a punch on the evil " + opponent.name);
//            }
//        }




    }



}

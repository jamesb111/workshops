package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class SuperVillain extends SuperPerson{
    public SuperVillain(String name, int health, int negativeEnergy) {
        super(name, health);
        this.experiencePoints = negativeEnergy;

        //announces villain
        System.out.println("The dreaded " + this.name + " has arrived to wreak havoc on the world!");
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
            int damagePlusXp = baseDamage + this.experiencePoints + bonus;

            if(baseDamage == 0) {
                System.out.println("The wicked " + this.name + " attack missed thankfully");
            } else {
                opponent.takeDamage(damagePlusXp);
                System.out.println("The absolute horror!! The evil " + this.name + " has used the dreaded " + randomItem + " and injured our great hero " + opponent.name);
            }
        }


    }




}

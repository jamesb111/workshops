package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//abstract prevents you from making a Superperson you can only extend superperson with subclasses
public abstract class SuperPerson {
    protected String name;
    protected int health;
    protected int experiencePoints;
    private Map<String, Integer> battleLog = new HashMap<>();
    protected Map<String, Integer> powerInventory = new HashMap<>();

    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;

        //defaults experience points to 0
        this.experiencePoints = 0;

        powerInventory.put("stick", 5);
        powerInventory.put("baseball bat", 7);
        powerInventory.put("Infinity Gauntlet", 20);
        powerInventory.put("sword", 10);

    }

    public boolean isAlive() {
        if(this.health > 0) {
            return true;
        }

        return false;
    }

    public abstract void fightPerson(SuperPerson opponent);

    public  String getType() {
        return this.getClass().getSimpleName();
    }

    public void takeDamage(int damageAmnt) {
        //subtract damage amount from health but not set health below zero
        this.health -= damageAmnt;
        if(this.health < 0) {
            this.health = 0;
        }
    }

    public String getStatus() {
        return this.name + " has " + this.health + " health points left.";
    }

    //update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    //print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    public void addPowerUp(String power, int value) {
        //add power to map
        powerInventory.put(power, value);
    }

    public int getPowerBonus(String value) {
        //stores result
        ArrayList<Integer> result = new ArrayList<>();

        //checks if inventory has the value
        if(powerInventory.get(value) != null) {
            result.add(powerInventory.get(value));
        } else {
            System.out.println("Value not found");
        }
        return result.get(0);

    }




}
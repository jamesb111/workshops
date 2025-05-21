package com.pluralsight;

public class SideKickDog implements Fightable {
    private String name;
    private int health;
    private int barkPower;

    public SideKickDog(String name, int health, int barkPower) {
        this.name = name;
        this.health = health;
        this.barkPower = barkPower;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getStatus() {
        return this.name + " has " + this.health + " health points left.";
    }

    @Override
    public void fightPerson(SuperPerson opponent) {
        System.out.println("The dog howls at the villainous " + opponent.name);
        opponent.takeDamage(barkPower);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBarkPower() {
        return barkPower;
    }

    public void setBarkPower(int barkPower) {
        this.barkPower = barkPower;
    }
}

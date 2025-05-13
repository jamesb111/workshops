package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) {
        SuperHero hero = new SuperHero("Thanos", 100, 15);
        SuperVillain villain = new SuperVillain("Dr. Doom", 100, 12);

        System.out.println("--------------------------------");
        System.out.println("Let us begin the battle for the fate of the world!");
        System.out.println(hero.getStatus());
        System.out.println(villain.getStatus());


        while(hero.isAlive() && villain.isAlive()) {
            hero.fightPerson(villain);
            hero.logHit(villain);

            System.out.println(villain.getStatus());


            villain.fightPerson(hero);
            villain.logHit(hero);


            System.out.println(hero.getStatus());
        }

        hero.printBattleLog();
        villain.printBattleLog();


        if(hero.health > villain.health) {
            System.out.println("Our great hero " + hero.name +" has saved the world from the evil clutches of " + villain.name);
        } else if(villain.health > hero.health) {
            System.out.println("Someone please help us " + hero.name + " has lost the fight " + villain.name + " reigns supreme!");
        } else {
            System.out.println("The battle ended in a draw. Thanos has made the ultimate sacrifice to save the world");
        }
    }
}

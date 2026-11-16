package Challenge;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {

    public static abstract class Character {
        protected final int movementSpeed = 20;
        protected int hp;
        protected double energy;

        public Character(int hp, double energy) {
            this.hp = hp;
            this.energy = energy;
        }

        public abstract void attack();

        public abstract void takeDamage();

        public void move(char dir) {
            System.out.print("Wizard ");
            if (dir == 'w')
                System.out.print("Move UP...");
            if (dir == 'a')
                System.out.print("Move LEFT...");
            if (dir == 's')
                System.out.print("Move DOWN...");
            if (dir == 'd')
                System.out.print("Move RIGHT...");
            System.out.println(" (+" + movementSpeed + " Speed)\n");
        };
    }

    public static class Wizard extends Character {
        public Wizard(int hp, double energy) {
            super(hp, energy);
            System.out.println("Wizard Spawned!!\n");
        }

        @Override
        public void attack() {
            System.out.println("Attack... (-30 mana)\n");
            energy -= 30;
            stat();
        }

        @Override
        public void takeDamage() {
            System.out.println("Taken Damage...(-15 HP)\n");
            hp -= 15;
            stat();
        }

        public void fly() {
            System.out.println("Flying...(-5 mana/sec)\n");
            energy -= 5;
            stat();
        }

        public void stat() {
            System.out.println("Wizard");
            System.out.println("HP: " + hp);
            System.out.println("Mana: " + energy);
            System.out.println();
        }
    }

    public static class Warrior extends Character {
        public Warrior(int hp, double energy) {
            super(hp, energy);
            System.out.println("Warrior Spawned!!\n");
        }

        @Override
        public void attack() {
            System.out.println("Attack...(-50 strength)\n");
            energy -= 50;
        }

        @Override
        public void takeDamage() {
            System.out.println("Taken Damage...(-10 HP)\n");
            hp -= 10;
            stat();
        }

        public void dash() {
            System.out.println("Dashed...(-70 Strength)\n");
            stat();
        }

        public void stat() {
            System.out.println("Warrior:");
            System.out.println("HP: " + hp);
            System.out.println("Strength: " + energy);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Wizard wizard = new Wizard(100, 1000);
        wizard.stat();
        wizard.attack();
        wizard.takeDamage();
        wizard.fly();
        wizard.move('w');

        Warrior warrior = new Warrior(200, 3000);
        warrior.stat();
        warrior.attack();
        warrior.takeDamage();
        warrior.dash();
        warrior.move('w');

        List <Character> characters = new ArrayList<>();
        characters.add(wizard);
        characters.add(warrior);
    }
}
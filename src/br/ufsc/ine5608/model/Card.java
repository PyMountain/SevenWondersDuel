package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class Card {
   private ArrayList cost;
   private String name;
   private ArrayList effects;
   private int victoryPoints;

    public Card(ArrayList cost, String name, ArrayList effects, int victoryPoints) {
        this.cost = cost;
        this.name = name;
        this.effects = effects;
        this.victoryPoints = victoryPoints;
    }
   
    public ArrayList getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public ArrayList getEffects() {
        return effects;
    }
   
    public int getVictoryPoints(){
        return this.victoryPoints;
    }
   
}

package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class Card {
   private ArrayList<Resource> resourcesCost;
   private String name;
   private ArrayList<Resource> resources;
   private int cost;
   private int victoryPoints;

    public Card(ArrayList<Resource> resourcesCost, String name, ArrayList<Resource> resources, int victoryPoints, int cost) {
        this.cost = cost;
        this.name = name;
        this.resources = resources;
        this.victoryPoints = victoryPoints;
        this.resourcesCost = resourcesCost;
    }
   
    public int getCost() {
        return cost;
    }
    
    public ArrayList<Resource> getResourcesCost() {
        return resourcesCost;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }
   
    public int getVictoryPoints(){
        return this.victoryPoints;
    }
   
}

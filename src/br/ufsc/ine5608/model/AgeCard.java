package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class AgeCard extends Card{
    
    private Type type;
    
    public AgeCard(ArrayList<Resource> resourcesCost, String name, ArrayList<Resource> resources, Type type, int victoryPoints, int cost) {
        super(resourcesCost, name, resources, victoryPoints, cost);
        this.type = type;
    }
    
    public Type getType(){
        return this.type;
    }
    
}

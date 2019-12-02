package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class AgeCard extends Card{
    
    private Type type;
    
    public AgeCard(ArrayList cost, String name, ArrayList effects, Type type, int victoryPoints) {
        super(cost, name, effects, victoryPoints);
        this.type = type;
    }
    
}

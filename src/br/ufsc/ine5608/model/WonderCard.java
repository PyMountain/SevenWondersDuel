package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class WonderCard extends Card{
    
    public WonderCard(ArrayList<Resource> resourcesCost, String name, ArrayList<Resource> resources, int victoryPoints, int cost) {
        super(resourcesCost, name, resources, victoryPoints, cost);
    }
    
}

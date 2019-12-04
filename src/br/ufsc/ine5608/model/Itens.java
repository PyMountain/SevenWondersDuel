package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class Itens {
    private ArrayList<AgeCard> age1Cards;
    private ArrayList<AgeCard> age2Cards;
    private ArrayList<AgeCard> age3Cards;
    private ArrayList<WonderCard> wonderCards;
    private ArrayList<WonderCard> playerCards;

    public Itens() {
    }

    public void setWonders(ArrayList wonders){
        this.wonderCards = wonders;
    }
    
     public ArrayList<AgeCard> getAge1Cards() {
        return age1Cards;
    }

    public void setAge1Cards(ArrayList<AgeCard> age1Cards) {
        this.age1Cards = age1Cards;
    }

    public ArrayList<AgeCard> getAge2Cards() {
        return age2Cards;
    }

    public void setAge2Cards(ArrayList<AgeCard> age2Cards) {
        this.age2Cards = age2Cards;
    }

    public ArrayList<AgeCard> getAge3Cards() {
        return age3Cards;
    }

    public void setAge3Cards(ArrayList<AgeCard> age3Cards) {
        this.age3Cards = age3Cards;
    }

    public ArrayList<WonderCard> getWonders() {
        return this.wonderCards;
    }
    
    
}

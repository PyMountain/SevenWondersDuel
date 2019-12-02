package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class Itens {
    private ArrayList<Card> age1Cards;
    private ArrayList<Card> age2Cards;
    private ArrayList<Card> age3Cards;
    private ArrayList<Card> wonderCards;

    public Itens() {
    }

    public void setWonders(ArrayList wonders){
        
    }
    
     public ArrayList<Card> getAge1Cards() {
        return age1Cards;
    }

    public void setAge1Cards(ArrayList<Card> age1Cards) {
        this.age1Cards = age1Cards;
    }

    public ArrayList<Card> getAge2Cards() {
        return age2Cards;
    }

    public void setAge2Cards(ArrayList<Card> age2Cards) {
        this.age2Cards = age2Cards;
    }

    public ArrayList<Card> getAge3Cards() {
        return age3Cards;
    }

    public void setAge3Cards(ArrayList<Card> age3Cards) {
        this.age3Cards = age3Cards;
    }
    
    
}

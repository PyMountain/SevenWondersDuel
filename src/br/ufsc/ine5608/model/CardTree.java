package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class CardTree {
    private ArrayList<AgeCard> cards;
    
    public CardTree(ArrayList<AgeCard> cards){
        this.cards = cards;
    }

    public ArrayList<AgeCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<AgeCard> cards) {
        this.cards = cards;
    }
    
    public void removeCard(int position){
        cards.remove(position);
    }
    
    
}

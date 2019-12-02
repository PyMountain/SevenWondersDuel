package br.ufsc.ine5608.model;

import java.util.ArrayList;

public class CardTree {
    private ArrayList<Card> cards;
    
    public CardTree(ArrayList<Card> cards){
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    public void removeCard(int position){
        cards.remove(position);
    }
    
    
}

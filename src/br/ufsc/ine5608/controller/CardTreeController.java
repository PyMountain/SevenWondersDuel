package br.ufsc.ine5608.controller;

import br.ufsc.ine5608.model.AgeCard;
import br.ufsc.ine5608.model.Card;
import br.ufsc.ine5608.model.CardTree;
import java.util.ArrayList;

public class CardTreeController {
    private CardTree cardTree;
    private static CardTreeController ctCtrl;
    private int age;
    
    private CardTreeController(){
        this.cardTree = new CardTree(new ArrayList());
        this.age = 0;
    }
    
    public static CardTreeController getInstance(){
        if(ctCtrl == null) 
            ctCtrl = new CardTreeController();
        return ctCtrl;
    }
    
    public CardTree update(){
        return this.cardTree;
    }
    
    public ArrayList<AgeCard> getCards(){
        return this.cardTree.getCards();
    }
    
    public void removeCard(int cardPosition){
        this.cardTree.removeCard(cardPosition);
    }
    
    public void setAgeCards(ArrayList cards){
        this.age++;
        this.cardTree.setCards(cards);
    }
    
    public boolean verifyCard(int position){
        return (position % 2 == 0) ||((this.cardTree.getCards().get(position - 1).getName().equals("Carta usada")) && (this.cardTree.getCards().get(position + 1).getName().equals("Carta usada"))) ;
        
    }

    public int getAge() {
        return this.age;
    }
    
    
}

package br.ufsc.ine5608.controller;

import br.ufsc.ine5608.model.Card;
import br.ufsc.ine5608.model.CardTree;
import java.util.ArrayList;

public class CardTreeController {
    private CardTree cardTree;
    private static CardTreeController ctCtrl;
    
    private CardTreeController(){
        this.cardTree = new CardTree(new ArrayList());
    }
    
    public static CardTreeController getInstance(){
        if(ctCtrl == null) 
            ctCtrl = new CardTreeController();
        return ctCtrl;
    }
    
    public CardTree update(){
        return this.cardTree;
    }
    
    public void removeCard(int cardPosition){
        this.cardTree.removeCard(cardPosition);
    }
    
    public void setCards(ArrayList cards){
        this.cardTree.setCards(cards);
    }
    
    public boolean verifyCard(int position){
        return false;
    }

    void initCardTree() {
        //setup cards
    }
    
    
}

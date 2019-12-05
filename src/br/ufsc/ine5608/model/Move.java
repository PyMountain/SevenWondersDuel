/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5608.model;

import br.ufsc.inf.leobr.cliente.Jogada;

/**
 *
 * @author lucas
 */
public class Move implements Jogada {
    private Action action;
    private AgeCard card;
    private WonderCard wonderCard;
    
    public Move(Action action, AgeCard card, WonderCard wonderCard, int cardPosition) {
        this.action = action;
        this.card = card;
        this.wonderCard = wonderCard;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public AgeCard getCard() {
        return card;
    }

    public void setCard(AgeCard card) {
        this.card = card;
    }

    public WonderCard getWonderCard() {
        return wonderCard;
    }

    public void setWonderCard(WonderCard wonderCard) {
        this.wonderCard = wonderCard;
    }

    
    
}

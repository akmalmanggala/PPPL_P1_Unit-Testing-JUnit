package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private Owner owner;
    private List<String> cards = new ArrayList<>();
    private List<Integer> cash = new ArrayList<>();

    public void setOwner(Owner owner){
        this.owner = owner;
    }

    public Owner getOwner(){
        return owner;
    }

    public void addCard(String card){
        cards.add(card);
    }

    public boolean removeCard(String card){
        return cards.remove(card);
    }

    public boolean hasCard(String card) {
        return cards.contains(card);
    }

    public int getCardCount() {
        return cards.size();
    }

    public boolean addCash(int amount){
        if(amount < 0){
            return false;
        }
        cash.add(amount);
        return true;
    }

    public void removeCash(int amount){
        int total = getTotalCash();
        if (amount <= 0){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        if (amount > total){
            throw new RuntimeException("InsufficientFundsException");
        }
        cash.add(-amount);
    }

    public int getTotalCash(){
        int total = 0;
        for (int c:cash){
            total += c;
        }
        return total;
    }

    public void clearCards() {
        this.cards.clear();
    }

    public void clearCash() {
        this.cash.clear();
    }
}

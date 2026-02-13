package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String owner;
    private List<String> cards = new ArrayList<>();
    private List<Integer> cash = new ArrayList<>();

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
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

    public void addCash(int amount){
        cash.add(amount);
    }

    public boolean removeCash(int amount){
        int total = getTotalCash();
        if (amount > total){
            return false;
        }
        cash.add(-amount);
        return true;
    }

    public int getTotalCash(){
        int total = 0;
        for (int c:cash){
            total += c;
        }
        return total;
    }

}

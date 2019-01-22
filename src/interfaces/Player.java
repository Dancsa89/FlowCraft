package interfaces;

import species.units.GameTableCell;

import java.util.Random;

public class Player implements Species {

    private String name;
    private int goods = 150;
    private int income = 50;
    private int stepPoints = 3;

    public Player(String name) {
        this.name = name;
    }

    public int getGoods() { return goods; }

    public String toStringGoods() {
        return "Goods" + Integer.toString(goods);
    }

    public int getIncome() { return income; }

    public void setGoods(int price) {
        this.goods = this.goods - price;
    }

    public void setStepPoints(int dec) {
        this.stepPoints = this.stepPoints - dec;
    }

    public int getStepPoints() {
        return stepPoints;
    }

    public void stepPointsPositive(int plus) {
        this.stepPoints = this.stepPoints = plus;
    }

    public void goodsPlusIncome(int income) {
        if (income == 0) {
        this.goods = this.goods + this.income;
    } else {
        this.goods = this.goods + (this.income + income);
        }
    }

    public String getName() { return name; }

    @Override
    public int human(GameTableCell unitOrBuilding) {
        double discount = 0.75;
        int price = unitOrBuilding.getPrice();
        return (int) (price * discount);
    }

    @Override
    public void goblin() {

    }

    @Override
    public boolean nightElf() {
        Random rand = new Random();
        int randomNum = rand.nextInt((4 - 1) + 1) + 1;
        return randomNum == 1;
    }

    @Override
    public void orc(GameTableCell unitOrBuilding) {
        int counter = 0;

    }
}
package interfaces;

import org.omg.CORBA.PUBLIC_MEMBER;
import species.units.GameTableCell;
import table.GameTable;

import java.util.Random;

public class Player implements Species {

    private String name;
    private int goods = 200;
    private int income = 50;
    private int stepPoints = 3;
    private int specie;
    private int roundCount = 0;

    public Player(String name, int specie) {

        this.name = name;
        this.specie = specie;
    }

    public int getGoods() { return goods; }

    public String toStringGoods() {
        return "Gold:" + " " + Integer.toString(this.goods);
    }

    public int getIncome() { return income; }

    public int getSpecie() { return specie; }

    public void setRoundCount(int plus) { this.roundCount += plus; }

    public int getRoundCount() { return roundCount; }

    public void setGoods(int price) {
        this.goods = this.goods - price;
    }

    public void setGoods2(int plus) {
        this.goods = this.goods + plus;
    }

    public void setStepPoints(int dec) {
        this.stepPoints = this.stepPoints - dec;
    }

    public void nightElfStepPoints(int plus) {
        this.stepPoints = this.stepPoints + plus;
    }

    public int getStepPoints() {
        return stepPoints;
    }

    public void stepPointsPositive() {
        this.stepPoints = 3;
    }

    public void goodsPlusIncome(int income) {
        int bank = 25;
        if (income == 0) {
        this.goods = this.goods + this.income;
    } else if (income == 1) {
        this.goods = this.goods + (this.income + bank);
        } else if (income >= 2) {
            this.goods = this.goods + (this.income + (bank * 2));
        }
    }

    public String getName() {
        String fullInformation ="";
        if (specie == 1) {
            fullInformation += "Human";
        } else if (specie == 2) {
            fullInformation += "Orc";
        } else if (specie == 3) {
            fullInformation += "Goblin";
        } else if (specie == 4) {
            fullInformation += "Night Elf";
        }
        return name + " " + "," + " " + fullInformation;
    }

    @Override
    public int human(GameTableCell unitOrBuilding) {
        double discount = 0.75;
        int price = unitOrBuilding.getPrice();
        return (int) (price * discount);
    }

    @Override
    public int goblin() {
        return (int) (getIncome() * 1.1);

    }

    @Override
    public boolean nightElf() {
        Random rand = new Random();
        int randomNum = rand.nextInt((4 - 1) + 1) + 1;
        return randomNum == 1;
    }

    @Override
    public void orc(GameTableCell cellitem) {
        double over = 0.25;
        int original = cellitem.getOriginalDamage();
        int overDamaged = (int) (original * over);
        cellitem.setDamage(overDamaged);
    }
}
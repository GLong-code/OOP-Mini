package Model;

import java.time.LocalDate;

public class FreshFood extends Food{
    private final double cost;
    private static  final String idPrefix = "FF";
    private String freshId;
    LocalDate today = LocalDate.now();

    public FreshFood(int foodID, String describe, int quantity, LocalDate importDay, LocalDate expiry,int foodClass ,double atribute) {
        super(foodID, describe, quantity, importDay, expiry, foodClass, atribute);
        this.freshId = idPrefix + foodID;
        cost = atribute*20000*(today.getMonth().compareTo(importDay.getMonth()));
    }

    public String getFreshId() {
        return freshId;
    }

    public void setFreshId(String freshId) {
        this.freshId = freshId;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "FreshFood{" +
                "foodID='" + foodID + '\'' +
                ", descbribe='" + describe + '\'' +
                ", quantity=" + quantity +
                ", importDay=" + importDay +
                ", expiry=" + expiry +
                ", weight=" + atribute +
                ", cost=" + cost +
                '}';
    }
}

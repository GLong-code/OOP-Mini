package Model;

import java.time.LocalDate;

public class DryFood extends Food {
    private final double cost;
    private static  final String idPrefix = "DF";
    private String dryId;
    LocalDate today = LocalDate.now();

    public DryFood(int foodID, String describe, int quantity, LocalDate importDay, LocalDate expiry, int foodClass, double atribute) {
        super(foodID, describe, quantity, importDay, expiry,  foodClass, atribute);
        this.dryId = idPrefix + foodID;
        cost = atribute * 10000*(today.getMonth().compareTo(importDay.getMonth()));
    }

    public String getDryId() {
        return dryId;
    }

    public void setDryId(String dryId) {
        this.dryId = dryId;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "DryFood{" +
                "size=" + atribute +
                ", cost=" + cost +
                ", foodID='" + foodID + '\'' +
                ", descbribe='" + describe + '\'' +
                ", quantity=" + quantity +
                ", importDay=" + importDay +
                ", expiry=" + expiry +
                '}';
    }
}

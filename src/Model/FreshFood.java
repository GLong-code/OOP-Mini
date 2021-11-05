package Model;

import java.time.LocalDate;

public class FreshFood extends Food{
    private final double weight;
    private final double cost;
    LocalDate today = LocalDate.now();

    public FreshFood(String foodID, String descbribe, int quantity, LocalDate importDay, LocalDate expiry, double weight) {
        super(foodID, descbribe, quantity, importDay, expiry);
        this.weight = weight;
        cost = weight*20000*(today.compareTo(importDay));
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "FreshFood{" +
                "foodID='" + foodID + '\'' +
                ", descbribe='" + descbribe + '\'' +
                ", quantity=" + quantity +
                ", importDay=" + importDay +
                ", expiry=" + expiry +
                ", weight=" + weight +
                ", cost=" + cost +
                ", today=" + today +
                '}';
    }
}

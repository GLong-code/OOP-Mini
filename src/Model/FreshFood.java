package Model;

import java.time.LocalDate;

public class FreshFood extends Food{
    private final double weight;
    private final double cost;
    LocalDate today = LocalDate.now();

    public FreshFood(String foodID, String descbribe, int quantity, LocalDate importDay, LocalDate expiry, double weight) {
        super(foodID, descbribe, quantity, importDay, expiry);
        this.weight = weight;
        cost = weight*10000*(today.compareTo(expiry));
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "DryFood{" +
                "weight=" + weight +
                ", cost=" + cost +
                ", today=" + today +
                ", foodID='" + foodID + '\'' +
                ", descbribe='" + descbribe + '\'' +
                ", quantity=" + quantity +
                ", importDay=" + importDay +
                ", expiry=" + expiry +
                '}';
    }
}

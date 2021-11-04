package Model;

import java.time.LocalDate;

public class DryFood extends Food {
    private final double size;
    private final double cost;
    LocalDate today = LocalDate.now();

    public DryFood(String foodID, String descbribe, int quantity, LocalDate importDay, LocalDate expiry, double size) {
        super(foodID, descbribe, quantity, importDay, expiry);
        this.size = size;
        cost = size * 10000*(today.compareTo(expiry));
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "DryFood{" +
                "size=" + size +
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

//Bay gio 21h23p
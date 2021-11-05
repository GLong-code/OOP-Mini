package Model;

import java.time.LocalDate;
import java.util.Date;

public class Food {
    protected int foodID;
    protected String describe;
    protected int quantity;
    protected LocalDate importDay;
    protected LocalDate expiry;
    protected int foodClass;
    protected double atribute;

    public Food(int foodID, String describe, int quantity, LocalDate importDay, LocalDate expiry, int foodClass, double atribute) {
        this.foodID = foodID;
        this.describe = describe;
        this.quantity = quantity;
        this.importDay = importDay;
        this.expiry = expiry;
        this.foodClass = foodClass;
        this.atribute = atribute;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getFoodClass() {
        return foodClass;
    }

    public void setFoodClass(int foodClass) {
        this.foodClass = foodClass;
    }

    public double getAtribute() {
        return atribute;
    }

    public void setAtribute(double atribute) {
        this.atribute = atribute;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getImportDay() {
        return importDay;
    }

    public void setImportDay(LocalDate importDay) {
        this.importDay = importDay;
    }

    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodID=" + foodID +
                ", foodClass=" + foodClass +
                ", describe='" + describe + '\'' +
                ", quantity=" + quantity +
                ", importDay=" + importDay +
                ", expiry=" + expiry +
                ", atribute=" + atribute +
                '}';
    }
}

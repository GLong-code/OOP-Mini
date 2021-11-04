package Model;

import java.time.LocalDate;
import java.util.Date;

public class Food {
    protected String foodID;
    protected String descbribe;
    protected int quantity;
    protected LocalDate importDay;
    protected LocalDate expiry;

    public Food(String foodID, String descbribe, int quantity, LocalDate importDay, LocalDate expiry) {
        this.foodID = foodID;
        this.descbribe = descbribe;
        this.quantity = quantity;
        this.importDay = importDay;
        this.expiry = expiry;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getDescbribe() {
        return descbribe;
    }

    public void setDescbribe(String descbribe) {
        this.descbribe = descbribe;
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
                "foodID='" + foodID + '\'' +
                ", descbribe='" + descbribe + '\'' +
                ", quantity=" + quantity +
                ", importDay=" + importDay +
                ", expiry=" + expiry +
                '}';
    }
}

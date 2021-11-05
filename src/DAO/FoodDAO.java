package DAO;

import Connection.DBConnection;
import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class FoodDAO {

    public void insertFood(String describeFood, int quantity, String expiry, int foodClass, double atribute) throws SQLException {
        Connection connection = DBConnection.getConnection();

        String insert = "insert into food(describeFood, quantity, expiry, foodClass, atribute) value('" + describeFood +"'," + quantity + ", '" + expiry+ "', "+foodClass+", "+ atribute+")";
        PreparedStatement pe = connection.prepareStatement(insert);
        pe.execute();
    }

    public void deleteFood(int foodID){
        Connection connection = DBConnection.getConnection();
        String delete = "delete from food where foodID = " + foodID;
        PreparedStatement pe;
        try {
            pe = connection.prepareStatement(delete);
            pe.execute();
            System.out.println("Delete successfully");
        }
        catch (SQLException e){
            System.out.println("Can not delete");
        }
    }

    public void expiredFood() throws SQLException, ParseException{
        ArrayList<Object> allFood = getAllFood();
        LocalDate today = LocalDate.now();
        System.out.println(today.getMonth());

        for(int i =0; i < allFood.size(); i++){
            Food food = (Food) allFood.get(i);

            if(today.compareTo(food.getExpiry()) > 0){
                System.out.println("Delete " + food.getFoodID() + " expired in " + food.getExpiry().getMonth() + "expired : " + today.compareTo(food.getExpiry()) + " ago");
            }
            else {
                System.out.println("Notthing to delete");
            }
        }
    }

    public void updateFood(int foodID,String describeFood, int quantity, String expiry, int foodClass, double atribute) throws SQLException{
        Connection connection = DBConnection.getConnection();
        String update = "update food set describeFood = '" +describeFood+"', quantity = " + quantity + ", expiry = '" + expiry+ "', foodClass = "+foodClass+", atribute= "+ atribute+" where foodID = " + foodID;
        PreparedStatement pe = connection.prepareStatement(update);
        pe.execute();
    }

    public ArrayList<Object> findbyName(String describeFood) throws SQLException, ParseException{
        Connection connection = DBConnection.getConnection();
        String findbyName = "select * from food where describeFood like '%" + describeFood + "%'";
        PreparedStatement pe = connection.prepareStatement(findbyName);
        ResultSet rs = pe.executeQuery();
        ArrayList<Object> foodList = new ArrayList<>();

        while (rs.next()){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date importTime = format.parse(rs.getString("importDay"));
            Date expiryTime = format.parse(rs.getString("expiry"));

            int foodID = rs.getInt("foodID");
            int quantity = rs.getInt("quantity");
            LocalDate importDay = LocalDate.of(importTime.getYear() + 1900, importTime.getMonth() + 1 , importTime.getDate());
            LocalDate expiry = LocalDate.of(expiryTime.getYear() + 1900, expiryTime.getMonth() + 1 , expiryTime.getDate());
            String describe = rs.getString("describeFood");
            int foodClass = rs.getInt("foodClass");
            double atribute = rs.getDouble("atribute");
            if(foodClass == 1){
                DryFood dryFood = new DryFood(foodID,describe, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(dryFood);
            }
            else if(foodClass ==2){
                FreshFood freshFood = new FreshFood(foodID,describe, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(freshFood);
            }
        }
        return foodList;
    }

    public ArrayList<Object> findbyClass(String foodClass1) throws SQLException, ParseException{
        Connection connection = DBConnection.getConnection();
        String findbyClass;
        if(foodClass1 == "Dry Food"){
            findbyClass = "SELECT * FROM foodstoredb.food where foodClass = 1";
        }
        else{
            findbyClass = "SELECT * FROM foodstoredb.food where foodClass = 2;";
        }

        PreparedStatement pe = connection.prepareStatement(findbyClass);
        ResultSet rs = pe.executeQuery();
        ArrayList<Object> foodList = new ArrayList<>();

        while (rs.next()){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date importTime = format.parse(rs.getString("importDay"));
            Date expiryTime = format.parse(rs.getString("expiry"));

            int foodID = rs.getInt("foodID");
            int quantity = rs.getInt("quantity");
            LocalDate importDay = LocalDate.of(importTime.getYear() + 1900, importTime.getMonth() + 1 , importTime.getDate());
            LocalDate expiry = LocalDate.of(expiryTime.getYear() + 1900, expiryTime.getMonth() + 1 , expiryTime.getDate());
            String describe = rs.getString("describeFood");
            int foodClass = rs.getInt("foodClass");
            double atribute = rs.getDouble("atribute");
            if(foodClass == 1){
                DryFood dryFood = new DryFood(foodID,describe, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(dryFood);
            }
            else if(foodClass ==2){
                FreshFood freshFood = new FreshFood(foodID,describe, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(freshFood);
            }
        }
        return foodList;
    }

    public ArrayList<Object> findbyExpiry(int year, int month, int day) throws SQLException, ParseException{
        Connection connection = DBConnection.getConnection();
        String findbyExp = "select * from food where expiry = '" +year+ "-" + month + "-" + day + "'";
        PreparedStatement pe = connection.prepareStatement(findbyExp);
        ResultSet rs = pe.executeQuery();
        ArrayList<Object> foodList = new ArrayList<>();

        while (rs.next()){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date importTime = format.parse(rs.getString("importDay"));
            Date expiryTime = format.parse(rs.getString("expiry"));

            int foodID = rs.getInt("foodID");
            int quantity = rs.getInt("quantity");
            LocalDate importDay = LocalDate.of(importTime.getYear() + 1900, importTime.getMonth() + 1 , importTime.getDate());
            LocalDate expiry = LocalDate.of(expiryTime.getYear() + 1900, expiryTime.getMonth() + 1 , expiryTime.getDate());
            String describe = rs.getString("describeFood");
            int foodClass = rs.getInt("foodClass");
            double atribute = rs.getDouble("atribute");
            if(foodClass == 1){
                DryFood dryFood = new DryFood(foodID,describe, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(dryFood);
            }
            else if(foodClass ==2){
                FreshFood freshFood = new FreshFood(foodID,describe, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(freshFood);
            }
        }
        return foodList;
    }

    public ArrayList<Object> getAllFood() throws SQLException, ParseException{
        Connection connection = DBConnection.getConnection();

        String select = "select * from food inner join foodClass on food.foodClass = foodClass.foodClass";
        PreparedStatement pe = connection.prepareStatement(select);
        ResultSet rs = pe.executeQuery();

        ArrayList<Object> foodList = new ArrayList<>();

        while (rs.next()){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date importTime = format.parse(rs.getString("importDay"));
            Date expiryTime = format.parse(rs.getString("expiry"));


            int foodID = rs.getInt("foodID");
            String describeFood = rs.getString("describeFood");
            int quantity = rs.getInt("quantity");
            LocalDate importDay = LocalDate.of(importTime.getYear() + 1900, importTime.getMonth() + 1 , importTime.getDate());
            LocalDate expiry = LocalDate.of(expiryTime.getYear() + 1900, expiryTime.getMonth() + 1 , expiryTime.getDate());


            int foodClass = rs.getInt("foodClass");
            double atribute = rs.getDouble("atribute");
            if(foodClass == 1){
                DryFood dryFood = new DryFood(foodID,describeFood, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(dryFood);
            }
            else if(foodClass ==2){
                FreshFood freshFood = new FreshFood(foodID,describeFood, quantity, importDay, expiry, foodClass, atribute);
                foodList.add(freshFood);
            }
        }
        return foodList;
    }

    public int totalCost(int month) throws SQLException, ParseException{
        Connection connection = DBConnection.getConnection();

        String select = "select * from food inner join foodClass on food.foodClass = foodClass.foodClass WHERE MONTH(importDay) = " + month;
        PreparedStatement pe = connection.prepareStatement(select);
        ResultSet rs = pe.executeQuery();

        ArrayList<Double> foodCost = new ArrayList<>();

        while (rs.next()){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date importTime = format.parse(rs.getString("importDay"));
            Date expiryTime = format.parse(rs.getString("expiry"));

            int foodID = rs.getInt("foodID");
            String describeFood = rs.getString("describeFood");
            int quantity = rs.getInt("quantity");
            LocalDate importDay = LocalDate.of(importTime.getYear() + 1900, importTime.getMonth() + 1 , importTime.getDay());
            LocalDate expiry = LocalDate.of(expiryTime.getYear() + 1900, expiryTime.getMonth() + 1 , expiryTime.getDay());
            int foodClass = rs.getInt("foodClass");
            double atribute = rs.getDouble("atribute");
            if(foodClass == 1){
                DryFood dryFood = new DryFood(foodID,describeFood, quantity, importDay, expiry, foodClass, atribute);
                foodCost.add(dryFood.getCost());
            }
            else if(foodClass ==2){
                FreshFood freshFood = new FreshFood(foodID,describeFood, quantity, importDay, expiry, foodClass, atribute);
                foodCost.add(freshFood.getCost());
            }
        }

        int cost = 0;
        for(int i =0; i < foodCost.size(); i++){
            cost += foodCost.get(i);
        }
        return cost;
    }
}

package DAO;

import Connection.DBConnection;

import java.sql.Statement;

public class DryFoodDAO {
    private static DBConnection dbConnection;

    public DryFoodDAO(DBConnection connection){
        dbConnection = connection;
    }

    public void createDryFoodTable(){
        try {
            Statement statement =dbConnection.getConnection().createStatement();
            String sqlCreate = "CREATE TABLE DRYFOOD() ";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package DAO;

import Connection.DBConnection;
import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public class FoodDAO {
    private static  DBConnection dbConnection;

    public FoodDAO(DBConnection connection){
        dbConnection = connection;
    }

    public void createFoodTable(){

    }
}

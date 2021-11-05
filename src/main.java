import Connection.DBConnection;
import DAO.FoodDAO;
import Model.DryFood;
import Model.Food;
import Model.FreshFood;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class main {
    public static void main(String[] args) throws SQLException, ParseException {
        FoodDAO foodDAO = new FoodDAO();

        System.out.println(foodDAO.findbyExpiry(2021,11,20));

    }
}



package database;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String INS = "INSERT INTO dish VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT * FROM dish";

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection;
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pres = null;
            pres = connection.prepareStatement(GET_ALL);

            ResultSet resultset = pres.executeQuery();

            while(resultset.next()){
                System.out.print(resultset.getInt("id") + " ");
                System.out.print(resultset.getString("title") + " ");
                System.out.println(resultset.getDouble("rating"));
            }
            connection.close();
//
//            pres = connection.prepareStatement(INS);
//            pres.setInt(1, 1);
//            pres.setString(2, "title");
//            pres.setString(3, "description");
//            pres.setFloat(4, 5.86f);
//            pres.setBoolean(5, true);
//            pres.setDate(7, new Date(Calendar.getInstance().getTimeInMillis()));
//            pres.setBlob(6, new FileInputStream("pica.png"));
//
//            pres.execute();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
        }
        //        Statement statment = connection.createStatement();
//        //statment.execute("INSERT INTO users (name, age, email) values ('Jdbc', 200, 'jdbc@ukr.net')");
//
//        String query = "select * from users";
//        ResultSet resultSet = statment.executeQuery(query);
//
//        while(resultSet.next()) {
//            int id = resultSet.getInt(1);
//            //System.out.print(id + " ");
//            String name = resultSet.getString(2);
//            //System.out.print(name + " ");
//            String password = resultSet.getString(3);
//            //System.out.println(password);
//            User user = new User(id, name, password);
//            System.out.println(user);
//
//
//        }
    }
}

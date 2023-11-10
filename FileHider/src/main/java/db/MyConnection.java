package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
       public static Connection connection= null;
        public static Connection getConnection(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filehider?useSSL=false","root","");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("connection successfull");
            return connection;

        }
        public static void closeconnection(){
                if(connection!=null){
                    try{
                        connection.close();
                    }catch (SQLException e){
                        System.out.println(e);
                    }
                }
        }


}

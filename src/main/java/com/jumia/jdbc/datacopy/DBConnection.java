package com.jumia.jdbc.datacopy;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class DBConnection {
    static Connection con =null;

    private DBConnection(){}//do not instantiate...KindOf Singleton

    public static Connection getConection() throws SQLException{

        Properties props=new Properties();
        FileInputStream fileInputStream;

        try{
            fileInputStream=new FileInputStream("src/main/db.properties");
            props.load(fileInputStream);

            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            if (con==null) {
                con = DriverManager.
                        getConnection(props.getProperty("DB_URL"),
                        props.getProperty("DB_USERNAME"),
                        props.getProperty("DB_PASSWORD"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void DBClose(){
        try {
            con.close();
            log.info("ShutingDown Connection");
        }catch (SQLException e){
            log.info("Failed to Close Db Connection");
        }
    }
}

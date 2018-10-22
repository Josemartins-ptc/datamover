package com.jumia.jdbc.datacopy.api.controllers;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class DBConnection {

    private static Connection conn =null;

    private DBConnection(){}//Kind Of Singleton

    public static Connection getConnection(){

        Properties props=new Properties();
        FileInputStream fileInputStream;

        try{
            fileInputStream=new FileInputStream("src/main/db.properties");
            props.load(fileInputStream);

            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            if (conn ==null) {
                conn = DriverManager.
                        getConnection(props.getProperty("DB_URL"),
                        props.getProperty("DB_USERNAME"),
                        props.getProperty("DB_PASSWORD"));
                log.info("connected to DB");
            }
        }catch (IOException | ClassNotFoundException | SQLException e) {
            log.info("Failed to open connection to DB " + props.getProperty("DB_URL") + " with username " + props.getProperty("DB_USERNAME"));
            e.printStackTrace();
        }
        return conn;
    }

    public static void DBClose(){
        try {
            conn.close();
            log.info("ShuttingDown Connection");
        }catch (SQLException e){
            log.info("Failed to Close Db Connection");
        }
    }
}

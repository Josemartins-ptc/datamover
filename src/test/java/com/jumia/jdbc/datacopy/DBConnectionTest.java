package com.jumia.jdbc.datacopy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DBConnectionTest {

    @Test
    void getConection() {
        Connection conn=null;
        try{
            conn=DBConnection.getConection();
        }catch (SQLException e){
            log.info("DB Connection Failed");
            e.printStackTrace();
        }finally {
            try{
                log.info("Trying DB Connection closing");
                conn.close();
            }catch(SQLException e){
                log.info("DB closing failed");
                e.printStackTrace();
            }
        }
    }

    @AfterAll
    static void release(){
        DBConnection.DBClose();
    }
}
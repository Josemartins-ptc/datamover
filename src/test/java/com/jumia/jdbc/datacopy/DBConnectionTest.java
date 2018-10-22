package com.jumia.jdbc.datacopy;

import com.jumia.jdbc.datacopy.api.controllers.DBConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;


class DBConnectionTest {

    @Test
    void getConnection() {

         DBConnection.getConnection();
    }

    @AfterAll
    static void release() {

        DBConnection.DBClose();
    }
}
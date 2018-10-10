package com.jumia.jdbc.datacopy;

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
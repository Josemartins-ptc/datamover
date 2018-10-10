package com.jumia.jdbc.datacopy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
class CatalogReaderTest {

    private DBCatalogReader catalogReader;

    @BeforeEach
    public void initialize(){
        catalogReader=new DBCatalogReader();
    }

    @Test
    void getDatabaseCatalog_Test() {
        List<String> dbBag= Collections.emptyList();
        try {
            dbBag=catalogReader.getDatabaseCatalog();
        }catch (SQLException e){
            log.info("Could not get DB catalog");
        }
        log.info("Databases Detected = " + dbBag.toString());
    }

    @Test
    void getTableCatalog_Test(){
        List<String> tableBag=Collections.emptyList();
        try{
            tableBag=catalogReader.getTableCatalog("test");
        }catch(SQLException e){
            log.info("Could not get table catalog");
        }
        log.info("Tables Detected = " + tableBag.toString());
    }

    @Test
    void getFieldCatalog(){
        List<String> fieldBag=Collections.emptyList();
        try{
            fieldBag=catalogReader.getFieldCatalog("test","pet");
        }catch (SQLException e){
            log.info("could not get fields from table");
        }
        log.info("Fields detected = " + fieldBag.toString());
    }

    @AfterAll
    static void release(){
        DBConnection.DBClose();
    }
}
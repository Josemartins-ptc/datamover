package com.jumia.jdbc.datacopy.gui.guicontrollers;

import com.jumia.jdbc.datacopy.DBCatalogReader;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class GuiController {

    DBCatalogReader dbCatalogReader=new DBCatalogReader();

    public List<String> getDatabases() {
       List<String> databaseBag= Collections.emptyList();
        try {
            databaseBag= dbCatalogReader.getDatabaseCatalog();
        }catch(SQLException ex){
            log.info("Failed to read DatabaseCatalog");
        }
        return databaseBag;
    }

    public List<String> getTables(String database){
        List<String> tablesBag=Collections.emptyList();
        if (database.isEmpty()){
            return tablesBag;
        }
        try{
            tablesBag=dbCatalogReader.getTableCatalog(database);
        }catch (SQLException ex){
            log.info("Failed to read TablesCatalog from " + database);
        }
        return tablesBag;
    }

    public List<String> getFields(String database,String table){
        List<String> fieldsBag=Collections.emptyList();
        if (table.isEmpty()){
            return fieldsBag;
        }
        try{
            fieldsBag=dbCatalogReader.getFieldCatalog(database,table);
        }catch (SQLException ex){
            log.info("failed to read fields catalog");
        }
        return fieldsBag;
    }
}

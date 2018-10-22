package com.jumia.jdbc.datacopy.gui.guicontrollers;

import com.jumia.jdbc.datacopy.api.QueryBuilder;
import com.jumia.jdbc.datacopy.api.controllers.DBCatalogService;
import com.jumia.jdbc.datacopy.api.models.DatabaseTask;
import com.jumia.jdbc.datacopy.api.WorkContext;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Slf4j
public class GuiController {

    private final DBCatalogService dbCatalogService =new DBCatalogService();
    private final DatabaseTask databaseTask=new DatabaseTask();

    public List<String> getDatabases() {
       List<String> databaseBag= Collections.emptyList();
        try {
            databaseBag= dbCatalogService.getDatabaseCatalog();
        }catch(SQLException ex){
            log.info("Failed to read DatabaseCatalog");
        }
        return databaseBag;
    }

    public List<String> getTables(final String database){
        List<String> tablesBag=Collections.emptyList();
        if (database.isEmpty()){
            return tablesBag;
        }
        try{
            tablesBag= dbCatalogService.getTableCatalog(database);
        }catch (SQLException ex){
            log.info("Failed to read TablesCatalog from " + database);
        }
        return tablesBag;
    }

    public List<String> getFields(final String database,final String table){
        List<String> fieldsBag=Collections.emptyList();
        if (table.isEmpty()){
            return fieldsBag;
        }
        try{
            fieldsBag= dbCatalogService.getFieldCatalog(database,table);
        }catch (SQLException ex){
            log.info("failed to read fields catalog");
        }
        return fieldsBag;
    }

    public String queryBuild(){
        QueryBuilder queryBuilder=new QueryBuilder();
        WorkContext workContext=WorkContext.getInstance();
        return databaseTask.getQuery().toString();
    }
}

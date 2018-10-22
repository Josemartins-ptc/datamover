package com.jumia.jdbc.datacopy.api.controllers;

import com.jumia.jdbc.datacopy.api.controllers.DBConnection;
import com.jumia.jdbc.datacopy.api.models.DatabaseColumn;
import com.jumia.jdbc.datacopy.api.models.TableFields;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DBCatalogService {

    private static final Connection conn;

    static {
        conn = DBConnection.getConnection();
    }

    public List<String> getDatabaseCatalog() throws SQLException {
        List<String> databaseBag = new ArrayList<>();
        ResultSet rs = conn.getMetaData().getCatalogs();
        while (rs.next()) {
            databaseBag.add(rs.getString(1));
        }
        return databaseBag;
    }

    public List<String> getTableCatalog(final String databaseName) throws SQLException {
        List<String> tableBag = new ArrayList<>();
        String[] types = {"TABLE"};
        ResultSet rs = conn.getMetaData().getTables(databaseName, null, "%", types);
        while (rs.next()) {
            tableBag.add(rs.getString(3));
        }
        return tableBag;
    }

    public List<String> getFieldCatalog(final String dataBaseName, final String tableName) throws SQLException {
        List<String> fieldsBag = new ArrayList<>();
        ResultSet rs = conn.getMetaData().getColumns(dataBaseName, null, tableName, "%");
        while (rs.next()) {
            fieldsBag.add(rs.getString(4));
        }
        return fieldsBag;
    }

    public TableFields getfieldTypeInfo(final String databaseName, final String tableName) throws SQLException {
        ResultSet rs = conn.getMetaData().getColumns(databaseName, null, tableName, null);
        List<DatabaseColumn> bagOfColumns =new  ArrayList<>();
        while (rs.next()) {
            DatabaseColumn databaseColumn = new DatabaseColumn(
                    rs.getString("COLUMN_NAME"),
                    rs.getString("TYPE_NAME"),
                    rs.getInt("COLUMN_SIZE"));
            bagOfColumns.add(databaseColumn);
        }
        TableFields tableFields = new TableFields();
        bagOfColumns.forEach(column -> tableFields.addField(tableName, bagOfColumns));
        return tableFields;
    }
}

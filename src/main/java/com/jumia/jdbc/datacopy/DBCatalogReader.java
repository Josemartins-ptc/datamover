package com.jumia.jdbc.datacopy;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DBCatalogReader {

    private static final Connection conn;

    static {
            conn = DBConnection.getConnection();
    }

    public List<String> getDatabaseCatalog() throws SQLException{
        List<String> databaseBag=new ArrayList<>();
        ResultSet rs= conn.getMetaData().getCatalogs();
            while (rs.next()) {
                databaseBag.add(rs.getString(1));
            }
            return databaseBag;
    }

    public List<String> getTableCatalog(final String databaseName)throws SQLException{
        List<String> tableBag=new ArrayList<>();
        String[] types = {"TABLE"};
        ResultSet rs=conn.getMetaData().getTables(databaseName,null,"%",types);
        while (rs.next()){
                tableBag.add(rs.getString(3));
        }
        return tableBag;
    }

    public List<String> getFieldCatalog(final String dataBaseName,final String tableName) throws SQLException{
        List<String> fieldsBag=new ArrayList<>();
        ResultSet rs= conn.getMetaData().getColumns(dataBaseName,null,tableName,"%");
        while (rs.next()){
            fieldsBag.add(rs.getString(4));
        }
        return fieldsBag;
    }
}

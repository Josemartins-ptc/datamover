package com.jumia.jdbc.datacopy.api.models;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString
public class TableFields {
    Map<String, List<DatabaseColumn>> tableFields=new HashMap<>();

    public void addField(String tableName, List<DatabaseColumn> databasefield){
        tableFields.put(tableName,databasefield);
    }

    public List<DatabaseColumn> getColumns(String tableName){
        return tableFields.get(tableName);
    }
}

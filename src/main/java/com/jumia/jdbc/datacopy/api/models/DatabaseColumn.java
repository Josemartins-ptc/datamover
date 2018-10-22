package com.jumia.jdbc.datacopy.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class DatabaseColumn {
    private final String columnName;
    private final String columnType;
    private final int columnSize;
}

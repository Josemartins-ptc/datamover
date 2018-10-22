package com.jumia.jdbc.datacopy.api.models;

import com.jumia.jdbc.datacopy.api.WorkContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author josemartins 2018-10-17
 */
@Slf4j
@Getter
public class DatabaseTask {

	private StringBuilder query=new StringBuilder("UPDATE");

	public String queryAdd(WorkContext workContext){
		String dataBaseName=workContext.getDatabase();
		String tableName=workContext.getTable();
		String sourceField=workContext.getSourceField();
		String destinationField=workContext.getDestinationField();
		query.append(" "+dataBaseName).
				append(".").
				append(tableName).
				append(" ").
				append("SET").
				append(" ").
				append(sourceField).append("=").append(destinationField);

		log.info("Current query status = " + query.toString());
		return query.toString();
	}
}

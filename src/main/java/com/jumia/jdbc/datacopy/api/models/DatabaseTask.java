package com.jumia.jdbc.datacopy.api.models;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author josemartins 2018-10-17
 */
@Slf4j
@Getter
public class DatabaseTask {

	private StringBuilder query=new StringBuilder("UPDATE");

	public String queryAdd(String querypart){
		query.append(" "+querypart);
		log.info("Current query status = " + query.toString());
		return query.toString();
	}
}

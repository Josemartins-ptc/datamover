package com.jumia.jdbc.datacopy.api.controllers;

import java.util.TimerTask;

import com.jumia.jdbc.datacopy.api.models.DatabaseTask;
import lombok.extern.slf4j.Slf4j;

/**
 * @author josemartins 2018-10-17
 */
@Slf4j
public class TaskController {

	void executeTimedTask(DatabaseTask databaseTask ){
		new java.util.Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				log.info("executing query =  " + databaseTask.getQuery());
				//do the query
			}
		},5000,5000);
	}
}

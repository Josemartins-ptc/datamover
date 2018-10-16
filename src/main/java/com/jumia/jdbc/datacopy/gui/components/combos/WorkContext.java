package com.jumia.jdbc.datacopy.gui.components.combos;

import lombok.Data;

@Data
public class WorkContext {

    private static WorkContext instance;

    private String Database="";
    private String Table="";
    private String sourceField="";
    private String destinationField="";

    private WorkContext(){}

    public static synchronized WorkContext getInstance(){
        if (instance==null){
            instance=new WorkContext();
        }
        return instance;
    }


}

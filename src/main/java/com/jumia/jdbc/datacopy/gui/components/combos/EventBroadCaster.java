package com.jumia.jdbc.datacopy.gui.components.combos;

import java.util.LinkedList;
import java.util.List;

public abstract class EventBroadCaster {

    private List<EventObserver> observers;

     EventBroadCaster(){
        observers=new LinkedList<>();
    }

    public EventBroadCaster(EventObserver observer){
        this();
        registerObserver(observer);
    }

    protected final void registerObserver(EventObserver observer){
        observers.add(observer);
    }

    protected void notifyObservers(DataCombo dc){
        for(EventObserver obs:observers){
            dc.OnDataComboEvent();
        }
    }
}

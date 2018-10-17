package com.jumia.jdbc.datacopy.gui.components.combos;

import java.util.*;

public interface EventBroadCaster {

    Map<DataCombo,DataCombo> notificators=new HashMap<>();

    static void registerBrodcaster(DataCombo notificator, DataCombo notificand) {
        notificators.put(notificator,notificand);
    }

    default void unRegisterNotificator(DataCombo notificator) {
        notificators.remove(notificator);
    }

    default  DataCombo notifyNotificands(DataCombo notificator) {
        DataCombo notified= notificators.get(notificator);
        notified.inform();
        return notified;
    }
}

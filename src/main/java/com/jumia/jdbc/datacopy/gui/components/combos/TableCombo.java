package com.jumia.jdbc.datacopy.gui.components.combos;


import com.googlecode.lanterna.gui2.ComboBox;
import com.jumia.jdbc.datacopy.api.WorkContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public class TableCombo implements DataCombo,EventBroadCaster {

    private final UUID uuid;
    private ComboBox<String> comboBox;
    private List<String> comboItens;
    private int currentlySelectedItem = 0;
    WorkContext workContext = WorkContext.getInstance();

    public TableCombo() {
        super();
        uuid=UUID.randomUUID();
        comboItens = Collections.emptyList();
        comboBox = new ComboBox<>(comboItens);
        comboBox.setSelectedIndex(-1);
        comboBox.setReadOnly(true);
        comboBox.addListener(listener);
    }

    private ComboBox.Listener listener = (selectedIndex, previousSelection) -> {
        log.info("detected combo Changes..updating table combo..Was " + previousSelection + " now is " + selectedIndex);
        workContext.setTable(comboBox.getSelectedItem());
        currentlySelectedItem = selectedIndex;
        notifyNotificands(this);
    };

    @Override
    public String getItem() {
        return comboBox.getItem(currentlySelectedItem);
    }

    @Override
    public ComboBox<String> addListener(ComboBox.Listener listener) {
        return this.comboBox;
    }

    @Override
    public void inform() {
        rePopulate();
    }

    @Override
    public ComboBox<String> getComBoBox() {
        return this.comboBox;
    }

    @Override
    public List<String> getComboItens() {
        return this.comboItens;
    }



    private void rePopulate() {
        if (comboBox.getItemCount() > 0) {
            comboBox = comboBox.clearItems();
        }
       workContext = WorkContext.getInstance();
        this.comboItens = guiController.getTables(workContext.getDatabase());
        for (String item : comboItens) {
            this.comboBox.addItem(item);
        }
        workContext.setTable(comboBox.getSelectedItem());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableCombo that = (TableCombo) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}


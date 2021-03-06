package com.jumia.jdbc.datacopy.gui.components.combos;

import com.googlecode.lanterna.gui2.ComboBox;
import com.jumia.jdbc.datacopy.api.WorkContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public class DestinationCombo implements DataCombo,EventBroadCaster {

    private final UUID uuid;
    private ComboBox<String> comboBox;
    private List<String> comboItens;
    private int currentlySelectedItem=0;

    public DestinationCombo(){
        super();
        uuid=UUID.randomUUID();
        comboItens= Collections.emptyList();
        comboBox=new ComboBox<String>(comboItens);
        comboBox.setSelectedIndex(-1);
        comboBox.setReadOnly(true);
        comboBox.addListener(listener);
    }

    private ComboBox.Listener listener= (selectedIndex, previousSelection) -> {
        log.info("detected combo Changes..updating destination field combo");
        currentlySelectedItem=selectedIndex;
    };

    @Override
    public String getItem() {
        return comboBox.getItem(currentlySelectedItem);
    }

    @Override
    public List<String> getComboItens() {
        return this.comboItens;
    }

    @Override
    public ComboBox<String> getComBoBox() {
            return this.comboBox;
    }

    @Override
    public ComboBox<String> addListener(ComboBox.Listener listener) {
            return this.comboBox;
    }

    @Override
    public void inform() {
        rePopulate();
    }

    private void rePopulate(){
        if (comboBox.getItemCount()>0) {
            comboBox = comboBox.clearItems();
        }
        WorkContext workContext=WorkContext.getInstance();
        this.comboItens =guiController.getFields(workContext.getDatabase(),workContext.getTable());
        for (String item: comboItens){
            this.comboBox.addItem(item);
        }
        comboBox.setSelectedIndex(0);
        workContext.setDestinationField(comboBox.getSelectedItem());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationCombo that = (DestinationCombo) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}

package com.jumia.jdbc.datacopy.gui.components.combos;

import com.googlecode.lanterna.gui2.ComboBox;
import com.jumia.jdbc.datacopy.api.WorkContext;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Data
public class DatabaseCombo  implements DataCombo,EventBroadCaster {

    private final UUID uuid;
    private ComboBox<String> comboBox;
    private List<String> bagOfItens = guiController.getDatabases();
    private int currentlySelectedItem=0;

    public DatabaseCombo(){
        super();
        uuid=UUID.randomUUID();
        this.comboBox=new ComboBox<>(bagOfItens);
        this.comboBox.addListener(listener);
    }

    private ComboBox.Listener listener=new ComboBox.Listener(){
        @Override
        public void onSelectionChanged(int selectedIndex, int previousSelection) {
            log.info("detected combo Changes..updating dependents");
            currentlySelectedItem=selectedIndex;
            setWorkContext(currentlySelectedItem);
            inform();

        }
    };

    private void setWorkContext(int selectedIndex){
        WorkContext workContext=WorkContext.getInstance();
        workContext.setDatabase(comboBox.getItem(selectedIndex));
    }


    @Override
    public String getItem() {
        return comboBox.getItem(currentlySelectedItem);
    }

    @Override
    public ComboBox<String> getComBoBox() {
        return this.comboBox;
    }

    @Override
    public ComboBox<String> addListener(ComboBox.Listener listener) {
        return null;
    }

    @Override
    public List<String> getComboItens() {
        return bagOfItens;
    }

    @Override
    public void inform() {
        notifyNotificands(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseCombo that = (DatabaseCombo) o;
        return Objects.equals(getUuid(), that.getUuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}

package com.grego.vgrep.gui.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ListValueFactory<T, V> implements Callback<TableColumn.CellDataFeatures<List<T>, V>, ObservableValue<V>> {

    private final String propertyName;

    public ListValueFactory(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public ObservableValue<V> call(TableColumn.CellDataFeatures<List<T>, V> p) {

        int index = 0;

        ListIterator<TableColumn<List<T>, ?>> iterator
                = p.getTableView().getColumns().listIterator();

        TableColumn tmpColumn;
        while (iterator.hasNext())
        {
            tmpColumn = iterator.next();

            if (tmpColumn == p.getTableColumn())
            {
                break;
            }
            else
            {
                index++;
            }
        }

        T object = p.getValue().get(index);

        try
        {
            Method method = object.getClass().getMethod(propertyName.concat("Property"));
            return (Property<V>) method.invoke(object);
        }
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex)
        {
            Logger.getLogger(ListValueFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

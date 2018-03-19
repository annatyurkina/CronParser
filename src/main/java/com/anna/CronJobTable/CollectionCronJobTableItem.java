package com.anna.CronJobTable;

public class CollectionCronJobTableItem extends CronJobTableItem {

    public CollectionCronJobTableItem(String name, int[] valuesCollection) {
        super(name);
        this.valuesCollection = valuesCollection;
    }

    private int[] valuesCollection;

    public int[] getValuesCollection() {
        return valuesCollection;
    }
}

package com.anna;

import com.anna.CronJobTable.CollectionCronJobTableItem;
import com.anna.CronJobTable.CronJobTable;
import com.anna.CronJobTable.CronJobTableItem;
import com.anna.CronJobTable.TextCronJobTableItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CronJobTablePresenter {
    private static final int FIELD_NAME_LENGTH = 14;

    final static Map<Class, Consumer<CronJobTableItem>> map = new HashMap<>();
    static {
        map.put(TextCronJobTableItem.class, cronJobTableItem -> present((TextCronJobTableItem) cronJobTableItem));
        map.put(CollectionCronJobTableItem.class, cronJobTableItem -> present((CollectionCronJobTableItem) cronJobTableItem));
    }

    public void present(CronJobTable cronJobTable) {
        CronJobTableItem[] items = cronJobTable.getItems();

        for(int i = 0; i < items.length; i++) {
            map.get(items[i].getClass()).accept(items[i]);
        }
    }

    private static String rightPad(String s) {
        return String.format("%1$-" + FIELD_NAME_LENGTH + "s", s);
    }

    private static void present(TextCronJobTableItem cronJobTableItem) {
        System.out.println(rightPad(cronJobTableItem.getHeader()) + cronJobTableItem.getTextValue());
    }

    private static void present(CollectionCronJobTableItem cronJobTableItem) {
        System.out.println(rightPad(cronJobTableItem.getHeader()) +
                ArrayHelper.getString(cronJobTableItem.getValuesCollection()));
    }
}

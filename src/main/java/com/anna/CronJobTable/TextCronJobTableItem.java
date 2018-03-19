package com.anna.CronJobTable;

public class TextCronJobTableItem extends CronJobTableItem {

    public TextCronJobTableItem(String header, String textValue) {
        super(header);
        this.textValue = textValue;
    }

    private String textValue;

    public String getTextValue() {
        return textValue;
    }
}

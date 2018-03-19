package com.anna.FieldParsingInfos.RangeFieldParsingInfos;

import com.anna.FieldParsingInfos.FieldParsingInfo;

public abstract class RangeFieldParsingInfo extends FieldParsingInfo {

    protected int minValue;
    protected int maxValue;

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}

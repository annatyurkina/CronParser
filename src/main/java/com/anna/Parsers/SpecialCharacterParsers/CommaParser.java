package com.anna.Parsers.SpecialCharacterParsers;

import com.anna.ArrayHelper;
import com.anna.FieldParsingInfos.RangeFieldParsingInfos.RangeFieldParsingInfo;

import java.text.ParseException;
import java.util.Arrays;

public class CommaParser implements ISpecialCharacterParser {

    public int[] parse(RangeFieldParsingInfo rangeField, String value) throws ParseException {

        int[] values = Arrays.stream(value.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        if(!ArrayHelper.isSortedArrayInRange(values, rangeField.getMinValue(), rangeField.getMaxValue())) {
            throw new ParseException("Invalid value for range field:" + value + ". " +
                    rangeField.getName() + " field cannot contain non-sorted elements or be outside [" +
                    rangeField.getMinValue() + ":" + rangeField.getMaxValue() + "].", 0);
        }

        return values;
    }
}

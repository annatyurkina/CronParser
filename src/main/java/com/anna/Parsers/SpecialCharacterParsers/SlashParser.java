package com.anna.Parsers.SpecialCharacterParsers;

import com.anna.ArrayHelper;
import com.anna.FieldParsingInfos.RangeFieldParsingInfos.RangeFieldParsingInfo;
import com.anna.Parsers.SpecialCharacterParsers.ISpecialCharacterParser;

import java.text.ParseException;

public class SlashParser implements ISpecialCharacterParser {

    public int[] parse(RangeFieldParsingInfo rangeField, String value) throws ParseException {
        int step = getValidStep(rangeField, value);

        return ArrayHelper.generate(rangeField.getMinValue(), rangeField.getMaxValue(), step);
    }

    private static int getValidStep(RangeFieldParsingInfo rangeField, String value) throws ParseException {

        int step = Integer.parseInt(value.substring(value.indexOf('/') + 1));

        if(step < 1 || step > rangeField.getMaxValue() - rangeField.getMinValue() + 1) {
            throw new ParseException("Invalid value for range field:" + value + ". " +
                    rangeField.getName() + " field cannot have step " + step, 0);
        }

        return step;
    }
}

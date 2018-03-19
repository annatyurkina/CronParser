package com.anna.Parsers.SpecialCharacterParsers;

import com.anna.ArrayHelper;
import com.anna.FieldParsingInfos.RangeFieldParsingInfos.RangeFieldParsingInfo;
import com.anna.Parsers.SpecialCharacterParsers.ISpecialCharacterParser;

import java.text.ParseException;

public class StarParser implements ISpecialCharacterParser {

    public int[] parse(RangeFieldParsingInfo rangeField, String value) throws ParseException {

        return ArrayHelper.generate(rangeField.getMinValue(), rangeField.getMaxValue(), 1);
    }
}

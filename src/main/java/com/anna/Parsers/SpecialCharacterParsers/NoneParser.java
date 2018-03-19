package com.anna.Parsers.SpecialCharacterParsers;

import com.anna.FieldParsingInfos.RangeFieldParsingInfos.RangeFieldParsingInfo;
import com.anna.Parsers.SpecialCharacterParsers.ISpecialCharacterParser;

import java.text.ParseException;

public class NoneParser implements ISpecialCharacterParser {

    @Override
    public int[] parse(RangeFieldParsingInfo rangeField, String value) throws ParseException {
        int[] result = new int[1];
        result[0] = Integer.parseInt(value);
        return result;
    }
}

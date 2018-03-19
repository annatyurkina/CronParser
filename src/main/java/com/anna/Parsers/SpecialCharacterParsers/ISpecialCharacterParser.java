package com.anna.Parsers.SpecialCharacterParsers;

import com.anna.FieldParsingInfos.RangeFieldParsingInfos.RangeFieldParsingInfo;

import java.text.ParseException;

public interface ISpecialCharacterParser {

    int[] parse(RangeFieldParsingInfo rangeField, String value) throws ParseException;
}

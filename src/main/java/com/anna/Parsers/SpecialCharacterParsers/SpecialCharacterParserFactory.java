package com.anna.Parsers.SpecialCharacterParsers;

import com.anna.Parsers.SpecialCharacters;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SpecialCharacterParserFactory {

    final static Map<String, Supplier<ISpecialCharacterParser>> map = new HashMap<>();
    static {
        map.put(SpecialCharacters.NONE, NoneParser::new);
        map.put(SpecialCharacters.STAR, StarParser::new);
        map.put(SpecialCharacters.DASH, DashParser::new);
        map.put(SpecialCharacters.SLASH, SlashParser::new);
        map.put(SpecialCharacters.COMMA, CommaParser::new);
    }

    public static ISpecialCharacterParser getParser(String type) throws ParseException {
        Supplier<ISpecialCharacterParser> parser = map.get(type);
        if(parser != null) {
            return parser.get();
        }
        throw new ParseException("Unknown field type.", 0);
    }

}

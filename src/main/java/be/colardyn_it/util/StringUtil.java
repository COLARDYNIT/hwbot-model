package be.colardyn_it.util;


import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static String makeUrlSafe(String name) {
        if (name == null) {
            return null;
        }
        name = StringUtils.lowerCase(name);
        StringBuffer safe = new StringBuffer();
        int sz = name.length();
        for (int i = 0; i < sz; i++) {
            char character = name.charAt(i);
            if (Character.isLetter(character) || Character.isDigit(character)) {
                safe.append(character);
            } else if (Character.isWhitespace(character)) {
                safe.append("_");
            } else if ('|' == character) {
                safe.append("i");
            } else if ('@' == character) {
                safe.append("a");
            } else if ('_' == character) {
                safe.append("_");
            } else if ('-' == character) {
                safe.append("_");
            } else if ('+' == character) { // AMD K6 2 and AMD K6 2+
                safe.append("_plus");
            } else {
                // ignore
            }
        }
        return safe.toString();
    }

}

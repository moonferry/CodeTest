package com.ferry.code;

import com.ferry.code.processor.AbstractProcessor;
import com.ferry.code.processor.ProcessorType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangpeng on 2023/7/10
 */
public class Question {

    Map<ProcessorType, AbstractProcessor> typeToProcessor = new HashMap<>();

    public void register(AbstractProcessor processor) {
        typeToProcessor.put(processor.getProcessorType(), processor);
    }

    /**
     * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, if the processor type is remove, remove them from the string,
     * else if the processor type is replace, replace them with a single character that comes
     * before it alphabetically. Repeat this process until there is no more than 3 identical
     * characters sitting besides each other.
     *
     * @param str the input string
     * @param type the operation to be performed, remove or replace
     * @return the processed string
     */
    public String question(String str, ProcessorType type) {
        if (str == null) {
            return "the input string is null";
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < 'a' || ch > 'z') {
                return "the input string is illegal";
            }
        }
        if (str.length() < 3) {
            return str;
        }
        char[] chars = str.toCharArray();
        int preLength, nowLength;
        do {
            preLength = chars.length;
            chars = handlerConsecutiveChar(chars, type);
            nowLength = chars.length;
        } while (preLength != nowLength);
        return String.valueOf(chars);
    }

    /**
     *  if 3 or more consecutive characters are identical in a chars,
     *  if the processor type is remove, remove them from the chars,
     *  else if the processor type is replace, replace them with a
     *  single character that comes before it alphabetically.
     *
     * @param chars the input chars
     * @param type the operation to be performed, remove or replace
     * @return the processed chars
     */
    private char[] handlerConsecutiveChar(char[] chars, ProcessorType type) {
        for (int i = 0; i <= chars.length - 3; i++) {
            int j = i + 1;
            boolean found = false;
            while (j < chars.length - 1 && chars[i] == chars[j] && chars[j] == chars[j + 1]) {
                j++;
                found = true;
            }
            if (found) {
                AbstractProcessor processor = typeToProcessor.get(type);
                chars = processor.handleChars(chars, i, j);
                break;
            }
        }
        return chars;
    }
}

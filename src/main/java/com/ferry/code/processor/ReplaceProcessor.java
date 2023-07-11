package com.ferry.code.processor;

import com.ferry.code.Question;

/**
 * Created by zhangpeng on 2023/7/10
 */
public class ReplaceProcessor extends AbstractProcessor {

    public ReplaceProcessor(Question question) {
        super(question);
    }

    @Override
    public ProcessorType getProcessorType() {
        return ProcessorType.REPLACE;
    }

    @Override
    public char[] handleChars(char[] chars, int startIndex, int endIndex) {
        return replaceChars(chars, startIndex, endIndex);
    }

    /**
     * replace sub chars with a single character that comes before it alphabetically from a chars,
     * 'aaa' is specially handled by directly removed, and return the new chars
     *
     * @param chars  the input chars
     * @param startIndex the start index position of the sub chars in the chars need to be replaced
     * @param endIndex the end index position of the sub chars in the chars need to be replaced
     * @return
     */
    private char[] replaceChars(char[] chars, int startIndex, int endIndex) {
        if (chars[startIndex] == 'a') {
            return removeChars(chars, startIndex, endIndex);
        }
        int nextEndIndex = endIndex + 1;
        char[] newChars = new char[chars.length - (nextEndIndex - startIndex) + 1];
        int i = 0;
        while (i < startIndex) {
            newChars[i] = chars[i];
            i++;
        }
        newChars[i++] = getBeforeChar(chars[startIndex]);
        while (i < newChars.length) {
            newChars[i++] = chars[nextEndIndex++];
        }
        System.out.println("->" + String.valueOf(newChars));
        return newChars;
    }

    /**
     * get a character that comes before the input character alphabetically
     *
     * @param ch the input character
     * @return
     */
    private char getBeforeChar(char ch) {
        int b = (int) ch - 1;
        return (char) b;
    }
}

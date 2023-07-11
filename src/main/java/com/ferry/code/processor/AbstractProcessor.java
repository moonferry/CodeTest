package com.ferry.code.processor;

import com.ferry.code.Question;

/**
 * The abstract processor defined abstract method handlerChars,
 * different subclasses have their own implementations.
 * Put concrete processor classes through constructors into
 * Map<ProcessorType, Processor>, Class that use processor
 * get the specific processor by processor type,
 * this design concept comes from the strategy pattern.
 *
 * Created by zhangpeng on 2023/7/10
 */
public abstract class AbstractProcessor {

    protected AbstractProcessor(Question question) {
        question.register(this);
    }

    public abstract ProcessorType getProcessorType();

    public abstract char[] handleChars(char[] chars, int startIndex, int endIndex);

    /**
     * remove sub chars from a chars, and return the new chars
     *
     * @param chars the input chars
     * @param startIndex the start index position of the sub chars in the chars need to be removed
     * @param endIndex the end index position of the sub chars in the chars need to be removed
     * @return
     */
    protected char[] removeChars(char[] chars, int startIndex, int endIndex) {
        int nextEndIndex = endIndex + 1;
        char[] newChars = new char[chars.length - (nextEndIndex - startIndex)];
        int i = 0;
        while (i < startIndex) {
            newChars[i] = chars[i];
            i++;
        }
        while (i < newChars.length) {
            newChars[i++] = chars[nextEndIndex++];
        }
        System.out.println("->" + String.valueOf(newChars));
        return newChars;
    }
}

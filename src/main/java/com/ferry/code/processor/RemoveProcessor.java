package com.ferry.code.processor;

import com.ferry.code.Question;

/**
 * Created by zhangpeng on 2023/7/10
 */
public class RemoveProcessor extends AbstractProcessor {

    public RemoveProcessor(Question question) {
        super(question);
    }

    @Override
    public ProcessorType getProcessorType() {
        return ProcessorType.REMOVE;
    }

    @Override
    public char[] handleChars(char[] chars, int startIndex, int endIndex) {
        return removeChars(chars, startIndex, endIndex);
    }
}

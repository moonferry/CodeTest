package com.ferry.code;

import com.ferry.code.processor.ProcessorType;
import com.ferry.code.processor.RemoveProcessor;
import com.ferry.code.processor.ReplaceProcessor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangpeng on 2023/7/10
 */
public class TestQuestion {

    Question question = new Question();
    RemoveProcessor removeProcessor = new RemoveProcessor(question);
    ReplaceProcessor replaceProcessor = new ReplaceProcessor(question);

    /**
     * Test if 3 or more consecutive characters are identical in a string, remove them from the string,
     * repeat this process until there is no more than 3 identical characters sitting besides each other.
     */
    @Test
    public void testRemoveConsecutiveCharacters() {
        Assert.assertEquals("the input string is null", question.question(null, ProcessorType.REMOVE));
        Assert.assertEquals("the input string is illegal", question.question("aaBBcc", ProcessorType.REMOVE));
        Assert.assertEquals("d", question.question("aabcccbbad", ProcessorType.REMOVE));
        Assert.assertEquals("aadd", question.question("abcaaaaccccccbbbbbadd", ProcessorType.REMOVE));
        Assert.assertEquals("", question.question("bbb", ProcessorType.REMOVE));
        Assert.assertEquals("", question.question("bbbbbbbb", ProcessorType.REMOVE));
        Assert.assertEquals("abc", question.question("abc", ProcessorType.REMOVE));
        Assert.assertEquals("aab", question.question("aab", ProcessorType.REMOVE));
        Assert.assertEquals("ab", question.question("ab", ProcessorType.REMOVE));
    }

    /**
     * Test if 3 or more consecutive characters are identical in a string, replace them witha single
     * character that comes before it alphabetically, repeat this process until there is no more than
     * 3 identical characters sitting besides each other.
     */
    @Test
    public void testReplaceConsecutiveCharacters() {
        Assert.assertEquals("d", question.question("abcccbad", ProcessorType.REPLACE));
        Assert.assertEquals("dd", question.question("abcaaaaccccccbbbbbadd", ProcessorType.REPLACE));
        Assert.assertEquals("a", question.question("bbb", ProcessorType.REPLACE));
        Assert.assertEquals("a", question.question("bbbbbbbb", ProcessorType.REPLACE));
        Assert.assertEquals("", question.question("aaa", ProcessorType.REPLACE));
        Assert.assertEquals("", question.question("aaaaaaaaa", ProcessorType.REPLACE));
        Assert.assertEquals("abc", question.question("abc", ProcessorType.REPLACE));
        Assert.assertEquals("aab", question.question("aab", ProcessorType.REPLACE));
        Assert.assertEquals("ab", question.question("ab", ProcessorType.REPLACE));
    }
}

package com.study.java11.api;

import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class StudyStringApis {

    @Test
    public void studyString_isBlank() {
        final String blankString="  \t\n";
        assertTrue(blankString.isBlank());      //blank is for whitespace
        assertFalse(blankString.isEmpty());
    }

    @Test
    public void studyString_lines() {
        //lines method gives the stream of the each line in the String
        final String multiLinesString = "line1\nline2\nline3\n";
        var list = multiLinesString.lines().collect(Collectors.toList());

        assertEquals(3, list.size());
    }

    @Test
    public void studyString_repeat() {
        //repeat is to concatenate the string n times
        final String originString = "_-_";
        assertEquals("_-__-_", originString.repeat(2));
    }

    @Test
    public void studyString_strip() {
        //strip is an enhanced version of trim(), strip will remove leading/tailing unicode space as well
        final char unicode_space = '\u2002';
        final String stringWithSpace= unicode_space + "remaining";
        assertNotEquals(stringWithSpace, stringWithSpace.strip());  //leading unicode space is removed
        assertEquals(stringWithSpace, stringWithSpace.trim());      //leading unicode space is not removed
    }
}

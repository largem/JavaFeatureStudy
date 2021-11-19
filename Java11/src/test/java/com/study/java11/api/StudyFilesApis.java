package com.study.java11.api;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.assertEquals;

public class StudyFilesApis {

    @Test
    public void studyFiles_writeString() throws IOException {
        final Path tempFile = Files.createTempFile("StudyFilesApis", ".txt");
        Files.writeString(tempFile, "studyFiles_writeString", StandardOpenOption.WRITE, StandardOpenOption.SYNC);

        assertEquals("studyFiles_writeString", Files.readString(tempFile));
    }
}

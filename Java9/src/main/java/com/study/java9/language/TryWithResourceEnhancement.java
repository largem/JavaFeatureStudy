package com.study.java9.language;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

//https://www.logicbig.com/tutorials/core-java-tutorial/java-9-changes/try-with-resource.html
public class TryWithResourceEnhancement {
    public static void main(String[] args) throws IOException {
        final InputStream inputStream1 = getInputStream("something");
        final InputStream inputStream2 = getInputStream("something else");

        try(inputStream1; inputStream2) {
            System.out.println(new String(inputStream1.readAllBytes()));
            System.out.println(new String(inputStream2.readAllBytes()));
        }

        System.out.println("Study TryWithResourceEnhancement Completed");
    }

    private static InputStream getInputStream(String contents) {
        return new ByteArrayInputStream(contents.getBytes()) {
            @Override
            public void close() throws IOException {
                System.out.println("closing the stream with contents \"" + contents + "\"");
                super.close();
            }
        };
    }
}

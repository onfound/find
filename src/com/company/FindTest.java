package com.company;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FindTest {
    Find file1 = new Find(true);
    Find file2 = new Find(false);

    @Test
    public void find() throws IOException {
        assertEquals("File is found", file1.find("testFile2.txt", System.getProperty("user.dir")));
        assertEquals("File is not found", file1.find(".txt", System.getProperty("user.dir")));
        assertEquals("File is not found",
                file2.find("testFile1.txt", System.getProperty("user.dir") + "\\directory1"));
        assertEquals("File is found",
                file1.find("testFile1.txt", System.getProperty("user.dir") + "\\directory1"));
        assertEquals("File is found",
                file1.find("testFile2", System.getProperty("user.dir") + "\\directory1\\directory2"));
        assertEquals("File is not found",
                file1.find("testFile3.txt", System.getProperty("user.dir") + "\\directory1\\testFile3"));
    }
}
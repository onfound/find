package com.company;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FindTest {
    private Find file1 = new Find(true, "testFile2.txt");
    private Find file2 = new Find(true, "testFile5.txt");
    private Find file3 = new Find(true, "testFile1.txt");
    private Find file4 = new Find(true, "testFile2.txt");
    private Find file5 = new Find(false, "testFile3.txt");
    private Find file6 = new Find(false, "testFile4.txt");

    @Test
    public void find() throws IOException {
        assertTrue(file1.find(System.getProperty("user.dir")));
        assertFalse(file2.find(System.getProperty("user.dir")));
        assertFalse(file5.find(System.getProperty("user.dir")));
        assertTrue(file3.find(System.getProperty("user.dir") + "\\directory1"));
        assertFalse(file4.find(System.getProperty("user.dir") + "\\directory1\\directory2"));
        assertFalse(file6.find(System.getProperty("user.dir") + "\\directory1"));
    }
}
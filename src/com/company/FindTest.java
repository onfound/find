package com.company;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class FindTest {
    private Find file1 = new Find(true);
    private Find file2 = new Find(true);
    private Find file3 = new Find(true);
    private Find file4 = new Find(true);
    private Find file5 = new Find(false);
    private Find file6 = new Find(false);
    @Test
    public void find() throws IOException {
        assertTrue( file1.find(System.getProperty("user.dir"),"testFile2.txt"));
        assertFalse(file2.find(System.getProperty("user.dir"),"testFile5.txt"));
        assertTrue(file5.find(System.getProperty("user.dir"),"testFile1.txt"));
        assertTrue(file3.find(System.getProperty("user.dir") + "\\directory1", "testFile2.txt"));
        assertFalse(file4.find(System.getProperty("user.dir") + "\\directory1\\directory2", "testFile3.txt"));
        assertFalse(file6.find(System.getProperty("user.dir") + "\\directory1", "testFile4.txt"));
    }
}
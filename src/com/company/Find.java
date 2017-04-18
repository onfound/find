package com.company;

import java.io.*;
import java.util.Objects;

class Find {
    final private Boolean subDirectory;
    final private String fileName;

    Find(Boolean subDirectory, String fileName) {
        this.subDirectory = subDirectory;
        this.fileName = fileName;
    }

    Boolean find(String directory) throws IOException {
        if (directory == null) directory = System.getProperty("user.dir");
        return getListFiles(directory);
    }

    private Boolean getListFiles(String directory) {
        File[] listFiles = new File(directory).listFiles();
        if (listFiles != null) {
            for (File fs : listFiles) {
                if (fs.isFile() && Objects.equals(fileName, fs.getName())) {
                    return true;
                }
                if (subDirectory && fs.isDirectory()) {
                    if (getListFiles(fs.getAbsolutePath())) return true;
                }
            }
        }
        return false;
    }
}

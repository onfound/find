package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

class Find {
    final private Boolean subDirectory;
    final private ArrayList<File> filesList = new ArrayList<>();

    Find(Boolean subDirectory) {
        this.subDirectory = subDirectory;
    }

    Boolean find(String directory, String fileName) throws IOException {
        if (directory == null) directory = System.getProperty("user.dir");
        getListFiles(directory);
        for (File fil : filesList) {
            if (Objects.equals(fileName, fil.getName())) return true;
        }
        return false;
    }

    private void getListFiles(String directory) {
        File f = new File(directory);
        if (f.listFiles() != null) {
            for (File fs : f.listFiles()) {
                if (fs.isFile()) {
                    filesList.add(fs);
                }
                if (subDirectory && fs.isDirectory()) {
                    getListFiles(fs.getAbsolutePath());
                }
            }
        }
    }
}

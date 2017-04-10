package com.company;

import java.io.*;

class Find {
    final private Boolean subDirectory;

    Find(Boolean subDirectory) {
        this.subDirectory = subDirectory;
    }

    String find(String fileName, String directory) throws IOException {
        String[] pathList;
        if (directory == null) directory = System.getProperty("user.dir");
        StringBuilder path = new StringBuilder(directory + "\\" + fileName);
        if (subDirectory) {
            for (int i = 0; i < directory.split("\\\\").length - 1; i++) {
                if (new File(path.toString()).exists()) {
                    return "File is found in subdirectory: " + path;
                }
                path.deleteCharAt(path.lastIndexOf("\\")).delete(path.lastIndexOf("\\"), path.length()).append("\\").append(fileName);
            }
            return "File is not found";
        } else {
            if (new File(path.toString()).exists()) return "File is found";
            else return "File is not found";
        }
    }
}

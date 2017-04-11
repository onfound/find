package com.company;

import java.io.*;
import java.util.ArrayList;

class Find {
    final private Boolean subDirectory;
    final private ArrayList<File> listWithFileNames = new ArrayList<>();
    Find(Boolean subDirectory) {
        this.subDirectory = subDirectory;
    }

    String find(String fileName, String directory)throws IOException{
        if (directory == null) directory = System.getProperty("user.dir");
        if (subDirectory){
            getListFiles(directory);
            if (listWithFileNames.contains(new File(fileName))) return "File is found";
        }
        else if (new File(directory + "\\" + fileName).exists()) return "File is found";
        return "File is not found";
    }

    private void getListFiles(String str) {
        File f = new File(str);
        for (File s : f.listFiles()) {
            if (s.isFile()) {
                listWithFileNames.add(s);
            } else if (s.isDirectory()) {
                getListFiles(s.getAbsolutePath());
            }
        }
    }
}

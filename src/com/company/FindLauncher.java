package com.company;

import org.kohsuke.args4j.*;

import java.io.*;

public class FindLauncher {

    @Option(name = "-r", metaVar = "SubDirect", usage = "Find Subdirectory")
    private boolean subDirectcory;

    @Option(name = "-d", metaVar = "Directory", usage = "Path to the File")
    private String directory;

    @Argument(metaVar = "FileName", required = true, usage = "File name")
    private String fileName;

    public static void main(String[] args) {
        new FindLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar find.jar [-r] [-d diretory] filename");
            parser.printUsage(System.err);
            return;
        }

        Find finder = new Find(subDirectcory);
        try {
            String result = finder.find(fileName, directory);
            System.out.println(result);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
package com.company;

import org.kohsuke.args4j.*;

import java.io.IOException;

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

        Find finder = new Find(subDirectcory, fileName);
        try {
            if (finder.find(directory)) System.out.println("File is found");
            else System.out.println("File is not found");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

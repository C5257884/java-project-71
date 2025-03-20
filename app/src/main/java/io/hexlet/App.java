package io.hexlet;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
    description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private File filepath1;
    @CommandLine.Parameters(index = "1", description = "path to second file ")
    private File filepath2;
    @Option(names = {"-f", "--format"}, description = " output format [default: stylish]")
    private String formatOption = "stylish";

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        byte[] fileContents1 = Files.readAllBytes(filepath1.toPath());
        byte[] fileContents2 = Files.readAllBytes(filepath2.toPath());
        var file1Length = fileContents1.length;
        var file2Length = fileContents2.length;
        System.out.println("File1 length = " + file1Length);
        System.out.println("File2 length = " + file2Length);

        new Differ().generate(fileContents1, fileContents2);

        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println("Done with exit code: " + exitCode);
        System.exit(exitCode);
    }
}

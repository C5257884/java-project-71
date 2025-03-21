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
    private File file1;
    @CommandLine.Parameters(index = "1", description = "path to second file ")
    private File file2;
    @Option(names = {"-f", "--format"}, description = " output format [default: stylish]")
    private String formatOption = "stylish";

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        String jsonStr1 = Files.readString(file1.toPath());
        String jsonStr2 = Files.readString(file2.toPath());

        var jsonStrLength1 = jsonStr1.length();
        var jsonStrLength2 = jsonStr2.length();

        System.out.println("File1 length = " + jsonStrLength1);
        System.out.println("File2 length = " + jsonStrLength2);

        new Differ().generate(jsonStr1, jsonStr2);

        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println("Done with exit code: " + exitCode);
        System.exit(exitCode);
    }
}

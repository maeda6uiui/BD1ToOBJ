package com.github.dabasan.bd1_to_obj;

import org.apache.commons.cli.*;

public class BD1ToOBJMain {
    private static String VERSION_STR = "BD1ToOBJ v1.0.0";

    public static void main(String[] args) {
        // コマンドライン引数を解析するための設定
        var options = new Options();

        var optionI = new Option("i", "inputFilepath", true, "Input filepath");
        var optionO = new Option("o", "outputFilepath", true, "Output filepath");
        var optionZ = new Option("z", "invertZ", false,
                "Inverts the model with respect to the Z-axis");
        var optionF = new Option("f", "flipV", false, "Flips texture V-coordinate");
        var optionH = new Option("h", "help", false, "Displays help");
        var optionV = new Option("v", "version", false, "Displays version info");

        optionZ.setArgs(0);
        optionF.setArgs(0);
        optionH.setArgs(0);
        optionV.setArgs(0);

        options.addOption(optionI);
        options.addOption(optionO);
        options.addOption(optionZ);
        options.addOption(optionF);
        options.addOption(optionH);
        options.addOption(optionV);

        // コマンドライン引数の解析
        var parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        // ヘルプの表示
        if (cmd.hasOption("h")) {
            var hf = new HelpFormatter();
            hf.printHelp("[options]", options);
            System.out.println("Specify amount of rotation in degree.");

            return;
        }
        // バージョン情報の表示
        if (cmd.hasOption("v")) {
            System.out.println(VERSION_STR);
            return;
        }

        String inputFilepath = cmd.getOptionValue("i");
        String outputFilepath = cmd.getOptionValue("o");

        if (inputFilepath == null) {
            System.err.println("Java-side error: Input filepath must be specified.");
            return;
        }
        if (outputFilepath == null) {
            System.err.println("Java-side error: Output filepath must be specified.");
            return;
        }

        boolean invertZ = false;
        boolean flipV = false;
        if (cmd.hasOption("z")) {
            invertZ = true;
        }
        if (cmd.hasOption("f")) {
            flipV = true;
        }

        // 変換処理
        var bd1ToObj = new BD1ToOBJ();
        int ret = bd1ToObj.convert(inputFilepath, outputFilepath, invertZ, flipV);
        if (ret == -1) {
            System.err.println("Java-side error: Failed to convert.");
            return;
        }
    }
}

package com.codurance.solid.isp.testable;

public class SystemFileWriter implements FileWriter {
    @Override
    public void writeFile(String fileName, String content) {
        System.out.println("Writing file " + fileName);
    }
}

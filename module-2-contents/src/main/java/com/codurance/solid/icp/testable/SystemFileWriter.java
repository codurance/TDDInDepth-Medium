package com.codurance.solid.icp.testable;

public class SystemFileWriter implements FileWriter {
    @Override
    public void writeFile(String fileName, String content) {
        System.out.println("Writing file " + fileName);
    }
}

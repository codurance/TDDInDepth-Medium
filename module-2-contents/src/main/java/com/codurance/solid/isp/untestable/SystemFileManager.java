package com.codurance.solid.isp.untestable;

public class SystemFileManager implements FileManager {
    @Override
    public void readFile(String fileName) {
        System.out.println("Reading file " + fileName);
    }

    @Override
    public void writeFile(String fileName, String content) {
        System.out.println("Writing file " + fileName);
    }

    @Override
    public void compressFile(String fileName) {
        System.out.println("Compressing file " + fileName);
    }

    @Override
    public void encryptFile(String fileName) {
        System.out.println("Encrypting file " + fileName);
    }

    @Override
    public void decompressFile(String fileName) {
        System.out.println("Decompressing file " + fileName);
    }

    @Override
    public void decryptFile(String fileName) {
        System.out.println("Decrypting file " + fileName);
    }
}

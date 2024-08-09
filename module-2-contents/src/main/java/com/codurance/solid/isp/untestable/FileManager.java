package com.codurance.solid.isp.untestable;

public interface FileManager {
    void readFile(String fileName);

    void writeFile(String fileName, String content);

    void compressFile(String fileName);

    void encryptFile(String fileName);

    void decompressFile(String fileName);

    void decryptFile(String fileName);
}

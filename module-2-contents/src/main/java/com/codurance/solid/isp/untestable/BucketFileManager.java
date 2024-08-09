package com.codurance.solid.isp.untestable;

public class BucketFileManager implements FileManager {
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
        throw new UnsupportedOperationException("Cannot compress file in Bucket");
    }

    @Override
    public void encryptFile(String fileName) {
        throw new UnsupportedOperationException("Cannot encrypt file in Bucket");
    }

    @Override
    public void decompressFile(String fileName) {
        throw new UnsupportedOperationException("Cannot decompress file in Bucket");
    }

    @Override
    public void decryptFile(String fileName) {
        throw new UnsupportedOperationException("Cannot decrypt file in Bucket");
    }
}

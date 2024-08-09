package com.codurance.solid.isp.testable;

public class SystemFileCompressor implements FileCompressor {
    @Override
    public void compressFile(String fileName) {
        throw new UnsupportedOperationException("Method not implemented");

    }

    @Override
    public void decompressFile(String fileName) {
        throw new UnsupportedOperationException("Method not implemented");

    }
}

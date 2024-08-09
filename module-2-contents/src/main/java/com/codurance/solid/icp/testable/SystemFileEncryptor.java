package com.codurance.solid.icp.testable;

public class SystemFileEncryptor implements FileEncryptor {
    @Override
    public void encryptFile(String fileName) {
        throw new UnsupportedOperationException("Method not implemented");

    }

    @Override
    public void decryptFile(String fileName) {
        throw new UnsupportedOperationException("Method not implemented");

    }
}

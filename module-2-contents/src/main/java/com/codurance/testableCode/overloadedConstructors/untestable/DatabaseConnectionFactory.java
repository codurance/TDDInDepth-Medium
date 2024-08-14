package com.codurance.testableCode.overloadedConstructors.untestable;

public class DatabaseConnectionFactory {
    public DatabaseConnection createFromConnectionString(String file) {
        throw new UnsupportedOperationException("Method not implemented");

    }
}

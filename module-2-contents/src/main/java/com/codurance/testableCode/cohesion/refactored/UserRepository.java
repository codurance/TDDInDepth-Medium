package com.codurance.testableCode.cohesion.refactored;

import java.sql.SQLException;

public interface UserRepository {
    void save(User user) ;

    double calculateAverageAge();
}

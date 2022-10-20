package com.dbexcercise.connection_practice.connectionmaker;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connection01 {

    Connection makeConnection() throws SQLException;
}

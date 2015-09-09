package com.formation.dao.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtils {
	public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Can not close connection");
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("Can not close statement");
				e.printStackTrace();
			}
		}
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("Can not close resultSet");
				e.printStackTrace();
			}
		}
	}
}

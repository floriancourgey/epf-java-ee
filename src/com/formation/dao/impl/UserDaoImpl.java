package com.formation.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.dao.UserDao;
import com.formation.dao.utils.DaoUtils;
import com.formation.entity.User;
import com.formation.exception.DAOException;

public class UserDaoImpl implements UserDao {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/formation";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private static UserDao INSTANCE = null;
	
	private UserDaoImpl(){
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new RuntimeException("Can not load Driver", e);
		}
	}
	
	@Override
	public List<User> getAll() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.createStatement();
			String sql = "SELECT * FROM user";
			resultSet = statement.executeQuery(sql);
			List<User> userList = new ArrayList<User>();
			while (resultSet.next()) {
				User user = User.builder()
						.setId(resultSet.getLong("id"))
						.setLogin(resultSet.getString("login"))
						.setPassword(resultSet.getString("password"))
						.build();
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			throw new DAOException("TODO better message");
		} finally {
			DaoUtils.closeAll(resultSet, statement, connection);
		}
	}

	@Override
	public User getById(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			List<User> userList = new ArrayList<User>();
			while (resultSet.next()) {
				User user = User.builder()
						.setId(resultSet.getLong("id"))
						.setLogin(resultSet.getString("login"))
						.setPassword(resultSet.getString("password"))
						.build();
				userList.add(user);
			}
			if(userList.size() > 1) {
				throw new DAOException("Database incorrect, duplicate id :"+id);
			} else if (userList.size() == 1) {
				return userList.get(0);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new DAOException("TODO better message");
		} finally {
			DaoUtils.closeAll(resultSet, statement, connection);
		}
	}

	public static UserDao getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new UserDaoImpl();
		}
		return INSTANCE;
	}
	
}

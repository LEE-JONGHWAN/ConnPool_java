package com.ezen.connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCPDataSourceTest {

	public static void main(String[] args) {
		try (var conn = DBCPDataSource.getConnection()) {
			var meta = conn.getMetaData();
			ResultSet resultSet = meta.getTables(null, null, null, 
					new String[]{"TABLE"}); 
			while(resultSet.next()) { 
			    String tableName = resultSet.getString("TABLE_NAME"); 
			    String remarks = resultSet.getString("REMARKS"); 
			    System.out.println(tableName + " " + remarks);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}


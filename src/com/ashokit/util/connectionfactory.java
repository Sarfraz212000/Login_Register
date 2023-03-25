package com.ashokit.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class connectionfactory {
 private static	DataSource ds=null;
 public static Connection getConneton() throws SQLException
	{
	    Connection con=null;
		try {
			if(ds==null)
			{
				FileInputStream file= new FileInputStream(new File("C:\\Users\\User\\Documents\\workspace-sts-3.9.6.RELEASE\\05-servlate-students\\db.properties"));
				Properties p= new Properties();
				p.load(file);

				HikariConfig config= new HikariConfig();
				config.setJdbcUrl(p.getProperty("db.url"));
				config.setUsername(p.getProperty("db.username"));
				config.setPassword(p.getProperty("db.password"));
				config.setDriverClassName("db.drivername");
				
				ds=new HikariDataSource(config);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds.getConnection();
		
	}

}

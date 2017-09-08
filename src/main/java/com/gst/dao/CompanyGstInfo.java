package com.gst.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("companyGstInfo")
public class CompanyGstInfo {
	
	@Autowired
	public DataSource dataSource;
	
	public String chkConn(){
		try {
			System.out.println(dataSource.getConnection());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

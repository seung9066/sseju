package com.sseju.java.employee.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("EmployeeVO")
public class EmployeeVO {
	private String empId;
	private String empName;
	private String empDept;
	private String empRank;
	private String auth;
	private String password;
	private String id;
}

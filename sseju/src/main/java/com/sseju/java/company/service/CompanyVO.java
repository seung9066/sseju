package com.sseju.java.company.service;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("CompanyVO")
public class CompanyVO {
	private String cpCode;
	private String cpName;
	private String cpCeo;
	private String cpTel;
	private String cpNo;
	private String cpAddr;
	private String id;
	private String password;
	private String auth;
}

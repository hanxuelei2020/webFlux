package com.hasut.webflux.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//实体类
@TableName(value = "tbl_user")
public class User {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String name;
	@TableField(value = "logic_flag")
	private Integer logicFlag;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, Integer logicFlag) {
		super();
		this.id = id;
		this.name = name;
		this.logicFlag = logicFlag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getlogicFlag() {
		return logicFlag;
	}
	public void setlogicFlag(Integer logicFlag) {
		this.logicFlag = logicFlag;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", logicFlag=" + logicFlag + "]";
	}
	
	
	
}

package com.dreamworks.sms.classInfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dreamworks.sms.classInfo.po.ClassInfoPo;

@Mapper
public interface ClassInfoMapper {
	
	public List<ClassInfoPo> getClassInfo();
	
}

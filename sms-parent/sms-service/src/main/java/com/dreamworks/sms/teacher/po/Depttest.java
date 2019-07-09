package com.dreamworks.sms.teacher.po;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@SuppressWarnings("serial")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class Depttest implements Serializable{
	
	private Long deptno;
	
	private String dname;
	
	private String db_source;
	
}

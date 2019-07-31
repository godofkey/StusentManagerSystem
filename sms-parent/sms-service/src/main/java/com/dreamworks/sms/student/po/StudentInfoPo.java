package com.dreamworks.sms.student.po;

import java.io.Serializable;
import java.util.Date;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.po.ClassInfoPo;
import com.dreamworks.sms.student.dto.StudentInfoDto;
import com.dreamworks.sms.student.dto.StudentInfoDto.StudentInfoDtoBuilder;

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
public class StudentInfoPo implements Serializable{

	private Integer studentId;

    private String studnetName;

    private boolean sex;

    private Date birth;

    private String adress;

    private Integer classId;

    private Integer grade;

    private String password;

    private ClassInfoPo classInfoPo;
}

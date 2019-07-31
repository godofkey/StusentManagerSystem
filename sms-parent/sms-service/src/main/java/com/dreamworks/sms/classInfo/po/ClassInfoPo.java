package com.dreamworks.sms.classInfo.po;

import java.io.Serializable;
import java.util.List;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.dto.ClassInfoDto.ClassInfoDtoBuilder;
import com.dreamworks.sms.student.dto.StudentInfoDto;

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
public class ClassInfoPo  implements Serializable{

	private Integer classId;

    private String className;

    private Integer classNum;

    private Integer grade;
    
    private List<StudentInfoDto> list;
}

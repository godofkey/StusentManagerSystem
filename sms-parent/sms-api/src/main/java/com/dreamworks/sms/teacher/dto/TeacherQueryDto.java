package com.dreamworks.sms.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: TeacherQueryDto
 * @Description: TODO
 * @Author: Jzxxxxx
 * @Date: Created in 2019/7/12 0012下午 4:36
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Accessors(chain = true)
public class TeacherQueryDto implements Serializable {

    private int tno;

    private String tpwd;

    private  int ttag;

    private int radio;

}

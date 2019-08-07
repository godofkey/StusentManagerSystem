package com.dreamworks.sms.score.po;

import java.io.Serializable;

import com.dreamworks.sms.classInfo.po.ClassInfoPo;
import com.dreamworks.sms.course.po.CourseInfoPo;
import com.dreamworks.sms.score.po.ScoreInfoPo.ScoreInfoPoBuilder;
import com.dreamworks.sms.student.po.StudentInfoPo;
import com.dreamworks.sms.teacher.po.TeacherInfoPo;

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
public class SumScoreInfoPo implements Serializable{

	private Integer scoreId;

    private Integer studentId;

    private Integer teacherId;

    private Integer classId;

    private Integer scoreNum;
    
    private Integer courseId;
    
    private Integer rowNum;
    
    private Integer schoolRowNum;
    
    private Integer sumScore;
}

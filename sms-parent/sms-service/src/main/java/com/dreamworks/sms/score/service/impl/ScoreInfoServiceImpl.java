package com.dreamworks.sms.score.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.score.dao.ScoreInfoMapper;
import com.dreamworks.sms.score.dto.ScoreInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoQueryDto;
import com.dreamworks.sms.score.dto.ScoreInfoReDto;
import com.dreamworks.sms.score.po.ScoreInfoPo;
import com.dreamworks.sms.score.po.SumScoreInfoPo;
import com.dreamworks.sms.score.service.ScorInfoService;
import com.dreamworks.sms.student.dto.StudentInfoDto;

@Service
public class ScoreInfoServiceImpl implements ScorInfoService{

	@Autowired
	private ScoreInfoMapper scoreInfoMapper;
	
	

	
	@Override
	public List<ScoreInfoDto> getScoreInfoByStudentId(ScoreInfoQueryDto scoreInfoQueryDto) {
		// TODO Auto-generated method stub
		
		
		List<ScoreInfoPo> list = scoreInfoMapper.getScoreInfoByStudentId(scoreInfoQueryDto);
		ScoreInfoReDto scoreInfoReDto3 = new ScoreInfoReDto(scoreInfoQueryDto.getStudentId(), null, null,scoreInfoQueryDto.getExaminationName());
		System.out.println(scoreInfoReDto3.getStudentId()+"================");
		SumScoreInfoPo sumScoreInfoPo1 = scoreInfoMapper.getSumScoreInfo(scoreInfoReDto3);
		scoreInfoReDto3.setClassId(list.get(0).getClassId());
		SumScoreInfoPo sumScoreInfoPo2 = scoreInfoMapper.getSumScoreInfo(scoreInfoReDto3);
		ScoreInfoPo sumScoreInfoPo = new ScoreInfoPo();
		sumScoreInfoPo.setRowNum(sumScoreInfoPo2.getRowNum());
		sumScoreInfoPo.setSchoolRowNum(sumScoreInfoPo1.getRowNum());
		sumScoreInfoPo.setScoreNum(sumScoreInfoPo2.getSumScore());
		
		List<ScoreInfoDto> l = new ArrayList<ScoreInfoDto>();
		ModelMapper modelMapper = new ModelMapper();
		for(ScoreInfoPo scoreInfoPo : list) {
		   ScoreInfoReDto scoreInfoReDto1 = new ScoreInfoReDto(scoreInfoPo.getStudentId(), scoreInfoPo.getClassId(), scoreInfoPo.getCourseId(),scoreInfoQueryDto.getExaminationName());
			System.out.println(scoreInfoReDto1.getStudentId()+"================");
		   ScoreInfoPo scoreInfoPo1 = scoreInfoMapper.getScoreInfoRowNum(scoreInfoReDto1);
		   scoreInfoPo.setRowNum(scoreInfoPo1.getRowNum());
		   System.out.println(scoreInfoPo.getStudentId()+"================");
		   ScoreInfoReDto scoreInfoReDto2 = new ScoreInfoReDto(scoreInfoPo.getStudentId(), null, scoreInfoPo.getCourseId(),scoreInfoQueryDto.getExaminationName());
		   System.out.println(scoreInfoReDto2.getStudentId()+"================");
		   ScoreInfoPo scoreInfoPo2 = scoreInfoMapper.getScoreInfoRowNum(scoreInfoReDto2);
		   scoreInfoPo.setSchoolRowNum(scoreInfoPo2.getRowNum());
		   
		   StudentInfoDto studentInfoDto = modelMapper.map(scoreInfoPo.getStudentInfoPo(),StudentInfoDto.class);
		   CourseInfoDto courseInfoDto = modelMapper.map(scoreInfoPo.getCourseInfoPo(),CourseInfoDto.class);
		   ScoreInfoDto sDto = modelMapper.map(scoreInfoPo,ScoreInfoDto.class);
		   sDto.setStudentInfoDto(studentInfoDto);
		   sDto.setCourseInfoDto(courseInfoDto);
		   l.add(sDto);
		}
		
		ScoreInfoDto scoreInfoDto = modelMapper.map(sumScoreInfoPo,ScoreInfoDto.class);
		CourseInfoDto c = new CourseInfoDto();
		c.setCourseName("总分");
		scoreInfoDto.setCourseInfoDto(c);
		l.add(scoreInfoDto);
		
		return l;
	}




	@Override
	public List<ScoreInfoDto> getListScoreInfo(ScoreInfoQueryDto scoreInfoQueryDto) {
		// TODO Auto-generated method stub
		List<ScoreInfoPo> list = scoreInfoMapper.getScoreInfoByStudentId(scoreInfoQueryDto);
		List<ScoreInfoDto> l = new ArrayList<ScoreInfoDto>();
		ModelMapper modelMapper = new ModelMapper();
		for(ScoreInfoPo scoreInfoPo : list) {   
		   StudentInfoDto studentInfoDto = modelMapper.map(scoreInfoPo.getStudentInfoPo(),StudentInfoDto.class);
		   CourseInfoDto courseInfoDto = modelMapper.map(scoreInfoPo.getCourseInfoPo(),CourseInfoDto.class);
		   ScoreInfoDto sDto = modelMapper.map(scoreInfoPo,ScoreInfoDto.class);
		   sDto.setStudentInfoDto(studentInfoDto);
		   sDto.setCourseInfoDto(courseInfoDto);
		   l.add(sDto);
		}				
		return l;
	}

}

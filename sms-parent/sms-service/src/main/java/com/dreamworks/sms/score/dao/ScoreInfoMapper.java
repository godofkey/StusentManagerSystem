package com.dreamworks.sms.score.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dreamworks.sms.course.po.CourseInfoPo;
import com.dreamworks.sms.score.dto.ScoreInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoQueryDto;
import com.dreamworks.sms.score.dto.ScoreInfoReDto;
import com.dreamworks.sms.score.po.ListScoreInfoPo;
import com.dreamworks.sms.score.po.ScoreInfoPo;
import com.dreamworks.sms.score.po.SumScoreInfoPo;

@Mapper
public interface ScoreInfoMapper {
  
	public List<ScoreInfoPo> getScoreInfoByStudentId(ScoreInfoQueryDto scoreInfoQueryDto);

    public ScoreInfoPo getScoreInfoRowNum(ScoreInfoReDto scoreInfoReDto);
    
    public SumScoreInfoPo getSumScoreInfo(ScoreInfoReDto scoreInfoReDto);
    
    public List<ListScoreInfoPo> getListScoreInfo(ScoreInfoReDto scoreInfoReDto);
    
    public int InsertListScoreInfo(List<ScoreInfoDto> list);
    
    public List<ScoreInfoPo> getClassScoreInfo(ScoreInfoQueryDto scoreInfoQueryDto);
    
}

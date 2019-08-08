package com.dreamworks.sms.score.service;

import java.util.List;

import com.dreamworks.sms.score.dto.ScoreInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoQueryDto;

public interface ScorInfoService {

	public List<ScoreInfoDto> getScoreInfoByStudentId(ScoreInfoQueryDto scoreInfoQueryDto);

	public List<ScoreInfoDto> getListScoreInfo(ScoreInfoQueryDto scoreInfoQueryDto);
	
	public int InsertListScoreInfo(List<ScoreInfoDto> list);
}

package com.dreamworks.sms.score.service;

import java.util.List;
import java.util.Map;

import com.dreamworks.sms.score.dto.ScoreInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoQueryDto;

public interface ScorInfoService {

	public List<ScoreInfoDto> getScoreInfoByStudentId(ScoreInfoQueryDto scoreInfoQueryDto);

	public List<ScoreInfoDto> getListScoreInfo(ScoreInfoQueryDto scoreInfoQueryDto);
	
	public int InsertListScoreInfo(List<ScoreInfoDto> list);
	
	public Map<Integer, List<ScoreInfoDto>> getClassScoreInfo(ScoreInfoQueryDto scoreInfoQueryDto);
	
	public List<ScoreInfoDto> getClassOneScoreInfo(ScoreInfoQueryDto scoreInfoQueryDto);
}

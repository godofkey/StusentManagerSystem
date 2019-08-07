package com.dreamworks.sms.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dreamworks.sms.resouce.JsonResult;
import com.dreamworks.sms.resouce.ResultCode;
import com.dreamworks.sms.score.dto.ScoreInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoQueryDto;
import com.dreamworks.sms.score.service.ScorInfoService;

@RestController
@RequestMapping("/ScoreInfoController")
@CrossOrigin
public class ScoreInfoController {

	@Autowired
	private ScorInfoService scorInfoService;
	
	@RequestMapping(value = "/getScoreInfoByStudentId",method = RequestMethod.POST)
	public JsonResult getScoreInfoByStudentId(ScoreInfoQueryDto scoreInfoQueryDto) {
		List<ScoreInfoDto> list = scorInfoService.getScoreInfoByStudentId(scoreInfoQueryDto);
		
		return new JsonResult(ResultCode.SUCCESS, "成功", list);
	}
	
	@RequestMapping(value = "/getListScoreInfo",method = RequestMethod.POST)
	public JsonResult getListScoreInfo(ScoreInfoQueryDto scoreInfoQueryDto) {
		List<ScoreInfoDto> list = scorInfoService.getListScoreInfo(scoreInfoQueryDto);
		
		return new JsonResult(ResultCode.SUCCESS, "成功", list);
	}

}

package com.dreamworks.sms.classInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.service.ClassInfoService;
import com.dreamworks.sms.resouce.JsonResult;
import com.dreamworks.sms.resouce.ResultCode;
import com.dreamworks.sms.score.dto.ScoreInfoDto;
import com.dreamworks.sms.score.dto.ScoreInfoQueryDto;

@RestController
@RequestMapping("/ClassInfoController")
@CrossOrigin
public class ClassInfoController {

	@Autowired
	private ClassInfoService classInfoService;
	
	@RequestMapping(value = "/getClassInfo",method = RequestMethod.POST)
	public JsonResult getClassInfo() {
		List<ClassInfoDto> list = classInfoService.getClassInfo();
		return new JsonResult(ResultCode.SUCCESS, "成功", list);
	}
	
}

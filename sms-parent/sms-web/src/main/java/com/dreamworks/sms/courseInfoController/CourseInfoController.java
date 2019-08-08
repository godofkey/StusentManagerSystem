package com.dreamworks.sms.courseInfoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dreamworks.sms.classInfo.dto.ClassInfoDto;
import com.dreamworks.sms.classInfo.service.ClassInfoService;
import com.dreamworks.sms.course.dto.CourseInfoDto;
import com.dreamworks.sms.course.service.CourseInfoService;
import com.dreamworks.sms.resouce.JsonResult;
import com.dreamworks.sms.resouce.ResultCode;

@RestController
@RequestMapping("/CourseInfoController")
@CrossOrigin
public class CourseInfoController {
	@Autowired
	private CourseInfoService courseInfoService;
	
	@RequestMapping(value = "/getCourseInfo",method = RequestMethod.POST)
	public JsonResult getClassInfo() {
		List<CourseInfoDto> list = courseInfoService.getCourseInfo();
		return new JsonResult(ResultCode.SUCCESS, "成功", list);
	}
	
}

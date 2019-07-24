package com.dreamworks.sms.teacher.controller;


import org.apache.shiro.SecurityUtils;


import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ClassName: TeacherLoginController
 * @Description: TODO
 * @Author: Jzxxxxx
 * @Date: Created in 2019/7/15 0015上午 10:15
 */
@RestController
@RequestMapping("/teacher")
public class TeacherLoginController {

    @Autowired
    private TeacherLoginService teacherLoginService;
    @RequestMapping("/findTeacherByTno")
    public JsonResult findTeacherByTno(TeacherQueryDto teacherQueryDto){
        TeacherDto teacherDto=teacherLoginService.findTeacherByTno((teacherQueryDto));
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(teacherQueryDto.getTno()),teacherQueryDto.getTpwd());
        try {
            subject.login(token);
            TeacherDto tDto=teacherLoginService.findTeacherByTno(teacherQueryDto);
            return new JsonResult(ResultCode.SUCCESS,"登录成功",tDto);
        } catch (UnknownAccountException e) {
            return new JsonResult(ResultCode.NOT_LOGIN, "用户名不存在");
        } catch(IncorrectCredentialsException e){
            return new JsonResult(ResultCode.FAIL, "密码错误");
        }

    }

}

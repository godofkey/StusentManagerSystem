import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login.vue'
import Home from '@/components/Home.vue'

//学生模块

import StudentHorizontal from '@/components/studentList/StudentHorizontal.vue'

import StudentLengthways from '@/components/studentList/StudentLengthways.vue'

import  StudentSelect   from '@/components/studentList/StudentSelect.vue'

import TeacherHome from '@/components/teacher/TeacherHome.vue'

import EnteringGrade from '@/components/teacher/teacherlist/EnteringGrade.vue'

import ScoreManagement from '@/components/teacher/teacherlist/ScoreManagement.vue'

import ManageHome from '@/components/manage/ManageHome.vue'

import Authentication from '@/components/manage/Authentication.vue'

import StudentManage from '@/components/manage/StudentManage.vue'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
      children:[
        {path:'/home/studenthorizontal',component:StudentHorizontal},//学生成绩横向比较
        {path:'/home/studentLengthways',component:StudentLengthways},//学生成绩纵向比较
        {path:'/home/studentselect',component:StudentSelect}//学生成绩查询
      ]
      
    },{
      path: '/teacher',
      name: 'teacher',
      component: TeacherHome,
      children:[
        {path:'/teacher/enteringgrade',component:EnteringGrade},
        {path:'/teacher/scoremanagement',component:ScoreManagement}
      ]
    },
    {
      path: '/manage',
      name: 'manage',
      component: ManageHome,
      children:[
        {path:'/manage/Authentication',component:Authentication},
        {path:'/manage/StudentManage',component:StudentManage}

      ]
    }
    
  ]
})

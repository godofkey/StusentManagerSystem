import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login.vue'
import Home from '@/components/Home.vue'

//学生模块

import StudentHorizontal from '@/components/studentList/StudentHorizontal.vue'

import StudentLengthways from '@/components/studentList/StudentLengthways.vue'

// import  StudentSelect   from '@/components/studentList/StudentSelect.vue'

// import TeacherHome from '@/components/teacher/TeacherHome.vue'

import EnteringGrade from '@/components/teacher/teacherlist/EnteringGrade.vue'

// import ScoreManagement from '@/components/teacher/teacherlist/ScoreManagement.vue'

import ManageHome from '@/components/manage/ManageHome.vue'

import Authentication from '@/components/manage/Authentication.vue'

import StudentManage from '@/components/manage/StudentManage.vue'

import StudentHome from '@/components/student/StudentHome.vue'

import StudentAuthentication from '@/components/student/StudentAuthentication.vue'

import StudentChangePas from "@/components/student/StudentChangePas.vue"

import StudentSelect from '@/components/student/StudentSelect.vue'

import TeacherHome from '@/components/teacher01/TeacherHome.vue'

import TeacherAuthentication from  '@/components/teacher01/TeacherAuthentication.vue'

import TeacherChangepas from '@/components/teacher01/TeacherChangepas.vue'

import ImportGrade from '@/components/teacher01/ImportGrade.vue'

import SourceManage from '@/components/teacher01/SourceManage.vue'

import SelectFail from '@/components/teacher01/SelectFail.vue'

import GradeHorizontal from '@/components/teacher01/GradeHorizontal.vue'

import GradeLengthways from '@/components/teacher01/GradeLengthways.vue'
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
      redirect:'/home/studentselect',
      component: StudentHome,
      children:[
        {path:'/home/studenthorizontal',component:StudentHorizontal},//学生成绩横向比较
        {path:'/home/studentLengthways',component:StudentLengthways},//学生成绩纵向比较
        {path:'/home/studentselect',component:StudentSelect},//学生成绩查询
        {path:'/home/studentAuthentication',component:StudentAuthentication},
        {path:'/home/studentChangePas',component:StudentChangePas}
      ]
      
    },{
      path: '/teacher',
      name: 'teacher',
      component: TeacherHome,
      children:[
        {path:'/teacher/importgrade',component:ImportGrade},//添加成绩
        {path:'/teacher/scoremanage',component:EnteringGrade},
        {path:'/teacher/teacherauthentication',component:TeacherAuthentication},
        {path:'/teacher/teacherchangepas',component:TeacherChangepas},
        {path:'/teacher/selectfail',component:SelectFail},
        {path:'/teacher/gradehorizontal',component:GradeHorizontal},
        {path:'/teacher/gradelengthways',component:GradeLengthways}
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

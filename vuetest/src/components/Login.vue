<template>
  <div id="login">
    <header class="login_header">
      <span>德清县小学生管理系统</span>
    </header>

    <div class="login_center">
      <img src="../assets/image/school.jpg" alt />

      <div class="login_form" id="login_form">
        <p>账号密码登陆</p>
        <el-divider></el-divider>
        <el-form
          :label-position="labelPosition"
          label-width="80px"
          :model="formLabelAlign"
          style="margin:40px "
          :rules="rules"
          ref="ruleForm"
        >
          <el-form-item label="用户名" prop="name" style="margin:50px 0; " >
            <el-input
              v-model="formLabelAlign.typeId"
              style="min-width:340px;"
              ref="name"
              placeholder="请输入学生学号/教师工号/管理员账号"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input
              v-model="formLabelAlign.password"
              style="min-width:340px"
              type="password"
              placeholder="请输入密码"
            ></el-input>
          </el-form-item>

          <!-- 角色登陆分类 -->
          <el-radio-group v-model="radio">
            <el-radio :label="3">学生</el-radio>

            <el-radio :label="6">教师</el-radio>
            <el-radio :label="9">管理员</el-radio>
          </el-radio-group>

          <!-- 提交表单 -->
          <el-form-item style=" position: relative;top: 20px;">
            <el-button type="primary" @click="ToHome()">登陆</el-button>
            <el-button>重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>

    <el-footer class="login_footer">
      <el-divider></el-divider>
      <span>Copyright © 2013 - 2018 Geographic information dreamworks.</span>

      <span class="login_footer_span2">技术支持：浙江地信梦工场孵化器有限公司</span>
    </el-footer>
  </div>
</template>

<script>
import store from "../vuex/store.js";
export default {
  data() {
    return {
      radio: 3,
      labelPosition: "right",
      formLabelAlign: {
        typeId: "",
        region: "",
        password: ""
      },
      data:{
        sname:""
      },
      rules: {
        name: [
          { required: true, message: "请输入您的名字", trigger: "blur" },
          { min: 2, max: 4, message: "长度在 2 到 4 个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" }
          //   { min: 4, max: 16, message: "长度在  到 4 个字符", trigger: "blur" }
        ]
      }
    };
  },
  store,

  methods: {
    ToHome() {
      var params = new URLSearchParams();
      params.append('studentId', this.formLabelAlign.typeId);
      params.append('password',this.formLabelAlign.password);
      

     if (this.radio == 3) {     
      this.Axios.post("http://localhost:8081/student/findStudentByStudentId", 
       params
      ).then((res)=>{
        debugger
        if(res.data.code==200){
          this.data.sname==res.data.data.name;
          this.$message({
          message: '登录成功',
          type: 'success'
         });
        localStorage.setItem("typeId",JSON.stringify(this.formLabelAlign.typeId))

          this.$router.push({ path: "home/studentselect" });
           
        }else{
          this.$message.error("账号或者密码错误");
        }
      },res=>{
        this.$router.push({ path: "home" });
      })
       
      } 


      if (this.radio == 6) {     
      this.Axios.post("http://localhost:8081/teacher/findTeacherByTeacherId", 
       params
      ).then((res)=>{
        debugger
        if(res.data.code==200){
          this.data.sname==res.data.data.name;
          
          this.$message({
          message: '登录成功',
          type: 'success'
         });
         localStorage.setItem("typeId",JSON.stringify(this.formLabelAlign.typeId))
          
        }else{
          this.$message.error("账号或者密码错误");
        }
      },res=>{
        this.$router.push({ path: "home" });
      })
       
      } 


      if (this.radio == 9) {     
      this.Axios.post("http://localhost:8081/educationalStaff/findStaffByEducationalStaffId", 
       params
      ).then((res)=>{
        debugger
        if(res.data.code==200){
          this.data.sname==res.data.data.name;
         this.$message({
          message: '登录成功',
          type: 'success'
         });
         localStorage.setItem("typeId",JSON.stringify(this.formLabelAlign.typeId))
           this.$router.push({ path: "manage" });
        }else{
          this.$message.error("账号或者密码错误");
        }
      },res=>{
        this.$router.push({ path: "home" });
      })
       
      } 
    

      localStorage.setItem("name", JSON.stringify(this.data.sname));
    }
  }

      // console.log(data);
    
  
};
</script>


<style lang="scss" scoped>
.login_header {
  height: 7.2rem;

  line-height: 7.2rem;

  background: #225177;

  span {
    font-size: 2rem;

    display: inline-block;

    position: relative;

    left: 30%;

    color: #ffff;
  }
}
.login_center {
  display: flex;

  margin: 5rem 20rem;
}

.login_form {
  background: #eee;

  p {
    position: relative;
    top: 10px;
    text-align: center;
  }
}

.login_footer {
  position: absolute;
  bottom: 5%;
  /* display: flex; */
  left: 23rem;
}
.el-button {
  margin-left: 50px;
}
.el-radio-group {
  font-size: 0;
  position: relative;
  left: 135px;
}
</style>
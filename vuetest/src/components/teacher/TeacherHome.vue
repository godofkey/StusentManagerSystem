<template>
  <div>
    <el-container>
      <!-- 头部区域 -->
      <el-header>
        <span style="position:relative; left:-20%;font-size:30px">学生信息管理系统</span>
        <el-dropdown style="float:right;" @command="handleCommand">
          <span class="el-dropdown-link">
            <img src="@/assets/image/用户.png" alt />
            Hi
            <i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">

            <!-- 身份验证 -->
            <el-popover placement="right" width="400" trigger="click">
              <div class="verification">
                <el-input
                  v-model="input"
                  placeholder="请绑定您的班级"
                  :disabled="isdisabled"
                  style="margin: 20px;
                         width: 80%"
                ></el-input>
                <el-button @click="ChangeDisabled()" style=" margin: 20px;">确认绑定</el-button>
                <el-button @click="RelieveDisabled()">解除绑定</el-button>
              </div>
              <el-dropdown-item slot="reference">身份验证</el-dropdown-item>
            </el-popover>
      
              <el-dropdown-item>
                <el-button type="text"  @click="dialogFormVisible = true">修改密码</el-button>
              </el-dropdown-item>
           

           

            <el-dropdown-item divided command="login">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>

      <!-- 内容区 -->
      <el-container>
        <el-aside width="300px">
          <ul>
            <li>
              <router-link to="/teacher/enteringgrade">录入成绩</router-link>
            </li>

            <li>
              <router-link to="/teacher/scoremanagement">成绩管理</router-link>
            </li>

            <li>浏览成绩</li>
            <li>更新成绩</li>
            <li>查询挂科学生</li>
            <li>成绩横向比较</li>
            <li>成绩纵向比较</li>
          </ul>
        </el-aside>
        <el-main>
           
          <router-view></router-view>
        </el-main>
      </el-container>
 
         <!-- 修改密码对话框 -->
      <el-dialog title="修改密码" :visible.sync="dialogFormVisible" :close-on-click-modal="false" >
          <el-form
            :model="ruleForm"
            status-icon
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
          >
            <el-form-item label="原密码" prop="age" type="password">
              <el-input v-model="ruleForm.age" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="pass">
              <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
              <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
    </el-container>
  </div>
</template>

<script>
import EnteringGrade from "./teacherlist/EnteringGrade.vue";
export default {
  data() {
    var checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("密码不能为空"));
      } else {
        callback();
      }
       };
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入新密码"));
      } else {
        if (this.ruleForm.checkPass !== "") {
          this.$refs.ruleForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      input: "",
      isdisabled: false,
      dialogFormVisible: false,
       ruleForm: {
        pass: "",
        checkPass: "",
        age: ""
      },
      // 修改密码验证规则
      rules: {
        pass: [{ validator: validatePass, trigger: "blur", required: "true" }],
        checkPass: [
          { validator: validatePass2, trigger: "blur", required: "true" }
        ],
        age: [{ validator: checkAge, trigger: "blur", required: "true" }]
      }
    
      
     
    };
  },
  methods: {
    // 编程式导航定位到登录界面
    handleCommand(command) {
      this.$router.push({ name: command });
    },
    // 身份验证确认绑定
    ChangeDisabled() {
      if (this.input == "") {
        this.$message({
          message: "请输入正确的班级信息",
          type: "warning"
        });
      } else {
        this.isdisabled = true;
      }
    },
    // 身份验证解除绑定
    RelieveDisabled() {
      this.isdisabled = false;
    },
    //  修改密码提交验证
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  //  修改密码重置方法
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
   
  }
};
</script>


<style lang="scss" >
.verification {
  width: 100%;
}

.el-header {
  background-color: #b3c0d1;
  color: #eee;
  text-align: center;
  line-height: 100px;
  min-height: 100px;
  background: #225177;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 90px;

  li {
    list-style: none;
  }
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
  padding: 10px;
}
.el-dialog{
  width: 30%;
}
</style>
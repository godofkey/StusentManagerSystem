<template>
  <div id="home">
    <el-container>
      <el-header>
        <span style="position:relative; left:-20%;font-size:30px">学生信息管理系统</span>
        <el-dropdown style="float:right;" @command="handleCommand">
          <span class="el-dropdown-link">
            <img src="@/assets/image/用户.png" alt />
            Hi {{username}}
            <i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>身份验证</el-dropdown-item>
            <template>
              <el-dropdown-item>
                <el-button type="text" @click="dialogFormVisible = true">修改密码</el-button>
              </el-dropdown-item>
            </template>

            <el-dropdown-item divided command="login">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>

        <div class="el-dialog">
          <el-dialog title="修改密码" :visible.sync="dialogFormVisible" class="el-dialog-tim" :close-on-click-modal="false">
            <el-form
              :model="ruleForm"
              status-icon
              :rules="rules"
              ref="ruleForm"
              label-width="100px"
              class="demo-ruleForm"
              
            >
            <el-form-item label="原密码" prop="age" type="password" >
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
        </div>
      </el-header>

      <!-- main主体 -->
      <el-container>
        <el-aside width="200px">
          <ul>
            <li>
              <router-link to="/home/studentselect" class="studentselect">
                <el-link :underline="false">成绩查询</el-link>
              </router-link>
            </li>
            <li>
              <router-link to="/home/studenthorizontal" class="studenthorizontal">
                <el-link :underline="false">成绩横向比较</el-link>
              </router-link>
            </li>
            <li>
              <router-link to="/home/studentLengthways" class="studentLengthways">
                <el-link :underline="false">成绩纵向比较</el-link>
              </router-link>
            </li>
          </ul>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import store from "../vuex/store.js";

export default {
  data() {
     var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('密码不能为空'));
        }else{
          callback();
        }
        // setTimeout(() => {
        //   if (!Number.isInteger(value)) {
        //     callback(new Error('请输入数字值'));
        //   } else {
        //     if (value < 18) {
        //       callback(new Error('必须年满18岁'));
        //     } else {
        //       callback();
        //     }
        //   }
        // }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入新密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
    return {
      activeIndex: "1",
      activeIndex2: "1",
      username: "",
      dialogFormVisible: false,
      form: {
        lastpassword: "",
        newpassword: "",
        confirmpassword: ""
      },
      formLabelWidth: "120px",
       ruleForm: {
          pass: '',
          checkPass: '',
          age: ''
        },
        rules: {
          pass: [
            { validator: validatePass, trigger: 'blur', required:"true" }
          ],
          checkPass: [
            { validator: validatePass2, trigger: 'blur',required:"true" }
          ],
          age: [
            { validator: checkAge, trigger: 'blur' ,required:"true"}
          ]
        }
      
    }
  },
  store,
  methods: {
    handleCommand(command) {
      this.$router.push({ name: command });
    },
    todo() {
      console.log(this.$store.state.count);
    },
    submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    
  },
  mounted() {
    var name = JSON.parse(localStorage.getItem("name"));
    console.log(name);
    this.username = name;
  }
};
</script>


<style lang="scss" scoped>
.el-header {
  background-color: #b3c0d1;
  color: #eee;
  text-align: center;
  line-height: 100px;
  min-height: 150px;
  background: #225177;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;

  li {
    list-style: none;
    .studentselect {
      text-decoration: none;
    }
    .studenthorizontal {
      text-decoration: none;
    }
    .studentLengthways {
      text-decoration: none;
    }
  }
}
.el-dialog-tim{
  width: 100%;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

.el-dropdown-link {
  color: #eee;
}
</style>



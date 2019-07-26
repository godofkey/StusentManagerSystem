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
                <el-button @click="isdisabled = false">解除绑定</el-button>
              </div>
              <el-dropdown-item slot="reference">身份验证</el-dropdown-item>
            </el-popover>
            <template>
              <el-dropdown-item>
                <el-button type="text" @click="dialogFormVisible = true">修改密码</el-button>
              </el-dropdown-item>
            </template>

            <el-dropdown-item divided command="login">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
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

      <!-- 修改密码对话框 -->
    
        <el-dialog title="修改密码" :visible.sync="dialogFormVisible" :close-on-click-modal="false" style="width:60%;left:20%">
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
import store from "../vuex/store.js";
import StudentSelect from "../components/studentList/StudentSelect.vue";

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
     
      username: "",
      dialogFormVisible: false,
     
      formLabelWidth: "120px",
      ruleForm: {
        pass: "",
        checkPass: "",
        age: ""
      },
      input: "",
      isdisabled: false,
     
      rules: {
        pass: [{ validator: validatePass, trigger: "blur", required: "true" }],
        checkPass: [
          { validator: validatePass2, trigger: "blur", required: "true" }
        ],
        age: [{ validator: checkAge, trigger: "blur", required: "true" }]
      }
    };
  },
  store,
  methods: {
    handleCommand(command) {
      this.$router.push({ name: command });
    },
   
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        this.resetForm(formName);
        if (valid) {
          this.$notify({
          title: '修改成功',
          message: '已成功修改密码',
          type: 'success'
        });
        this.dialogFormVisible = false;
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
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
    
  },
  components: {
    "v-studentselect": StudentSelect
  },

  mounted() {
    var name = JSON.parse(localStorage.getItem("name"));
    console.log(name);
    this.username = name;
  }
};
</script>


<style lang="scss" scoped>
.verification {
  width: 100%;
}


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



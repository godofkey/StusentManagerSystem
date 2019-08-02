<template>
    <div class="authentication">
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
    </div>
</template>

<script>
export default {
    data(){

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
        return{
        ruleForm: {
        pass: "",
        checkPass: "",
        age: ""
      },
       rules: {
        pass: [{ validator: validatePass, trigger: "blur", required: "true" }],
        checkPass: [
          { validator: validatePass2, trigger: "blur", required: "true" }
        ],
        age: [{ validator: checkAge, trigger: "blur", required: "true" }]
      }
        }
    },
    methods:{
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
}
</script>

<style lang="scss" scoped>
 .authentication{
    width: 500px;
   margin: 0 auto;
   transform: translate(0px,50%);
 }
 @media screen and (max-width: 500px) {
  .form-view {
    width: 300px;
    margin: 0 auto;
  }
}
</style>



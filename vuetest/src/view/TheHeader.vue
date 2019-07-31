<template>
    <div>
        学生信息管理系统
    <el-dropdown trigger="click"  @command="handleCommand('login')">
      <span class="el-dropdown-link">
        admin<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item icon="el-icon-back"  >退出登录</el-dropdown-item>
      
      </el-dropdown-menu>
    </el-dropdown>

    </div>
    
</template>

<script>
export default {
  data(){
    return{

    }
  },
  methods:{
     handleCommand(command) {
        this.$router.push({name:command})
      }
  }
}
</script>


<style>
.el-dropdown {
    float: right;
    margin-right: 50px;
    
}
  .el-dropdown-link {
    cursor: pointer;
    color: #eee;
    /* float: right; */
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>
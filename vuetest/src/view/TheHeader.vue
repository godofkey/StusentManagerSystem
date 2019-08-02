<template>
    <div class="theheader">
        学生信息管理系统
     <el-dropdown trigger="click" >
      <span class="el-dropdown-link">
        admin<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown" style="z-index: 2003;">
        <el-dropdown-item >退出登录</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  
  <el-dialog
  title="提示"
  :visible.sync="dialogVisible"
  width="30%"
  >
  <span>这是一段信息</span>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
</el-dialog>
    </div>
    
</template>

<script>
export default {
  data(){
    return{
      dialogVisible:false,
    }
  },
  methods:{
     handleCommand(command) {
        this.$router.push({name:command})
      },
      logout(){
        this.dialogVisible = true;
      }
  }
}
</script>


<style>
.el-dropdown{
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
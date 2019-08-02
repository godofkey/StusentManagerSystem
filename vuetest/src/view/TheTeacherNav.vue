<template>
<el-aside style="min-height: 100%; background-color: #545c64; overflow: hidden">
  <el-menu class="el-menu-vertical-demo" :default-openeds="['1','2']" router default-active="/CarouselTable" @open="handleOpen" @close="handleClose"
    background-color="#545c64" text-color="#fff" active-text-color="#409EFF">
    <el-submenu index="1">
      <template slot="title">
        <i class="el-icon-document"></i>
        <span>个人中心</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/teacher/teacherauthentication">身份验证</el-menu-item>
        <el-menu-item index="/teacher/teacherchangepas">修改密码</el-menu-item>
        
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-setting"></i>
        <span>成绩管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/teacher/importgrade">录入成绩</el-menu-item>
        <el-menu-item  index="/teacher/scoremanage">成绩管理</el-menu-item>
       <!-- <el-menu-item index="/FormView">成绩横向比较</el-menu-item> -->
       <!-- <el-menu-item >浏览成绩</el-menu-item> -->
        <!-- <el-menu-item >更新成绩</el-menu-item> -->
         <el-menu-item >查询挂科学生</el-menu-item>
          <el-menu-item >成绩横向比较</el-menu-item>
           <el-menu-item >成绩纵向比较</el-menu-item>
        

      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</el-aside>
</template>

<script>
export default {
  name: 'TheNav',
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped lang="scss">
</style>

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
        <!-- <el-menu-item index="/home/studentChangePas">身份验证</el-menu-item> -->
        <el-menu-item index="/home/studentAuthentication">修改密码</el-menu-item>
        
      </el-menu-item-group>
    </el-submenu>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-setting"></i>
        <span>成绩管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="/home/studentselect">成绩查询</el-menu-item>
       <!-- <el-menu-item index="/FormView">成绩横向比较</el-menu-item> -->
       <el-menu-item index="/home/studenthorizontal">成绩纵向比较</el-menu-item>

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

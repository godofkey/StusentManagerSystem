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
            <el-dropdown-item>身份验证</el-dropdown-item>
            <template>
              <el-dropdown-item>
                <el-button type="text">修改密码</el-button>
              </el-dropdown-item>
            </template>

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
    </el-container>
  </div>
</template>

<script>
import EnteringGrade from "./teacherlist/EnteringGrade.vue";
export default {
  data() {
    return {};
  },
  methods:{
    handleCommand(command) {
      this.$router.push({ name: command });
    },
  }
};
</script>


<style lang="scss">
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
</style>
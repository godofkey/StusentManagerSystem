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
                <el-button type="text" @click="open">修改密码</el-button>
              </el-dropdown-item>
            </template>

            <el-dropdown-item divided command="login">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
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
    return {
      activeIndex: "1",
      activeIndex2: "1",
      username: ""
    };
  },
  store,
  methods: {
    handleCommand(command) {
      this.$router.push({ name: command });
    },
    todo() {
      console.log(this.$store.state.count);
    },
    open() {
      this.$prompt("请输入原密码", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消"
      })
        .then(({ value }) => {
          this.$message({
            //验证旧密码
            type: "success",
            message: "验证成功" 

           
          }),
           //再次弹出新密码框
            this.$prompt("请输入新密码", "提示", {
              confirmButtonText: "确定",
              cancelButtonText: "取消"
            }).then(({ value }) => {
              this.$message({
                //提交新密码
                type: "success",
                message: "验证成功" + value

                
              });
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入"
          });
        });
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
  min-height: 100px;
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
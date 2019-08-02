<template>
<el-container class="wrap">
  <el-header height="80px">
   <the-header></the-header> 
  </el-header>
  <el-container class="body-wrap">
    <the-studentnav  />
    <el-main>
      <div class="main">
        <router-view></router-view>
      </div>
    </el-main>
  </el-container>
</el-container>
</template>

<script>
import TheHeader from '../../view/TheHeader.vue'
import TheStudentNav from '../../view/TheStudentNav.vue'
export default {
  data(){
    return{
          
    }
  },
  components:{
    TheHeader,
   'the-studentnav': TheStudentNav
  }
    
    
  
}
</script>

<style scoped lang="scss">
@import '~@/common/css/base.scss';
.wrap {
  min-height: 96vh;
  .el-header {
    position: relative;
    background-color: #225177;
    line-height: 120px;
    min-height: 120px;
    color: #eee;
    font-size: 30px;
    padding-left: 20%;
    .el-button {
      position: absolute;
      left: 10px;
      top: 50%;
      transform: translateY(-60%);
      border: #fff;
      background-color: #fff;
      @media screen and (min-width: $smallSize){
        display: none
      }
    }
  }
  .body-wrap {
    position: relative;
    overflow: hidden;
    .el-aside {
      z-index: 999;
      min-width: 260px;
      max-width: 260px;
      height: calc(100vh - 100px);
      background-color: #D3DCE6;
      color: #333;
      @include tran-horizontal(0, 0.4s);
      @media screen and (max-width: $smallSize) {
        position: absolute;
        left: -200px;
      };
      &.open {
        @include tran-horizontal(100%, 0.4s);
      }
    }
    .el-main {
      z-index: 1;
      background-color: rgba(155, 155, 155, 0.1);
      color: #333;
      text-align: center;
      .main {
        background-color: #fff;
        padding: 10px;
        border-radius: 10px;
        min-height: calc(100vh - 200px)
      }
    }
    .el-footer {
      color: #333;
      line-height: 70px;
      text-align: center;
      background-color: #D3DCE6;
    }
  }
}
</style>

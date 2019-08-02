<template>
    <div class="importgrade">
        <h3 style="margin:20px">上传文件:</h3>
       <el-card>
    <el-select v-model="value" placeholder="请选择科目">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>


  <el-select v-model="classesvalue" placeholder="请选择班级">
    <el-option
      v-for="item in classes"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>

  
       </el-card>
    </div>
</template>

<script>
export default {
    data(){
        return{
          options:[{
              value:'1',
              label:'语文'
          },{
              value:'2',
              label:'数学'
          }],
          value:'',
          classes:[{
              value:'1',
              label:'223'
          },{
              value:'2',
              label:'224'
          }],
          classesvalue:'',
          
        }
    },
    methods:{
         
    }
}
</script>


<style lang="scss">

.importgrade{
    text-align: left;
    span{
       font-size: 25px;
     
    }
}
.el-card{
    margin: 10px;
}
</style>



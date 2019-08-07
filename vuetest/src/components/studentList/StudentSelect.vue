<template>
  <div id="studentselect" class="studentselect">
    <el-table
      :data="tableData"
      stripe
      show-summary
   
      sum-text="总分"
      style="width: 100%"
    >
      <el-table-column prop="date" label="科目" width="320"></el-table-column>
      <el-table-column prop="name" label="成绩" width="320"></el-table-column>
      <el-table-column prop="address" label="班级排名"></el-table-column>
      <el-table-column prop="colunm" label="全校排名"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  
  data() {
    return {
       
      tableData: [
        {
          date: "语文",
          name: 88,
          address: "3",
          colunm: "3"
        },
        {
          date: "数学",
          name: 65,
          address: "35",
          colunm: "3"
        },
        {
          date: "外语",
          name: 72,
          address: "22",
          colunm: "3"
        },
        {
          date: "化学",
          name: 92,
          address: "1",
          colunm: "3"
        },
        {
          date: "物理",
          name: 99,
          address: "1",
          colunm: "3"
        },
        {
          date: "生物",
          name: 78,
          address: "16",
          colunm: "3"
        }
      ]
    };
  },
  mounted() {
    var typeId = JSON.parse(localStorage.getItem('typeId'));
    var params = new URLSearchParams();

    params.append('studentId', this.formLabelAlign.typeId);
    this.Axios.post("http://localhost:8081/ScoreInfoController/getScoreInfoByStudentId", 
    params
      ).then((res)=>{
        
      },res=>{
        
      })
  },
  methods: {}
};
</script>

<style>
</style>
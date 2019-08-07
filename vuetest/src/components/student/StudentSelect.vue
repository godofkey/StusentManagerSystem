<template>
  <div id="studentselect" class="studentselect">
 <el-table :data="scoreInfo" stripe style="width: 100%">

      <el-table-column label="科目" >
        <template slot-scope="scope">{{ scope.row.courseInfoDto.courseName }}</template>
      </el-table-column>

       <el-table-column label="成绩">
        <template slot-scope="scope">{{ scope.row.scoreNum }}</template>
      </el-table-column>

      <el-table-column label="班级排名">
        <template slot-scope="scope">{{ scope.row.rowNum }}</template>
      </el-table-column>

       <el-table-column label="学校排名">
        <template slot-scope="scope">{{ scope.row.schoolRowNum }}</template>
      </el-table-column>
     
     <el-table-column label="总分">
        <template slot-scope="scope">{{ scope.row.schoolRowNum }}</template>
      </el-table-column>
    </el-table>


    </div>
</template>

<script>
export default {
  mounted() {
    debugger
  var params = new URLSearchParams();
      params.append('studentId', JSON.parse(localStorage.getItem('typeId')));
      params.append('examinationName', '1');
      
   this.Axios.post("http://localhost:8081/ScoreInfoController/getScoreInfoByStudentId", 
       params
      ).then((res)=>{
       this.scoreInfo=res.data.data;
      })
  },
  data() {
    return {
    scoreInfo:[]
       
    };
  },

  methods: {}
};
</script>

<style>
</style>
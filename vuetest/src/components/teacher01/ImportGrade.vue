<template>
    <div class="importgrade">
        <h3 style="margin:20px">上传文件:</h3>

       <el-card >
    <!-- <el-input v-model="subjectvalue" placeholder="请选择科目">

  </el-input> -->
   <el-select
          v-model="subjectvalue"
          placeholder="请选择科目"
          clearable
          >
          <el-option
            v-for="item in courseInfoList"
            :key="item.courseId"
            :label="item.courseName"
            :value="item.courseId"/>
        </el-select>

  <!-- <el-input v-model="classesvalue" placeholder="请选择班级">
  </el-input> -->
   <el-select
          v-model="classesvalue"
          placeholder="请选择班级"
          clearable
          
          >
          <el-option
            v-for="item in classInfoList"
            :key="item.classId"
            :label="item.className"
            :value="item.classId"/>
        </el-select>
         <el-select
          v-model="examvalue"
          placeholder="请选择考试场次"
          clearable
          
          >
          <el-option
            v-for="item in examList"
            :key="item.value"
            :label="item.name"
            :value="item.value"/>
        </el-select>
  

  
  <el-button type="primary" size="medium" @click="onSubmit">提交</el-button>

<el-form >
  <el-form-item>
            <el-upload
              ref="upload"
              action="/"
              :show-file-list="false"
              :on-change="importExcel"
              :auto-upload="false"
            >
              <el-button
                slot="trigger"
                icon="el-icon-upload"
                size="small"
                type="primary"
                width="100"
              >
                <span>上传文件</span>
              </el-button>
            </el-upload>
          </el-form-item>
        
</el-form>

 <el-button type="primary" :loading="false" class="primary">提交</el-button>
       </el-card>
    </div>
</template>

<script>
import XLSX from "xlsx";
import qs from	'qs';
export default {
   mounted() {
   debugger
   this.Axios.post("http://localhost:8081/CourseInfoController/getCourseInfo"
      ).then((res)=>{
       this.courseInfoList=res.data.data;
      })

        this.Axios.post("http://localhost:8081/ClassInfoController/getClassInfo"
      ).then((res)=>{
       this.classInfoList=res.data.data;
      })
  },
    data(){
        return{
          courseInfoList:[],
          classInfoList:[],
          dataList:[],
          examList:[
          {name : "第一次月考",value :"1"},
          {name : "第二次月考",value :"2"},
          {name : "期中考试",value :"3"},
          {name : "第三次月考",value :"4"}
          ],
          subjectvalue:'',
          classesvalue:'',
          examvalue:''
        }
    },
    methods:{
      onSubmit(){

      this.axios({
          method:"post",
          url:"http://localhost:8081/ScoreInfoController/InsertListScoreInfo",
          data: JSON.stringify(this.dataList),
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          }
        }).then((res)=>{
        if(res.data.code==200){
          this.$message({
          message: '提交成功',
          type: 'success'
         });
          } else {
          this.$message({
          message: '提交失败',
          type: 'success'
         });
          }
          })
      },
      checkData(data){
        var dataList = [];
        for(var i=0;i<data.length;i++){
        var d = {name:"",scoreNum:"",studentId:"",courseId:"",classId:"",examinationName:""}
        d.name=data[i].姓名;
        d.scoreNum=data[i].成绩;
        d.studentId=data[i].学号;
        d.courseId=this.subjectvalue;
        d.classId=this.classesvalue;
        d.examinationName=this.examvalue
        dataList.push(d);
        }
        debugger;
       this.dataList=dataList;
      },
      importExcel(file) {
      // let file = file.files[0] // 使用传统的input方法需要加上这一步
      const types = file.name.split(".")[1];
      const fileType = ["xlsx", "xlc", "xlm", "xls", "xlt", "xlw", "csv"].some(
        item => item === types
      );
      if (!fileType) {
        this.$message("格式错误！请重新选择");
        return;
      }
      this.file2Xce(file).then(tabJson => {
        if (tabJson && tabJson.length > 0) {
          debugger;
          console.log(this.dataList+"==================")
         this.checkData(tabJson[0].sheet)
          this.sheetName = tabJson;     
      var params = new URLSearchParams();
      var bb = JSON.stringify(this.dataList);
      var aa = {}
      aa.list=bb;
      params.append('list', bb);
      
      console.log(params);
      

    
         
          alert("您已成功添加文件");
        } else {
          alert("格式不正确");
          console.log(tabJson);
        }
      });
    },
    file2Xce(file) {
      return new Promise(function(resolve, reject) {
        const reader = new FileReader();
        reader.onload = function(e) {
          const data = e.target.result;
          this.wb = XLSX.read(data, {
            type: "binary"
          });
          const result = [];
          this.wb.SheetNames.forEach(sheetName => {
            result.push({
              sheetName: sheetName,
              sheet: XLSX.utils.sheet_to_json(this.wb.Sheets[sheetName])
            });
          });
          resolve(result);
        };
        reader.readAsBinaryString(file.raw);
        // reader.readAsBinaryString(file) // 传统input方法
      });
    }
    }
}
</script>


<style lang="scss" scoped>

.importgrade{
    text-align: left;
    
    
    span{
       font-size: 25px;
     
    }
}




    .el-input{
         margin-right: 20px;
         width:20%;
    }

   
    

    .el-button{
        line-height: 1;

        span{
           font-size: 10px;
        }
    }

.primary{
    height: 40px;
    /* float: right; */
    /* display: inline-block; */
    display: block;
    // position: absolute;
    /* right: -66%; */
   
}
</style>



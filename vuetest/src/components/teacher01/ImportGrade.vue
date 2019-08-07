<template>
    <div class="importgrade">
        <h3 style="margin:20px">上传文件:</h3>
       <el-card >
    <el-input v-model="subjectvalue" placeholder="请选择科目">
    
  </el-input>


  <el-input v-model="classesvalue" placeholder="请选择班级">
    
  </el-input>

  <el-input placeholder="请输入考试场次"  v-model="examvalue"></el-input>

<el-form>
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
export default {
    data(){
        return{
         
          subjectvalue:'',
          classesvalue:'',
          examvalue:''
          
        }
    },
    methods:{
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
          this.sheetName = tabJson;
          alert("您已成功添加文件");
          
        } else {
          alert("格式不正确");
          console.log(tabJson.length);
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


<style lang="scss">

.importgrade{
    text-align: left;
    
    span{
       font-size: 25px;
     
    }
}
.el-card__body{
    display:flex;
}
.el-card{
    margin: 10px;
    
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
}
.primary{
    height: 40px;
    /* float: right; */
    /* display: inline-block; */
    display: block;
    position: absolute;
    /* right: -66%; */
    right: 6%;
}
</style>



<template>
  <div>
    <el-container>
      <el-header>
        <el-form
          :inline="true"
          :model="formInline"
          class="demo-form-inline"
          :rules="rules"
          ref="ruleForm"
        >
          <el-form-item
            label="考试场次"
            :rules="[
      { required: true, message: '请输入邮箱地址', trigger: 'blur' },
    ]"
          >
            <el-input v-model="formInline.examsession" placeholder="考试场次"></el-input>
          </el-form-item>

          <el-form-item
            label="科目"
            :rules="[
      { required: true, message: '请输入邮箱地址', trigger: 'blur' },
    ]"
          >
            <el-select v-model="formInline.region" placeholder="科目">
              <el-option label="语文" value="语文"></el-option>
              <el-option label="数学" value="数学"></el-option>
              <el-option label="外语" value="外语"></el-option>
              <el-option label="生物" value="生物"></el-option>
              <el-option label="地理" value="地理"></el-option>
              <el-option label="政治" value="政治"></el-option>
              <el-option label="化学" value="化学"></el-option>
              <el-option label="物理" value="物理"></el-option>
              <el-option label="历史" value="历史"></el-option>
              <el-option label="体育" value="体育"></el-option>
              <el-option label="科学" value="科学"></el-option>
            </el-select>
          </el-form-item>

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

          <el-form-item>
            <el-button type="primary" @click="onSubmit()" title="添加到下方暂存区">添加</el-button>

            <el-button type="primary" :loading="istrue" @click="changeTrue()" title="提交到成绩管理区">提交</el-button>
          </el-form-item>
        </el-form>
      </el-header>

      <el-main>
        <el-table
          v-loading="loading"
          :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
          style="width: 100%"
          :default-sort="{prop: 'grade', order: 'descending'}"
        >
          <el-table-column prop="examsession" label="考试场次" width="300"></el-table-column>
          <el-table-column prop="name" label="姓名" width="220"></el-table-column>
          <el-table-column prop="subject" label="科目" width="220"></el-table-column>
          <el-table-column prop="grade" label="成绩" sortable width="225"></el-table-column>
        </el-table>

        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5,9]"
          :page-size="pagesize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="tableData.length"
        ></el-pagination>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import XLSX from "xlsx";

export default {
  data() {
    return {
      currentPage: 1, //初始页
      pagesize: 9, //    每页的数据
      userList: [],
      formInline: {
        user: "",
        region: "",
        grade: "",
        examsession: ""
      },
      rules: {
        examsession: [
          { required: true, message: "请输入考试场次", trigger: "blur" }
        ],
        region: [
          { required: true, message: "请输入科目", trigger: "blur" }
          //   { min: 4, max: 16, message: "长度在  到 4 个字符", trigger: "blur" }
        ]
      },

      tableData: [],
      sheetName: [],
      istrue: false,
      loading: false
    };
  },

  methods: {
    //分页
    handleSizeChange: function(size) {
      this.pagesize = size;
      console.log(this.pagesize); //每页下拉显示数据
    },
    handleCurrentChange: function(currentPage) {
      this.currentPage = currentPage;
      console.log(this.currentPage); //点击第几页
    },

    //读取excel文件
    onSubmit() {
      // this.tableData.push({
      //   examsession: this.formInline.examsession,
      //   name: this.formInline.user,
      //   grade: this.formInline.grade,
      //   subject: this.formInline.region

      if (this.sheetName.length == 0) {
        alert("请添加文件");
        //  console.log(this.tableData.length);
      } else {
        // });
        for (var i = 0; i < this.sheetName[0].sheet.length; i++) {
          //  this.formInline.user==this.xlsxJson[0].sheet[i].姓名;
          //  console.log(this.xlsxJson[0].sheet[i].姓名)
          this.tableData.push({
            name: this.sheetName[0].sheet[i].姓名,
            subject: this.formInline.region,
            examsession: this.formInline.examsession,
            grade: this.sheetName[0].sheet[i].成绩
          });

          console.log("111");
        }
        this.sheetName = "";
      }
    },
    formatter(row, column) {
      return row.address;
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
          this.sheetName = tabJson;
          alert("您已成功添加文件");
          //   console.log(this.sheetName.sheetName[0].sheet)

          // xlsxJson就是解析出来的json数据,数据格式如下
          // [
          //   {
          //     sheetName: sheet1
          //     sheet: sheetData
          //   }
          // ]
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
    },
    changeTrue() {
      if (this.formInline.examsession == "" || this.formInline.region == "") {
      }
      this.istrue = true;
      this.loading = true;
    }
  },

  mounted() {
    this.sheetName == 0;
  }
};
</script>


<style lang="scss" scoped>
.el-header {
  background-color: white;
  color: #eee;
  text-align: center;
  line-height: 0px;
  min-height: 100px;
}

.el-form {
  position: relative;
  top: 25%;
}

.el-main {
  line-height: 0;
  padding: 10px;
  li {
    line-height: 20px;
  }
}

.el-button {
  width: 100px;
  padding: none;
}
</style>
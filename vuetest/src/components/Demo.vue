<template>
  <div>
    <el-upload
      ref="upload"
      action="/"
      :show-file-list="false"
      :on-change="importExcel"
      :auto-upload="false"
    >
      <el-button slot="trigger" icon="el-icon-upload" size="small" type="primary">上传文件</el-button>
    </el-upload>

    <!-- <ul v-for="item in list">
      <li>{{item}}</li>
    </ul>

    <ul v-for="item in sheetName "> -->
      <!-- <li>{{item.姓名}}---{{item.成绩}}</li>
    </ul> -->
  </div>
</template>
 
<script>
import XLSX from "xlsx";
export default {
  data() {
    return {
      sheetName: [],
      list: [
        {
          title: "da",
          name: "zhangsan"
        },
        {
          title: "ba",
          name: "lisi"
        }
      ]
    };
  },
  methods: {
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
        if (tabJson && tabJson.length < 4) {
          this.xlsxJson = tabJson;
          console.log("数据", this.xlsxJson);

          for (var i = 0; i < this.xlsxJson[0].sheet.length; i++) {
            this.sheetName.push(this.xlsxJson[0].sheet[i]);
          }

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
    }
  }
};
</script>
 
<style>
.input-file {
  display: none;
}
</style>

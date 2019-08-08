<template>
  <div>
    <el-tabs v-model="activeName" @tab-click="printkey">
      <el-tab-pane v-for="item in tabledata" :label="item.title" :name="item.name" :key="item.name" >
        <!-- <el-table class="tb-edit" highlight-current-row :data="tableData" style="width: 100%;line-height:100px;" > -->
        <el-table :data="tableData" height="calc(100vh - 100px)" border style="width: 99%">
          <template v-for="(col,index) in cols">
            <el-table-column :prop="col.prop" :label="col.label" :key="index" ></el-table-column>
          </template>
          <el-table-column fixed="right" label="操作" width="100">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
              <el-button type="text" size="small">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import XLSX from "xlsx";
export default {

  data() {
    return {
      tabledata: [
        {
          title: "223班第一次月考总成绩汇总",
          name: "first"
        },
        {
          title: "224班第一次月考生物成绩汇总",
          name: "second"
        },
        {
          title: "225班第一次月考生物成绩汇总",
          name: "third"
        }
      ],
      cols: [
        { label: "姓名/学号", prop: "name", type: "normal" },
        { label: "语文", prop: "type", type: "sort" },
        { label: "数学", prop: "coordinate", type: "normal" },
        { label: "外语", prop: "english", type: "normal" },
        { label: "生物", prop: "math", type: "normal" },
        { label: "物理", prop: "poligy", type: "normal" },
        { label: "化学", prop: "huaxue", type: "normal" }
      ],
      key: "",
      tableData: [
        {
          name: " 张三",
          type: "88",
          status: "正常",
          coordinate: "89",
          english: "78",
          math: "82",
          poligy: "83",
          huaxue: "87"
        },
        {
          name: "李四",
          type: "99",
          status: "正常",
          coordinate: "29",
          english: "56",
          math: "86",
          poligy: "93",
          huaxue: "89"
        },
        {
          name: " 张三",
          type: "88",
          status: "正常",
          coordinate: "89",
          english: "78",
          math: "82",
          poligy: "83",
          huaxue: "87"
        },
        {
          name: "李四",
          type: "99",
          status: "正常",
          coordinate: "29",
          english: "56",
          math: "86",
          poligy: "93",
          huaxue: "89"
        },
        {
          name: " 张三",
          type: "88",
          status: "正常",
          coordinate: "89",
          english: "78",
          math: "82",
          poligy: "83",
          huaxue: "87"
        },
        {
          name: "李四",
          type: "99",
          status: "正常",
          coordinate: "29",
          english: "56",
          math: "86",
          poligy: "93",
          huaxue: "89"
        }
      ],

      activeName: "first"
    };
  },
  methods: {
    handleClick(row) {
      console.log(row);
    },
    printkey(data){
      console.log(data)
    }
  }
};
</script>

<style>
.el-tabs {
  /* padding-left: 35%; */
}
</style>

<template>
  <div class="sourcemanage">
    <el-tabs v-model="activeName" @tab-click="printkey">
      <el-tab-pane v-for="item in tabledata" :label="item.title" :name="item.name" :key="item.name" >
        <!-- <el-table class="tb-edit" highlight-current-row :data="tableData" style="width: 100%;line-height:100px;" > -->
        <el-table :data="tablevalue" height="calc(100vh - 100px)" border style="width: 99%">
          <template v-for="(col,index) in cols">
            <el-table-column :prop="col.prop" :label="col.label" :key="index" ></el-table-column>
          </template>
          <el-table-column fixed="right" label="操作" width="100">
            <template slot-scope="scope">
              <el-button @click="handleClick()" type="text" size="small">查看</el-button>
              <el-button type="text" size="small">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>
    <h3 v-if="istrue">点击表头可查看具体内容</h3>
  </div>
</template>
<script>

export default {

  data() {
    return {
      istrue:true,
      tabledata: [
        {
          title: "223班第一次月考总成绩汇总",
          name: "0"
        },
        {
          title: "224班第一次月考数学成绩汇总",
          name: "1"
        },
        {
          title: "225班第一次月考生物成绩汇总",
          name: "2"
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
       [ {
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
        }],
        [
          {
            name:'沈钦扬',
            coordinate:'82'
          },
          {
            name:'金赵兴',
            coordinate:'86'
          },
          {
            name:'盛朱哲',
            coordinate:'92'
          },
          {
            name:'朱佩',
            coordinate:'88'
          }
        ],
        [
          {
            name:'沈钦扬',
            math:'82'
          },
          {
            name:'金赵兴',
            math:'86'
          },
          {
            name:'盛朱哲',
            math:'92'
          },
          {
            name:'朱佩',
            math:'88'
          }
        ]
      ],

      activeName: "first",
      tablevalue:[],
    };
  },
  methods: {
    handleClick() {
      this.$router.push({path:'/teacher/studenthorizontal'})
    },
    printkey(data){
      this.istrue = false;
      console.log(data.$options.propsData.name);
      this.tablevalue = this.tableData[data.$options.propsData.name];
    }
  }
};
</script>

<style lang="scss">
.sourcemanage{
  h3{
        position: absolute;
    top: 40%;
    left: 50%;
    color: #33333361;
  }
}
</style>

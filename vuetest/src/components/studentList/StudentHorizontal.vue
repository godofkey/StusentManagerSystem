<template>
  <div id="studenthorizontal">
    <div class="title">xx班最近五次考试各科平均成绩横向对比图</div>

    <ul class="studenthorizontal_ul">
      <li v-for="(item,key) in formData" @click="dialogTableVisibleChange(key)">
        <div class="inner" >
         {{item}}
        </div>
      </li>
      <div id="echartContainer" style="width:500px;height:500px"></div>
    </ul>
    
    

    <!-- <el-dialog    :close-on-click-modal="false" > -->

    <!-- </el-dialog> -->
  </div>
</template>

<script>
var echarts = require("echarts");
export default {
  data() {
    return {
      formData: ["语文", "数学", "外语", "物理", "化学", "地理","物理", "化学", "地理","语文", "数学", "外语", "物理"],

      dialogTableVisible: [
        {
          title: "语文",
          col: false
        },
        {
          title: "数学",
          col: false
        },
        {
          title: "英语",
          col: false
        },
        {
          title: "物理",
          col: false
        },
        {
          title: "化学",
          col: false
        },
        {
          title: "地理",
          col: false
        }
      ],
      dialogFormVisible: false,
      boxShow: true,
      text: ["语文", "数学", "外语", "物理", "化学", "地理"],
      dataexamssion: [
        "第一次月考",
        "第二次月考",
        "第三次月考",
        "期中考试",
        "第四次月考"
      ],
      key: "",
      datagrade: [
        {
          data: [12, 36, 56, 82, 99]
        },
        {
          data: [22, 36, 26, 22, 29]
        },
        {
          data: [42, 56, 86, 42, 39]
        },
        {
          data: [12, 36, 56, 82, 99]
        },
        {
          data: [12, 36, 56, 82, 99]
        },
        {
          data: [12, 36, 56, 82, 99]
        }, {
          data: [12, 36, 56, 82, 99]
        },
        {
          data: [12, 36, 56, 82, 99]
        },
        {
          data: [12, 36, 56, 82, 99]
        },
        {
          data: [22, 36, 26, 22, 29]
        },
        {
          data: [42, 56, 86, 42, 39]
        },
        {
          data: [12, 36, 56, 82, 99]
        },
      ],
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: ""
      },
      formLabelWidth: "120px"
    };
  },
  methods: {
    dialogTableVisibleChange(key) {
      this.dialogFormVisible = true;

      var myChart = document.getElementById("echartContainer");

      var myChart01 = echarts.init(myChart);

      // console.log(myChart01);
      //  console.log(myChart01.id);

      // 指定图表的配置项和数据
      var option = {
        title: {
          text: this.text[key]
        },
        tooltip: {},
        legend: {
          data: ["分数"]
        },
        xAxis: {
          data: [
            "第一次月考",
            "第二次月考",
            "第三次月考",
            "期中考试",
            "第四次月考"
          ]
        },
        yAxis: {},
        series: [
          {
            name: "分数",
            type: "bar",
            data: this.datagrade[key].data
          }
        ]
      };
      console.log(myChart01);
      console.log(myChart01._chartsViews[0]);

      //使用刚指定的配置项和数据显示图表。
      myChart01.setOption(option);

      // myChart._chartsViews=;

      //   console.log(myChart.id.split("")[15]++);
    }

    //   open(key){
    //     const t = this;
    // setTimeout(() => {
    //   //  执行echarts画图方法
    //   t.dialogTableVisibleChange(key);
    // }, 0);
    //   }
  },
  mounted() {}
};
</script>

<style lang="scss" scoped>
.title {
  line-height: 100px;
  font-size: 25px;
}
.el-row {
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
  margin-top: 30px;
  line-height: 160px;

  div {
    font-size: 26px;
    background: #67c23a47;
  }

  div:hover {
    cursor: pointer;
    translate: all 1s;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  }
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.el-dialog {
  padding: 30px 100px;
}
.el-row::after,
.el-row::before {
  display: none;
}
.studenthorizontal_ul {
  display: flex;
  flex-wrap: wrap;
  li {
    width: 16.6%;
    box-sizing: border-box;
    padding: 15px;
    list-style: none;
    color: #f9fafc;
    font-size: 20px;
    .inner {
      // border: 1px solid black;
      cursor: pointer;
      background: #225177;
      border-radius: 5%;
    }
  }
}
</style>
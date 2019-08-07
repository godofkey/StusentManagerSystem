<template>
  <div id="studenthorizontal">
    

    <ul class="studenthorizontal_ul">
      <li v-for="(item,key) in formData" @click="dialogTableVisibleChange(key)" class="aa" :key="key">
        <div class="inner" >
         {{item}}
        </div>
      </li>
     
    </ul>
    
     <div id="echartContainer" style="width:500px;height:500px;left:30%"></div>

    <!-- <el-dialog    :close-on-click-modal="false" > -->

    <!-- </el-dialog> -->
  </div>
</template>

<script>
var echarts = require("echarts");
export default {
 
  data() {
    return {


      formData: [],

      
      dialogFormVisible: false,
      boxShow: true,
      text: [],
      dataexamssion: [
      ],
      key: "",
      datagrade: [],
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
      formLabelWidth: "120px",
      scoreInfoList:[]
    };
  },
   mounted() {
     var params1 = new URLSearchParams();
      params1.append('studentId', JSON.parse(localStorage.getItem('typeId')));
      params1.append('examinationName','1');
      
    var params2 = new URLSearchParams();
      params2.append('studentId', JSON.parse(localStorage.getItem('typeId')));
    
   this.Axios.post("http://localhost:8081/ScoreInfoController/getScoreInfoByStudentId", 
       params1
      ).then((res)=>{
        debugger
       var dataList = res.data.data;
       this.checkData(dataList);
      })


      this.Axios.post("http://localhost:8081/ScoreInfoController/getListScoreInfo", 
       params2
      ).then((res)=>{
       var scoreInfoList = res.data.data;
       this.transformationInfo(scoreInfoList);
      })
  },
  methods: {
    checkData(data){
      var dataList= [];
      for(var i=0; i<data.length;i++){
       dataList.push(data[i].courseInfoDto.courseName);
       this.formData = dataList;
       this.text = dataList;
       }
    },
    transformationInfo(scoreInfoList){
      var examinationNameKindList=[];
      var examinationNameList = [];
      for(var i=0;i<scoreInfoList.length;i++){
        if(examinationNameList.length===0){
          examinationNameList.push(scoreInfoList[i])
        }
         for(var j=0; j<examinationNameList.length;j++){
           
           if(scoreInfoList[i].examinationName === examinationNameList[j].examinationName){
             break
           }
           if(j === examinationNameList.length-1){
              examinationNameList.push(scoreInfoList[i])
           }
         }
      }
      for(var aa=0; aa<examinationNameList.length;aa++){
         var kk=[];   
         examinationNameKindList.push(kk);
      }
        for(var k=0 ;k<examinationNameList.length;k++){
          for(var z=0;z<scoreInfoList.length;z++){
          if(examinationNameList[k].examinationName === scoreInfoList[z].examinationName){
              examinationNameKindList[k].push(scoreInfoList[z]);
           }
          }
        }
        
        var exam = [];
        for(var i=0;i<examinationNameList.length;i++){
          
          exam.push(examinationNameList[i].examinationName);
        }
        
        this.transDataexamssion(exam);
        this.selectData(examinationNameKindList);
    },
    transDataexamssion(exam){
         for(var i=0;i<exam.length;i++){
           var k=i+1;
           
              this.dataexamssion.push("第"+k+"月考")
           
         }
    },
     selectData(examinationNameKindList ){
       var list = [];
   
       for(var i=0;i<examinationNameKindList[0].length;i++){
          var aa = {}; 
          list.push(aa);
          list[i].data=[];
       }
         for(var i=0;i<examinationNameKindList.length;i++){
             
          for(var j=0;j<examinationNameKindList[i].length;j++){
            
            debugger
            list[j].data.push(examinationNameKindList[i][j].scoreNum)
          }
        
       }
        this.datagrade=list;
      },
     
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
          data:this.dataexamssion
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
  }
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
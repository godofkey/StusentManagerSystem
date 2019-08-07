<template>
    <div class="selectfail">
        
        <el-container>
            
  <el-aside width="600px">
      <el-tabs v-model="activeName"   @tab-click="handleClick" >
    <el-tab-pane  v-for="(item,key) in tableData" :label="item.title" :name="item.name" :key="key"></el-tab-pane>
   
    
  </el-tabs>
  <div id="main" style="width: 600px;height:400px;"></div></el-aside>
  <el-main>Main</el-main>
</el-container>



    </div>
</template>

<script>
var echarts = require("echarts");
export default {
    
    data(){
        return{
            activeName: '0',
            text:'',
            value:[],
            tableData:[
                {
                    title:'223班第一次月考成绩',
                    name:'0'
                },{
                    title:'224班第一次月考生物成绩汇总',
                    name:'1'
                },
                {
                    title:'225班第一次月考生物成绩汇总',
                    name:'2'
                }
            ],
            key:'',
        }
    },
    methods:{
        handleClick(data) {
           if(data.$options.propsData.name == 0){
                      this.text = this.tableData[0].title;
           }
      }
    },
    
    mounted(){
         var myChart = document.getElementById("main");

      var myChart01 = echarts.init(myChart);

      // console.log(myChart01);
      //  console.log(myChart01.id);

      // 指定图表的配置项和数据
      var option = {
    title : {
        text: this.text,
        
        x:'center'
    },
    tooltip : {
        // trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['及格人数','不及格人数','优秀人数']
    },
    series : [
        {
            name: '人数分布',
            type: 'pie',
            // radius : '55%',
            // center: ['50%', '60%'],
            data:[
                {value:335, name:'及格人数'},
                {value:310, name:'不及格人数'},
                {value:234, name:'优秀人数'},
                
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

      //使用刚指定的配置项和数据显示图表。
      myChart01.setOption(option);

         
    }
}
</script>

<style lang="scss" scoped>
.el-aside {
      z-index: 999;
      min-width: 600px;
      max-width: 600px;
      height: calc(100vh - 135px);
      background-color: #D3DCE6;
      color: #333;
    //   @include tran-horizontal(0, 0.4s);
    //   @media screen and (max-width: $smallSize) {
    //     position: absolute;
    //     left: -200px;
    //   };
    //   &.open {
    //     @include tran-horizontal(100%, 0.4s);
    //   }
    }
    .el-main {
      background-color: rgba(155, 155, 155, 0.1);
      color: #333;
      text-align: center;
     
      
    }
</style>


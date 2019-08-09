<template>
    <div class="selectfail">
        
        
            

      <el-tabs v-model="activeName"   @tab-click="handleClick" >
    <el-tab-pane  v-for="(item,key) in tableData" :label="item.title" :name="item.name" :key="key"></el-tab-pane>
   
    
  </el-tabs>
  <div id="main" style="width: 600px;height:350px;left:30%"></div></el-aside>
  

  <h3 v-if="isTrue">点击表头查看具体内容</h3>


 <!-- <el-button @click="resetDateFilter">清除日期过滤器</el-button>
  <el-button @click="clearFilter">清除所有过滤器</el-button> -->
  <el-table
    ref="filterTable"
    :data="tableDataMain"
    style="width: 100%"
    v-if="isFalse">
    <el-table-column
      prop="name"
      label="姓名"
      
      width="180"
      column-key="date"
      
    >
    </el-table-column>
    <el-table-column
      prop="chinese"
      label="语文"
       sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="math"
      label="数学"
      sortable
      >
    </el-table-column>
    <el-table-column
      prop="english"
      label="外语"
      sortable
      >
    </el-table-column>
    <el-table-column
      prop="biology"
      label="生物"
      sortable
      >
    </el-table-column>
    <el-table-column
      prop="phtsics"
      label="物理"
      sortable
      >
    </el-table-column>
    <el-table-column
      prop="geography"
      label="地理"
      sortable
      >
    </el-table-column>
    <el-table-column
      prop="tag"
      label="标签"
      width="100"
      :filters="[{ text: '及格', value: '及格' }, { text: '不及格', value: '不及格' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.tag === '及格' ? 'primary' : 'success'"
          disable-transitions>{{scope.row.tag}}</el-tag>
      </template>
    </el-table-column>
  </el-table>

    </div>
</template>

<script>
var echarts = require("echarts");
export default {
    
    data(){
        return{
            activeName: '0',
            lastName:'0',
            text:'',
            echartsvalue:[],
            isTrue:true,
            isFalse:false,
            value:[
                
                   [{value:10, name:'及格人数'},
                   {value:45, name:'不及格人数'} ,
                    {value:5, name:'优秀人数'},],
                    [
                    {value:35, name:'及格人数'},
                   {value:30, name:'不及格人数'} ,
                    {value:24, name:'优秀人数'},
                    ],
                    [
                    {value:55, name:'及格人数'},
                   {value:20, name:'不及格人数'} ,
                    {value:14, name:'优秀人数'},
                    ],

                   
               
                // {
                //     value:35, name:'及格人数',
                //     value:10, name:'不及格人数',
                //     value:34, name:'优秀人数'
                // },{
                //     value:24, name:'及格人数',
                //     value:30, name:'不及格人数',
                //     value:15, name:'优秀人数'
                // }
            ],
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

            //右边主体的内容
            
            key:'',


            tableDataMain: [{
          name: '张三',
          chinese: '56',
          math: '44',
          english:'86',
          biology:'67',
          phtsics:'89',
          geography:'92',
          tag: '不及格'
        }, {
          name: '李四',
          chinese: '96',
          math: '24',
          english:'76',
          biology:'97',
          phtsics:'59',
          geography:'62',
          tag: '不及格'
        },{
          name: '王五',
          chinese: '96',
          math: '94',
          english:'86',
          biology:'77',
          phtsics:'79',
          geography:'92',
          tag: '及格'
        },{
          name: '赵六',
          chinese: '66',
          math: '45',
          english:'76',
          biology:'97',
          phtsics:'82',
          geography:'52',
          tag: '不及格'
        },]
           
        }
    },
    methods:{
        handleClick(data) {
        //    if(data.$options.propsData.name == 0){
        //               this.text = this.tableData[0].title;
        //    }
        this.isTrue = false;
        this.isFalse = true;
        this.text=this.tableData[data.$options.propsData.name].title; 
        this.echartsvalue=this.value[data.$options.propsData.name];
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
            data:this.echartsvalue,
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
    ,
    printkey(data){
      console.log(data)
    },


 //主体内容方法
    resetDateFilter() {
        this.$refs.filterTable.clearFilter('date');
      },
      clearFilter() {
        this.$refs.filterTable.clearFilter();
      },
      formatter(row, column) {
        return row.address;
      },
      filterTag(value, row) {
        return row.tag === value;
      },
      filterHandler(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      }
          
      
    },
    
   

    
}
</script>

<style lang="scss" scoped>

.selectfail{
    h3{
        position: absolute;
    top: 40%;
    left: 50%;
    color: #00000036;
    }
}
</style>


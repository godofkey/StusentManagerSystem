<template>
  <el-table
    :data="tableData.filter(data => !search || data.number.toLowerCase().includes(search.toLowerCase()) || data.name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%">
    <el-table-column
      label="学号"
      prop="number">
    </el-table-column>
    <el-table-column
      label="姓名"
      prop="name">
    </el-table-column>
    <el-table-column
      label="班级"
      prop="class">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>

      <div class="block">
    <span class="demonstration">显示总数</span>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="currentPage1"
      :page-size="100"
      layout="total, prev, pager, next"
      :total="1000">
    </el-pagination>
  </div>
    </el-table-column>
  </el-table>

  
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          number: '15446104',
          name: '李小虎',
          class: '上海市普陀区金沙江路 1518 弄'
        }, {
          number: '15446105',
          name: '张小虎',
          class: '上海市普陀区金沙江路 1517 弄'
        }, {
          number: '15446105',
          name: '王大小虎',
          class: '上海市普陀区金沙江路 1519 弄'
        }, {
          number: '15446105',
          name: '刘小虎',
          class: '上海市普陀区金沙江路 1516 弄'
        },
        {
          number: '15446105',
          name: '李小虎',
          class: '上海市普陀区金沙江路 1518 弄'
        }, {
          number: '15446105',
          name: '张小虎',
          class: '上海市普陀区金沙江路 1517 弄'
        }, {
          number: '15446105',
          name: '王大小虎',
          class: '上海市普陀区金沙江路 1519 弄'
        }, {
          number: '15446105',
          name: '刘小虎',
          class: '上海市普陀区金沙江路 1516 弄'
        },
        {
          number: '15446105',
          name: '李小虎',
          class: '上海市普陀区金沙江路 1518 弄'
        }, {
          number: '15446105',
          name: '张小虎',
          class: '上海市普陀区金沙江路 1517 弄'
        }, {
          number: '2016-05-01',
          name: '王大小虎',
          class: '上海市普陀区金沙江路 1519 弄'
        }, {
          number: '2016-05-03',
          name: '刘小虎',
          class: '上海市普陀区金沙江路 1516 弄'
        },
        ],
        search: ''
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
  }
</script>
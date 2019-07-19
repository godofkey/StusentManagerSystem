<template>
    <div>
        <p class="grade_manage">223班第一次月考成绩</p>
        <el-table class="tb-edit" highlight-current-row :data="tableData" style="width: 100%;line-height:100px;">

            <template v-for="col in cols">
                <el-table-column  :prop="col.prop" :label="col.label"></el-table-column>
                <!-- <el-table-column v-if="col.type==='sort'" :prop="col.prop" sortable :label="col.label">
                    <template scope="scope">
                        <el-tag type="primary">{{ scope.row.type }}</el-tag>
                    </template>
                </el-table-column> -->
            </template>
        </el-table>
        <!-- <br>数据:{{tableData}} -->
    </div>
</template>
<script>
export default {
    data() {
        return {
            cols: [
                { label: "姓名/学号", prop: "name", type: "normal" },
                { label: "语文", prop: "type", type: "sort" },
                { label: "数学", prop: "coordinate", type: "normal" },
                { label: "外语", prop: "english", type: "normal" },
                { label: "生物", prop: "math", type: "normal" },
                { label: "物理", prop: "poligy", type: "normal" },
                { label: "化学", prop: "huaxue", type: "normal" }

            ],
            tableData: [
                {
                   
                    name: " 张三",
                    type: "88",
                    status: "正常",
                    coordinate: "89",
                    english:'78',
                    math:'82',
                    poligy:'83',
                    huaxue:'87'

  
                },
                 {
            
                    name: "李四",
                    type: "99",
                    status: "正常",
                    coordinate: "29",
                    english:'56',
                    math:'86',
                    poligy:'93',
                    huaxue:'89'

  
                }
            ]
        };
    },
    methods: {
        handleCurrentChange(row, event, column) {
            console.log(row, event, column, event.currentTarget);
        },
        handleEdit(index, row) {
            console.log(index, row);
        },
        handleDelete(index, row) {
            console.log(index, row);
        }
    }
};
</script>

<style >
.td-edit{
    line-height: 100px
}
.tb-edit .el-input {
    display: none;
}

.tb-edit .current-row .el-input {
    display: block;
}

.tb-edit .current-row .el-input + span {
    display: none;
}

.grade_manage{
  line-height: 10px;
  font-size: 20px;
}
</style>
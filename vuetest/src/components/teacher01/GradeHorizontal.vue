<template>
    <div>
        <el-table class="tb-edit" highlight-current-row :data="tableData" style="width: 100%;line-height:100px;">

            <template v-for="(col,index) in cols">
                <el-table-column  :prop="col.prop" :label="col.label" :key="index" ></el-table-column>
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
                { label: "联系电话", prop: "phone", type: "sort" },
                { label: "家庭住址", prop: "adress", type: "normal" },
                // { label: "外语", prop: "english", type: "normal" },
                // { label: "生物", prop: "math", type: "normal" },
                // { label: "物理", prop: "poligy", type: "normal" },
                // { label: "化学", prop: "huaxue", type: "normal" }

            ],
            key:'',
            tableData: [
                {
                   
                    name: " 张三",
                    phone: "15584568512",
                    adress: "舞阳街道135号",
                    coordinate: "89",
                    english:'78',
                    math:'82',
                    poligy:'83',
                    huaxue:'87'

  
                },
                 {
            
                    name: "李四",
                    phone: "13584685958",
                    adress: "中兴村三组88号",
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
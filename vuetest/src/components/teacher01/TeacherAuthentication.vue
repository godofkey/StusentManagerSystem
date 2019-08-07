<template>
  <div class="teacherauthentication">
    <el-button type="text" @click="dialogFormVisible = true">绑定班级及科目</el-button>

    <el-dialog title :visible.sync="dialogFormVisible" :modal-append-to-body="false">
      <el-form :model="form">
        <el-form-item label="绑定班级" :label-width="formLabelWidth">
          <el-input v-model="form.class" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="绑定科目" :label-width="formLabelWidth">
          <el-input v-model="form.subject" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="aa()">确 定</el-button>
      </div>
    </el-dialog>

    <el-card shadow="always" v-for="(item,key) in formdata" :key="key">
      <el-row :gutter="20">
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-tag type="success">班级</el-tag>
            {{item.class}}
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <el-tag>科目</el-tag>
            {{item.subject}}
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <el-tooltip content="删除" placement="top">
              <el-button type="danger" icon="el-icon-delete" circle></el-button>
            </el-tooltip>
          </div>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>



<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      form: {
        class: "",
        subject: ""
      },
      formdata: [],
      key: "",
      formLabelWidth: "120px"
    };
  },
  methods: {
    aa() {
      this.dialogFormVisible = false;
      this.formdata.push({
        class: this.form.class,
        subject: this.form.subject
      });
    }
  }
};
</script>

<style >
.teacherauthentication {
  text-align: left;
}
.el-tag {
  margin-right: 20px;
}
.el-card {
  margin: 10px;
  font-size: 20px;
}
</style>

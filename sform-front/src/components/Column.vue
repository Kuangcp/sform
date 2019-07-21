<template>
  <div class="column">
    <div class="column-item">
      <el-form-item :label='"列 " + index + " 名称"'>
        <el-input v-model="column.name"></el-input>
      </el-form-item>
      <el-form-item label="类型">
        <el-select
          v-model="column.type"
          placeholder="请选择类型"
        >
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.type"
          >
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="长度">
        <el-input v-model.number="column.length"></el-input>
      </el-form-item>
      <el-checkbox
        v-model="column.primary"
        border
      >主键</el-checkbox>
      <el-checkbox
        v-model="column.autoIncrement"
        border
      >自动递增</el-checkbox>
      <el-checkbox
        v-model="column.notnull"
        border
      >不能为空</el-checkbox>
      <el-checkbox
        v-model="column.unsigned"
        border
      >无符号</el-checkbox>
      <el-form-item label="默认值">
        <el-input v-model="column.defaults"></el-input>
      </el-form-item>
      <el-form-item label="注释">
        <el-input v-model="column.comment"></el-input>
      </el-form-item>
      <el-button
        type="danger"
        @click="deleted(index)"
      >删除</el-button>
    </div>
  </div>
</template>

<script>
export default {
  props: ["index", "column"],
  data() {
    return {
      options: [
        {
          label: "数字类型(int)",
          type: "int"
        },
        {
          label: "大数字类型(bigint)",
          type: "bigint"
        },
        {
          label: "字符类型(varchar)",
          type: "varchar"
        }
      ]
    };
  },
  created() {},
  mounted() {},
  methods: {
    deleted(index) {
      this.$emit("deleteColumn", index);
    }
  }
};
</script>

<style scoped>
.column-item {
  margin-top: 5px;
  border: dashed 1px black;
  padding: 30px;
}
.el-select {
  width: 100px;
}
.el-input {
  width: 100px;
}
</style>


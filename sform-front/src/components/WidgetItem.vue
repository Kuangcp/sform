<template>
  <el-form-item :label="widget.label">
    <template v-if="widget.type == 'input'">
      <el-input :disabled="widget.disable" v-model="values[widget.name]">{{widget.defaultValue}}</el-input>
    </template>
    <template v-if="widget.type == 'button'">
      <el-button @click="callback" :disabled="widget.disable">{{widget.name}}</el-button>
    </template>
    <template v-if="widget.type == 'select'">
      <el-select v-model="values[widget.name]" :placeholder="widget.placeholder">
        <el-option
          v-for="item in ((widget.options.remote==true) ? remoteSelectOptions : widget.options.option)"
          :label="item.label"
          :value="item.value"
          :key="item.value"
        ></el-option>
      </el-select>
    </template>
    <template v-if="widget.type == 'radio-gruop'">
      <el-radio-group v-model="values[widget.name]">
        <el-radio
          v-for="item in (widget.options.remote == true) ? remoteRadioOptions : widget.options.option"
          :key="item.value"
          :label="item.label"
        >{{item.label}}</el-radio>
      </el-radio-group>
    </template>
  </el-form-item>
</template>

<script>
export default {
  props: ["widget", "values"],
  data() {
    return {
      remoteSelectOptions: [],
      remoteRadioOptions: []
    };
  },
  created() {
    this.getData();
  },
  methods: {
    callback() {
      eval(this.widget.options.callback);
    },
    getData() {
      if (this.widget.type == "select") {
        this.axios.get(this.widget.options.remoteUrl).then(res => {
          this.remoteSelectOptions = res.data;
          this.widget.options.remoteOption = res.data;
        });
      }

      if (this.widget.type == "radio-gruop") {
        this.axios.get(this.widget.options.remoteUrl).then(res => {
          this.remoteRadioOptions = res.data;
          this.widget.options.remoteOption = res.data;
        });
      }
    }
  }
};
</script>

<style scoped>
</style>

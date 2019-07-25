<template>
  <el-form-item>
    <template v-if="widget.type == 'input'">
      <el-input
        :disabled="widget.disable"
        v-model="widget.defaultValue"
      >{{widget.name}}</el-input>
    </template>
    <template v-if="widget.type == 'button'">
      <el-button @click="hander" :disabled="widget.disable">{{widget.defaultValue}}</el-button>
    </template>
    <template v-if="widget.type == 'select'">
      <el-select
        v-model="widget.defaultValue"
        :placeholder="widget.placeholder"
      >
        <el-option
          v-for="i in (widget.options.remote==true) ? widget.options.remoteOption : widget.options.option"
          :key='i.value'
          :value='i.value'
          :label='i.label'
        >
        </el-option>
        <!-- <el-option v-for="i in [{value: '1', label: '123123'}]" value="value">
        </el-option> -->
        <!-- <el-option
            v-for="(i,index) in (item.options.remote == true ? [{label: "远程数据",value: "1"}]:i.options.option)"
            :key="index"
            :label="i.options.label"
            :value="i.options.value"
          >
          </el-option> -->
      </el-select>
    </template>
  </el-form-item>
</template>

<script>
export default {
  props: ["widget"],
  data() {
    return {
        
    };
  },
  created() {
      console.log('asdfdsf')
      this.axios.get(this.widget.options.remoteUrl).then(res=>{
          this.widget.options.remoteOption = res.data
      })
  },
  methods: {
      hander() {
          eval(this.widget.options.callback)
      }
  }
};
</script>

<style scoped>
</style>

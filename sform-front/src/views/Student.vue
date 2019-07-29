<template>
  <div>
    <h1>学生登记</h1>
    <generate :json="json" :values="values" ref="forms"></generate>
    <el-button @click="getjson">点击获取jsone
    </el-button>
  </div>
</template>

<script>
import generate from "@/components/Generate";
export default {
  components: { generate },
  data() {
    return {
      json:{},
      values: {}
    };
  },
  created() {
    this.getForm()
  },
  methods: {
    getForm() {
      this.axios.get('http://localhost:10010/getFormByName/' + 'studentpost').then(res=>{
        this.json = res.data
      })
    },
    getjson() {
      console.log(this.values)
    }
  }
};
</script>

<style scoped>
</style>

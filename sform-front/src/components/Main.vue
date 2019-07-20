<template>
  <div class="hello">
    <el-form
      :inline="true"
      label-width="100px"
    >
      <el-form-item label="表名">
        <el-input v-model="tableName"></el-input>
      </el-form-item>
      <el-form-item label="列1名">
        <el-input v-model="name"></el-input>
      </el-form-item>
      <el-form-item label="类型">
        <el-input v-model="type"></el-input>
      </el-form-item>
      <el-form-item label="长度">
        <el-input v-model.number="length"></el-input>
      </el-form-item>
      <el-button @click="createTableHandler">创建表</el-button>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableName: "",
      name: "",
      type: "",
      length: 0
    };
  },
  methods: {
    get() {
      var s = {
        tableName: this.tableName,
        columns: [
          {
            name: this.name,
            type: this.type,
            length: this.length
          }
        ]
      };
      this.axios.post("http://localhost:8080/createTable", s).then(res => {
        // console.log(res)
      }).catch(error=>{
        // console.log(error)
      });
    },
    createTableHandler() {
      this.get();
    }
  },
  created() {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.hello {
  width: 500px;
  margin: 0 auto;
}
</style>

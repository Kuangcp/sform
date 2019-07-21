<template>
  <div class="hello">
    <router-link to="/chart" replace="true">动态SQL图表</router-link>
    <h1>创建数据源</h1>
    <el-form :inline="true">
      <el-form-item label="表名">
        <el-input v-model="tableName"></el-input>
      </el-form-item>
      <template v-for="(item,index) in columns">
        <column
          :index="index"
          @deleteColumn="deleteColumn"
          :column="item"
        />
      </template>
      <el-button
        type="success"
        @click="addColumn"
      >添加表单</el-button>
      <el-button
        style="margin-top: 30px"
        @click="createTableHandler"
        type="primary"
        :loading="postbuttonstatus"
      >创建表</el-button>
    </el-form>
  </div>
</template>

<script>
import column from "@/components/Column";
export default {
  components: {
    column
  },
  data() {
    return {
      postbuttonstatus: false,
      columnSize: 3,
      columns: [
        {
          name: "",
          type: "",
          length: "",
          comment: "",
          isPrimary: ""
        }
      ],
      tableName: "",
     
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
  methods: {
    
    deleteColumn(index) {
      if (this.columns.length > 1) {
        this.columns.splice(index, 1);
      } else {
        this.$message.error("至少有一个字段哦！");
      }
    },

    addColumn() {
      var column = {};
      this.columns.push(column);
      console.log(this.columns);
    },
    dataHandler(data) {
      console.log(data);
    },
    createTableHandler() {
      var s = {
        tableName: this.tableName,
        columns: this.columns
      };
      this.postbuttonstatus = true;
      this.axios
        .post("http://localhost:8080/createTable", s)
        .then(res => {})
        .catch(error => {});
      this.postbuttonstatus = false;
    }
  },
  created() {},
  mounted() {
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
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
a :visited {
  color: #42b983;
}
a :link {
  color: #42b983;

}
.hello {
  /* width: 500px; */
  /* margin: 0 auto; */
}
</style>

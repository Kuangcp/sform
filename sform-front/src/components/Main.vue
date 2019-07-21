<template>
  <div class="hello">
    <div
      id="myChart"
      :style="{width: '300px', height: '300px'}"
    ></div>

    <el-input v-model="sql"></el-input>
    <el-button
      type="primary"
      @click="loadChartData"
    >点击获取所有数据</el-button>
    <h1>创建表</h1>
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
      sql: "",
      orgOptions: {},
      postbuttonstatus: false,
      columnSize: 3,
      columns: [
        // {
        //   name: "",
        //   type: "",
        //   length: "",
        //   comment: "",
        //   isPrimary: ""
        // }
      ],
      tableName: "",
      xList: [],
      yList: [],
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
    loadChartData() {
      this.axios
        .get("http://localhost:8080/customSql?sql=" + this.sql)
        .then(res => {
          console.log(res.data);
          for (var i = 0; i < res.data.length; i++) {
            console.log(res.data[i]);
            this.xList.push(res.data[i].x);
            this.yList.push(res.data[i].y);
          }
        })
        .catch(error => {});
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表
      console.log(this.xList);
      myChart.setOption({
        title: { text: "动态SQL加载图表" },
        tooltip: {},
        xAxis: {
          data: this.xList
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            data: this.yList
          }
        ]
      });
    },
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
    this.loadChartData
  }
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
  /* width: 500px; */
  /* margin: 0 auto; */
}
</style>

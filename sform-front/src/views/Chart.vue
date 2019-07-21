<template>
  <div class="view">
      <router-link to="/" replace="true">配置数据源</router-link>
    <div
      id="myChart"
      :style="{width: '300px', height: '300px'}"
    ></div>
    <el-input v-model="sql"></el-input>
    <el-button
      type="primary"
      @click="loadChartData"
    >点击获取所有数据</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      sql: "",
      xList: [],
      yList: []
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
    }
  },
  mounted() {
    this.loadChartData();
  }
};
</script>

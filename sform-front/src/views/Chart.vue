<template>
  <div class="view">
    <router-link
      to="/"
      replace
    >配置数据源</router-link>
    <div
      id="myChart"
      :style="{width: '300px', height: '300px'}"
    ></div>
    <el-input v-model="sql"></el-input>
    <el-button
      type="primary"
      @click="loadChartData"
    >点击获取所有数据</el-button>
    <draggable
      :list="myArray"
      :disabled="!enabled"
      class="list-group"
      :options="{sort:false}"
      ghost-class="ghost"
      @start="dragging = true"
      @end="dragging = false"
      :group="{name:'pop', pull:'clone', put: false}"
      style="margin-top: 50px"
    >
      <transition-group>
        <div
          v-for="element in myArray"
          :key="element.id"
        >
          {{element.name}}
        </div>
      </transition-group>
    </draggable>

    <draggable
      style="background: green;margin-top: 30px"
      group="pop"
      :list="list2"
    >
      <div v-for="item in list2">
        {{item.name}}
      </div>
    </draggable>
  </div>
</template>

<script>

import axios from 'axios'

import draggable from "vuedraggable";
export default {
  data() {
    return {
      enabled: true,
      sql: "select month(createtime) as x, names as y from tabs",
      xList: [],
      yList: [],
      myArray: [{ name: "jhon", id: "1" }, { name: "tom", id: "2" }],
      list2: []
    };
  },
  components: { draggable },
  methods: {
    loadChartData() {
      this.axios
        .get("http://localhost:8080/customSql?sql=" + this.sql)
        .then(res => {
          if (res.data.length > 0) {
            this.xList = [];
            this.yList = [];
          }
          console.log(res.data);
          for (var i = 0; i < res.data.length; i++) {
            console.log(res.data[i]);
            this.xList.push(res.data[i].x);
            this.yList.push(res.data[i].y);
          }
          this.renderChart();
        })
        .catch(error => {});
    },
    renderChart() {
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

<style scoped>
.buttons {
  margin-top: 35px;
}
.ghost {
  opacity: 0.5;
  border-top: 2px black solid;
  background: #c8ebfb;
}
</style>

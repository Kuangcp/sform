<template>
  <div>
    <el-form :model="values">
      <template v-for="(item,index) in json.list">
        <widgetitem
          :widget="item"
          :key="index"
          :values="values"
          :parent="parent"
        />
      </template>
    </el-form>
    <!-- <el-button
      @click="getJson"
      type="primary"
      style="margin-top: 30px"
    >获取设计表单JSON</el-button> -->
  </div>
</template>

<script>
import widgetitem from "@/components/WidgetItem";
export default {
  components: { widgetitem },
  props: ["json", "values"],
  data() {
    return {
        // values: {},
        parent: this
    };
  },
  methods: {
      getJson() {
      this.$alert(JSON.stringify(this.json), "获取设计表单JSON", {
        confirmButtonText: "确定",
        callback: action => {
          // this.values = {};
        }
      });
    },
  },
  mounted() {
  }
};
</script>


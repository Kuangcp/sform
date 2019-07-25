<template>
  <div>
    <router-link to="/">首页</router-link>
    <el-form>
      <template v-for="item in json.list">
        <widgetitem :widget="item" />
      </template>
    </el-form>
    <el-button @click="getJson">获取json</el-button>
  </div>
</template>

<script>
import widgetitem from "@/components/WidgetItem";
export default {
  components: { widgetitem },
  data() {
    return {
      json: {
        list: [
          {
            type: "select",
            name: "sex",
            defaultValue: "",
            disable: true,
            placeholder: "请选择数据哦",
            options: {
              remote: true,
              remoteUrl: "http://localhost:8080/getAllOptions",
              label: "label",
              value: "value",
              remoteOption: [],
              option: [
                {
                  label: "选项二",
                  value: "2"
                },
                {
                  label: "选项一",
                  value: "1"
                }
              ]
            }
          },
          {
            type: "input",
            name: "age",
            defaultValue: "",
            disable: false,
            placeholder: "",
            options: {}
          },
          {
            type: "button",
            name: "按钮",
            defaultValue: "就是一个按钮",
            disable: false,
            placeholder: "",
            post: false,
            options: {
                callback: 'this.axios.get("http://localhost:8080/getAllOptions").then(res=>{console.log(res.data)})'
            }
          }
        ],
        config: {
          labelWidth: 100,
          labelPosition: "right",
          size: "small",
          customClass: ""
        }
      },
      values: {}
    };
  },
  methods: {
    handler() {
      console.log(this.list);
    },
    getJson() {
        var that = this;
        console.log(this.json.list)
        for(var i =0;i<this.json.list.length;i++) {
            var lst = this.json.list[i]
            var obj = {}
            if(lst.post == false) {
                continue;
            }
            this.values[lst.name] = lst.defaultValue
        }
        
        console.log(this.values)
        this.$alert(this.values, '提交的json数据', {
          confirmButtonText: '确定',
          callback: action => {
            this.values = {};
          }
        });
    }
  },
  created() {},
  mounted() {
  }
};
</script>

<style scoped>
</style>

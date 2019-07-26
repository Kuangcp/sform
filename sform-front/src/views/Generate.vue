<template>
  <div>
    <router-link to="/">首页</router-link>
    <el-form :model="values">
      <template v-for="(item,index) in json.list">
        <widgetitem :widget="item" :key="index" :values="values" />
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
            type: 'radio-gruop',
            name: 'sex',
            label: '性别选择',
            options: {
              remote: true,
              remoteUrl: 'http://localhost:8080/getAllOptions',
              option: [
                {
                  label: "选项1",
                  value: "1"
                },
              ],
              remoteOption: []
            }
          },
          {
            type: "select",
            name: "category",
            defaultValue: "",
            disable: true,
            label: '性别',
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
            label: '年龄',
            defaultValue: "",
            disable: false,
            placeholder: "",
            options: {}
          },
          {
            type: "button",
            name: "提交按钮",
            defaultValue: "asdd",
            disable: false,
            placeholder: "",
            post: false,
            options: {
              //客户端必须使用this.values来获取表单数据
              callback: "this.axios.post('http://localhost:8888/posta', this.values).then(res=>{console.log(res)})"
            }
          }
        ],
        config: {
          labelWidth: 100,
          labelPosition: "right",
          size: "small",
          customClass: "",
          addUrl: "",
          editUrl: ""
        }
      },
      values: {}
    };
  },
  methods: {
    
    getJson() {
      this.$alert(this.values, "提交的json数据", {
        confirmButtonText: "确定",
        callback: action => {
          this.values = {};
        }
      });
      console.log(this.values);
    }
  },
  created() {
    //保存表单配置json的时候需要将json格式化
    // this.axios
    //   .get("http://localhost:8080/getFormByName/" + "student1")
    //   .then(res => {
    //     const obj = {};
    //     obj.config = res.data.config;
    //     obj.list = res.data.list;
    //     this.json = obj;
    //   });
  }
};
</script>

<style scoped>
</style>

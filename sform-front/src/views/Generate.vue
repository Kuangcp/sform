<template>
  <div>
    <router-link to="/">首页</router-link>
    <div>
      样例表单
      <div v-for="(item,index) in forms" :key="index" @click="getFormByName(item)">{{item}}</div>
    </div>

    <el-form :model="values">
      <template v-for="(item,index) in json.list">
        <widgetitem :widget="item" :key="index" :values="values" :parent="parent" />
      </template>
    </el-form>
    <el-button @click="getJson" type="primary" style="margin-top: 30px">获取设计表单JSON</el-button>
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
            type: "radio-gruop",
            name: "sex",
            label: "性别选择",
            created: 'console.log(this.widget)',
            options: {
              remote: true,
              remoteUrl: "http://localhost:8080/getAllOptions",
              option: [
                {
                  label: "选项1",
                  value: "1"
                }
              ],
              remoteOption: []
            }
          },
          {
            type: "select",
            name: "category",
            defaultValue: "",
            disable: true,
            label: "性别",
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
            label: "年龄",
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
              callback:
                "this.axios.post('http://localhost:8888/posta', this.values).then(res=>{console.log(res)})"
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
      values: {},
      forms: [],
      parent: this
    };
  },
  methods: {
    getAllForm() {
      this.axios("http://localhost:8080/getAllForm").then(res => {
        this.forms = res.data;
      });
    },
    getJson() {
      this.$alert(JSON.stringify(this.json), "获取设计表单JSON", {
        confirmButtonText: "确定",
        callback: action => {
          // this.values = {};
        }
      });
      console.log(this.values);
    },
    getFormByName(name) {
      this.axios
        .get("http://localhost:8080/getFormByName/" + name)
        .then(res => {
          const obj = {};
          obj.config = res.data.config;
          obj.list = res.data.list;
          this.json = obj;
        });
    }
  },
  created() {
    // this.getAllForm();
    //保存表单配置json的时候需要将json格式化
  }
};
</script>

<style scoped>
</style>

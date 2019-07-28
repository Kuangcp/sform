<template>
  <div>
    <generate :json="json" :values="values"></generate>
  </div>
</template>

<script>
import generate from "@/components/Generate";
export default {
  components: { generate },
  data() {
    return {
      json: {
        list: [
          {
            type: "radio-gruop",
            name: "sex",
            label: "性别选择",
            created: "console.log(this.widget)",
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
                "console.log(this.parent.json.list);console.log(this.values);if(this.values.age == 'asd'){console.log(this.parent.json.list[0])}"
                // this.axios.post('http://localhost:8888/posta', this.values).then(res=>{console.log(res)})
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
      values: {age: "123"},
    //   forms: [],
    //   parent: this
    };
  }
};
</script>

<style scoped>
</style>

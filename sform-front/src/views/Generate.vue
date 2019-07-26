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
            name: "提交按钮",
            defaultValue: "asdd",
            disable: false,
            placeholder: "",
            post: false,
            options: {
              //客户端必须使用this.values来获取表单数据
              callback: 'console.log(this.values)'
            }
          }
        ],
        config: {
          labelWidth: 100,
          labelPosition: "right",
          size: "small",
          customClass: "",
          addUrl: '',
          editUrl: '',
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
        // var that = this;
        // console.log(this.json.list)
        // for(var i =0;i<this.json.list.length;i++) {
        //     var lst = this.json.list[i]
        //     var obj = {}
        //     if(lst.post == false) {
        //         continue;
        //     }
        //     this.values[lst.name] = lst.defaultValue
        // }
        
        // console.log(this.values)
        // this.$alert(this.values, '提交的json数据', {
        //   confirmButtonText: '确定',
        //   callback: action => {
        //     this.values = {};
        //   }
        // });
        console.log(this.values)
    }
  },
  created() {
  //保存表单配置json的时候需要将json格式化
  // console.log(JSON.stringify(this.json))
  //   const str = '{"name":"123"}'
  //   console.log(JSON.parse(str))
  //   this.axios.get('http://localhost:8080/getFormByName/' + 'student1').then(res=>{
  //     const obj = {}
  //     obj.config = res.data.config
  //     obj.list = res.data.list
  //     this.json = obj;
  //   })
  },
  mounted() {
  },
  computed: {
    // newList() {
    //   return this.json
    // }
  },
  watch: {
    values: {
      handler(val, oldval) {
        this.values = val;
      },deep: true
    }
    // json: {
    //   handler(val, oldval) {
    //     var that = this;
    //     for(var i =0;i<this.json.list.length;i++) {
    //         var lst = this.json.list[i]
    //         var obj = {}
    //         if(lst.post == false) {
    //             continue;
    //         }
    //         this.values[lst.name] = lst.defaultValue
    //     }
    //   },
    //   deep: true
    // }
  }
};
</script>

<style scoped>
</style>

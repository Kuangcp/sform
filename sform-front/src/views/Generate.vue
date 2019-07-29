<template>
  <div>
    <router-link to="/">首页</router-link>
    <div>
      表单列表
      <div v-for="(item,index) in forms" :key="index" >{{item}}<span @click="getFormByName(item)">编辑</span></div>
    </div>

    <el-input type="textarea" :rows="10" placeholder="请输入内容" v-model="jsons"></el-input>

    <el-form :model="values" ref="form">
      <draggable :list="json.list" :options="{swapThreshold:0.5,animation: 100}">
        <template v-for="(item,index) in json.list">
          <widgetitem class="widgetitem" @click.native="currentForm = index" :class="currentForm == index ? 'active':'' " :widget="item" :key="index" :values="values" :parent="parent" />
        </template>
      </draggable>
    </el-form>
    <el-button @click="getJson" type="primary" style="margin-top: 30px">获取设计表单JSON</el-button>
    <el-button @click="updateJson" type="primary" style="margin-top: 30px">更新表单</el-button>

    <el-row :gutter="20">
      <el-col :span="5">
        <div class="content"></div>
      </el-col>
      <el-col :span="3">
        <div class="content"></div>
      </el-col>
      <el-col :span="10">
        <el-row class="content">
          <el-col :span="2">
            <div class="subcontent">sdfdf</div>
          </el-col>
        </el-row>
      </el-col>
    </el-row>

    <draggable :list="layout">
      <template v-for="(it, index) in layout">
        <div>{{it.name}}</div>
      </template>
    </draggable>
  </div>
</template>

<script>
import widgetitem from "@/components/WidgetItem";
import draggable from "vuedraggable";
export default {
  components: { widgetitem, draggable },
  data() {
    return {
      currentForm: null,
      layout: [
        {
          name: "asdf"
        },
        {
          name: "aaaaaaa"
        }
      ],
      json: {
        list: [
          {
            type: "radio-gruop",
            name: "sex",
            label: "性别选择",
            created: 'console.log(this.widget)',
            options: {
              remote: true,
              remoteUrl: "http://localhost:10010/getAllOptions",
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
              remoteUrl: "http://localhost:10010/getAllOptions",
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
    updateJson() {
      if (this.currentForm) {
        this.axios
          .post(
            "http://localhost:10010/updateFormByName",
            {json: JSON.stringify(this.json), formname: this.currentForm}
          )
          .then(res => {
            this.$alert(JSON.stringify(res.data), "操作结果", {
              confirmButtonText: "确定",
              callback: action => {
                // this.values = {};
              }
            });
          });
      }
    },
    getAllForm() {
      this.axios("http://localhost:10010/getAllForm").then(res => {
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
        .get("http://localhost:10010/getFormByName/" + name)
        .then(res => {
          this.currentForm = name;
          const obj = {};
          obj.config = res.data.config;
          obj.list = res.data.list;
          this.json = obj;
        });
    }
  },
  created() {
    console.log(JSON.stringify(this.json))
    this.getAllForm();
    //保存表单配置json的时候需要将json格式化
  },
  computed: {
    jsons: {
      get: function() {
        return JSON.stringify(this.json);
      },
      set: function(newVal) {
        this.json = JSON.parse(newVal);
      }
    }
  }
};
</script>

<style scoped>
.content {
  background-color: rgb(44, 143, 121);
  border-radius: 4px;
  min-height: 180px;
}
.subcontent {
  background-color: rgb(117, 143, 44);
  border-radius: 4px;
  min-height: 150px;
}
.active {
  border-left: 5px solid #409eff;background: #b3d8ff;padding: 10px;
}
.widgetitem:hover {
  color: red;
}
</style>

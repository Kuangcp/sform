import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Charts from '@/views/Chart'
import Generate from '@/views/Generate'
import Student from '@/views/Student'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/chart',
      name: 'Charts',
      component: Charts
    },
    {
      path: '/generate',
      name: 'generate',
      component: Generate
    },
    {
      path: '/student',
      name: 'student',
      component: Student
    }
  ]
})

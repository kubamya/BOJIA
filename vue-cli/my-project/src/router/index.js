import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import nav from '@/components/nav.vue'
import main from '@/view/main/main.vue'
import mainPc from '@/view/main/mainPc.vue'
import login from '@/view/login/login.vue'
import loginPc from '@/view/login/loginPc.vue'
import regist from '@/view/login/regist.vue'
import home from '@/view/home/home.vue'
import manu from '@/view/manu/manu.vue'
import auto from '@/view/auto/auto.vue'
import mine from '@/view/mine/mine.vue'
import proManage from '@/view/website/proManage.vue'
import deviceManage from '@/view/website/deviceManage.vue'
import customManage from '@/view/website/customManage.vue'
import userManage from '@/view/website/userManage.vue'
import test from '@/view/website/test.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/test',
      name: 'test',
      component: test
    },
    {
      path: '/nav',
      name: 'nav',
      component: nav
    },
    {
      path: '/loginPc',
      name: 'loginPc',
      component: loginPc
    },
    {
      path: '/regist',
      name: 'regist',
      component: regist
    },
    {
      path: '/mainPc',
      name: 'mainPc',
      component: mainPc,
      children:[
        {
          path: '/proManage',
          name: 'proManage',
          component: proManage
        },
        {
          path: '/deviceManage',
          name: 'deviceManage',
          component: deviceManage
        },
        {
          path: '/customManage',
          name: 'customManage',
          component: customManage
        },
        {
          path: '/userManage',
          name: 'userManage',
          component: userManage
        },
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/main',
      name: 'main',
      component: main,
      children:[
        {
          path: '/home',
          name: 'home',
          component: home
        },
        {
          path: '/manu',
          name: 'manu',
          component: manu
        },
        {
          path: '/auto',
          name: 'auto',
          component: auto
        },
        {
          path: '/mine',
          name: 'mine',
          component: mine
        },
      ]
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})

import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import nav from '@/components/nav.vue'
import main from '@/view/main/main.vue'
import login from '@/view/login/login.vue'
import home from '@/view/home/home.vue'
import manu from '@/view/manu/manu.vue'
import auto from '@/view/auto/auto.vue'
import mine from '@/view/mine/mine.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/nav',
      name: 'nav',
      component: nav
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

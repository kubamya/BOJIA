<template>
  <div id="app">    
    <router-view/>
  </div>
</template>

<script>
import _global from '@/global/global.vue'
export default {
  date(){
    return {
      name: 'App'
    }
  },
  mounted(){
    if('app' == _global.appFlag){
      this.$router.push({path: '/login'});
    }else if('web' == _global.appFlag){
      this.$router.push({path: '/loginPc'});
    }    
  }
  
}
</script>

<style>
*{
  margin:0px;
  padding:0px;
}
html,body{
  width:100%;
  height:100%;
}
#app {
  width:100%;
  height:100%;
}
</style>

<template>
  <div id="app">    
    <router-view/>
  </div>
</template>

<script>
export default {
  date(){
    return {
      name: 'App'
    }
  },
  mounted(){
    // this.$router.push({path: '/login'});
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

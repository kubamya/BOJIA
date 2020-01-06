<template>
    <div class="mainPc-container">
        <div class="mainPc-header">
            <mainPcHeaderCom></mainPcHeaderCom>
        </div>
        <div class="mainPc-left">
            <navPcCom @tz="go"></navPcCom>
        </div>
        <div class="mainPc-content">
            <router-view/>
        </div>
    </div>
</template>
<script>
import mainPcHeader from '@/components/mainHeader.vue';
import navPc from '@/components/navPc.vue';
export default {
    components:{
        mainPcHeaderCom : mainPcHeader,
        navPcCom : navPc
    },
    mounted(){
        this.$router.push({path:'/proManage'});
    },
    methods:{
        go(pathData){
            this.$router.push({path:pathData});
        }
    }
}
</script>

<style scoped>
.mainPc-container{
    width: 100%;
    height: 100%;
    background-color: #cccccc;
    position: relative;
}
.mainPc-header{
    width: 100%;
    height: 50px;
    background-color: #409EFF;
    /* box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); */
}
.mainPc-left{
    width: 150px;
    height: calc(100% - 50px);
    position: absolute;
    bottom: 0;
    left: 0;
}
.mainPc-content{
    width: calc(100% - 150px);
    height: calc(100% - 50px);
    overflow: hidden;
    background: url('../../../static/img/mainBg.jpg');
    background-size: 100%;
    position: absolute;
    bottom: 0;
    left: 150px;
}
</style>

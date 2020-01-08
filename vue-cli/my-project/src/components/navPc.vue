<template>
    <div class="navPc-container">
        <div class="navPc-item" @click="goto(nav.path)" v-for="nav in navData" :key="nav.id">
            <i class="el-icon-user" v-if="nav.label == '客户管理'"></i>
            <i class="el-icon-cpu" v-if="nav.label == '设备管理'"></i>
            <i class="el-icon-office-building" v-if="nav.label == '用户管理'"></i>
            <i class="el-icon-box" v-if="nav.label == '产品管理'"></i> {{nav.label}}
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            navData:[
                {label:'产品管理',id:1,path:'/proManage'},
                {label:'设备管理',id:2,path:'/deviceManage'},
                {label:'客户管理',id:4,path:'/customManage'},
                {label:'用户管理',id:3,path:'/userManage'},
            ]
        }
    },
    methods:{
        goto(path){
            if('/userManage' == path){
                this.$notify({
                    title: '提示',
                    message: '此模块暂未开放！',
                    duration: 1500
                });
                return;
            }
            this.$emit('tz',path);
        }
    }
}
</script>

<style scoped>
.navPc-container{
    width: 100%;
    height: 100%;
    background-color: #ffffff;
}
.navPc-item{
    width: 100%;
    height: 50px;
    text-align: center;
    font-size: 14px;
    color: rgb(83, 83, 83);
    line-height: 50px;
    border-bottom: 1px solid #ddd;
}
.navPc-item:hover{
    cursor: pointer;
    color: #409EFF;
    background-color: rgba(224, 235, 255, 0.3);
}
</style>


<template>
    <div class="header-container">
        <div class="header-title">
            <span class="sysName">{{sysName}}</span>
            <span class="version">{{version}}</span>
        </div>
        <div class="header-info">
            <span class="userName">欢迎您：{{userName}}</span>
            <a @click="logout()">退出</a>
        </div>
        
    </div>
</template>
<script>
import _global from '@/global/global.vue'
export default {
    data(){
        return{
            sysName:'',
            version:'',
            userName:'',
        }
    },
    mounted(){
        this.getSysInfo();
    },
    methods:{
        logout(){
            this.$handleLocalStorage('remove', 'lastLoginTime');
            this.$router.push({path:'/login'});
        },
        getSysInfo(){
            var params = new URLSearchParams();
            this.$axios({method:'get',url: _global.requestUrl+'/api/sys/v1/getSysInfo', data: params})
                .then(response =>{
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.sysName = res.data.cname;
                        this.version = res.data.cversion;
                        this.userName = this.$handleLocalStorage('get','username');
                    }else{
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                });
        }
    }
}
</script>
<style scoped>
.header-container{
    width: 100%;
    height: 100%;
    position: relative;
}
.header-title{
    width: 50%;
    height: 100%;
    padding-left: 20px;
    position: absolute;
    left: 0;
    top: 0;
}
.sysName{
    line-height: 50px;
    font-size: 20px;
    color: #fff;
}
.version{
    line-height: 50px;
    font-size: 14px;
    color: #ccc;
}
.header-info{
    width: 50%;
    height: 100%;
    text-align: right;
    color: #fff;
    font-size: 14px;
    line-height: 50px;
    position: absolute;
    top: 0;
    right: 20px;
}
.header-info a {
    margin-left: 20px;
    cursor: pointer;
}
</style>


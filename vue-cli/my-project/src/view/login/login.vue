<template>
    <div class="login-container">
        <div class="login-logo">
            <!-- <div class="login-logo-img"></div> -->
        </div>
        <div class="login-form">
            <div class="login-form-row">
                <div class="ipt-ico">
                    <i class="el-icon-user"></i>
                </div>
                <div class="ipt-info">
                    <input type="text" placeholder="请输入账号">
                </div>
            </div>
            <div class="login-form-row">
                <div class="ipt-ico">
                    <i class="el-icon-lock"></i>
                </div>
                <div class="ipt-info">
                    <input type="password" placeholder="请输入密码">
                </div>
            </div>
            <div class="login-form-row">
                <el-button type="primary" style="width:100%;height:100%;border-radius:20px;" @click="login()">登录</el-button>
            </div>
        </div>
        <div class="login-footer">
            BOJIA | 辽宁博嘉科技
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return {

        }
    },
    methods:{
        login(){
            this.$router.push({path: '/home'});
        }
    }
}
</script>

<style scoped>
.login-container{
    width: 100%;
    height: 100%;
    position: relative;
}
.login-logo{
    width: 100%;
    height: 30%;
    background-color: #409EFF;
    position: relative;
    padding-top: 30px;
}
.login-logo-img{
    width: 100px;
    height: 100px;
    border: 1px solid #fff;
    margin: 0 auto;
    border-radius: 50px
}
.login-form{
    width: 80%;
    height: 300px;
    background-color: #fff;
    position: absolute;
    top: 25%;
    left: 10%;
    box-sizing: border-box;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    padding-top: 50px;
}
.login-form-row{
    width: 70%;
    height: 40px;
    margin: 0 auto;
    position: relative;
    text-align: center;
    margin-top: 15px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 20px;
}
.ipt-ico{
    width: 10%;
    height: 40px;
    line-height: 40px;
    text-align: center;
    position: absolute;
    top: 0;
    left: 10%;
    color: #409EFF;
}
.ipt-info{
    width: 70%;
    height: 40px;
    line-height: 40px;
    text-align: center;
    position: absolute;
    top: 0;
    right: 0;
}
.ipt-info input{
    width: 100%;
    border: none;
    outline: none;
    background: none;
    padding-left: 10px;
    font-size: 10px;
    color: #999
}
.login-footer{
    width: 100%;
    height: 30px;
    line-height: 30px;
    font-size: 12px;
    color: #aaa;
    text-align: center;
    position: fixed;
    bottom: 0;
}
</style>

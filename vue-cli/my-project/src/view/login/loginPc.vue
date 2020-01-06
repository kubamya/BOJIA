<template>
    <div class="header">

	<div class="inner-header flex">
        <div class="loginForm-container">
            <div class="loginForm-header">
                SIMS
            </div>
            <div class="loginForm-form">
                <div class="loginForm-from-item">
                    <i class="el-icon-user ipt-icon"></i><input type="text" v-model="loginId" placeholder="请输入用户名">
                </div>
                <div class="loginForm-from-item">
                    <i class="el-icon-lock ipt-icon"></i><input type="password" v-model="password" placeholder="请输入密码">
                </div>
            </div>
            <div class="loginForm-btns">
                <el-button type="primary" @click="login()">登录</el-button>
                <el-button>重置</el-button>
            </div>
        </div>
	</div>

	<!--Waves Container-->
	<div>
		<svg class="waves"  viewBox="0 24 150 28" preserveAspectRatio="none" shape-rendering="auto">
			<defs>
				<path id="gentle-wave" d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z" />
			</defs>
			<g class="parallax">
				<use xlink:href="#gentle-wave" x="48" y="0" fill="rgba(255,255,255,0.7" />
				<use xlink:href="#gentle-wave" x="48" y="3" fill="rgba(255,255,255,0.5)" />
				<use xlink:href="#gentle-wave" x="48" y="5" fill="rgba(255,255,255,0.3)" />
				<use xlink:href="#gentle-wave" x="48" y="7" fill="#fff" />
			</g>
		</svg>
	</div>
	<!--Waves end-->

</div>
</template>
<script>
import _global from '@/global/global.vue'
export default {
    data(){
        return{
            loginId:'',
            password:'',
        }
    },
    methods:{
        login(){
            var params = new URLSearchParams();
            params.append('loginId', this.loginId);
            params.append('password', this.password);

            this.$axios({method:'post',url: _global.requestUrl+'/api/login/v1/loginDefault', data: params})
                .then(response =>{
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.$handleLocalStorage('set', 'comId', res.data.comid);
                        this.$handleLocalStorage('set', 'deptid', res.data.deptid);
                        this.$handleLocalStorage('set', 'userid', res.data.id);
                        this.$handleLocalStorage('set', 'username', res.data.username);
                        this.$handleLocalStorage('set', 'lastLoginTime', this.$getCurtime());
                        this.$router.push({path: '/mainPc'});
                    }else{
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                })
        }
    }
}
</script>

<style scoped>
@import "style.css";
input{
    outline: none;
    border: none;
    padding-left: 10px;
    border-bottom: 1px solid #ccc;
}
.ipt-icon{
    color: #409EFF;
}
.loginForm-container{
    width: 500px;
    height: 250px;
    background-color: #fff;
    border-radius: 10px;
    position: relative;
}
.loginForm-header{
    width: 100%;
    height: 60px;
    line-height: 50px;
    font-size: 20px;
    color: #409EFF;
}
.loginForm-form{
    width: 100%;
    height: 200px;
}
.loginForm-from-item{
    width: 100%;
    height: 50px;
    line-height: 50px;
}
.loginForm-btns{
    width: 100%;
    height: 50px;
    line-height: 50px;
    position: absolute;
    bottom: 20px;
}
</style>

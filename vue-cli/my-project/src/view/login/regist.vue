<template>
    <div class="regis-container">
        <div class="regis-header">
            <i class="el-icon-back" @click="goBack()"></i>
            <span>用户注册</span>
        </div>

        <div class="regis-content">
            <div style="height:30px;"></div>
            <div class="regis-form-row">
                <div class="regis-info-icon">
                    <i class="el-icon-box"></i>
                </div>
                <div class="regis-info-value">
                    <input placeholder="产品序列号（必填）" v-model="proId" />
                </div>
            </div>
            <div class="regis-form-row">
                <div class="regis-info-icon">
                    <i class="el-icon-user"></i>
                </div>
                <div class="regis-info-value">
                    <input placeholder="账号（必填）" v-model="loginId" />
                </div>
            </div>
            <div class="regis-form-row">
                <div class="regis-info-icon">
                    <i class="el-icon-lock"></i>
                </div>
                <div class="regis-info-value">
                    <input placeholder="密码（必填）" type="password" v-model="password" />
                </div>
            </div>
            <div class="regis-form-row">
                <div class="regis-info-icon">
                    <i class="el-icon-lock"></i>
                </div>
                <div class="regis-info-value">
                    <input placeholder="确认密码（必填）" type="password" v-model="passwordConfirm" />
                </div>
            </div>
            <div class="regis-form-row">
                <div class="regis-info-icon">
                    <i class="el-icon-mobile"></i>
                </div>
                <div class="regis-info-value">
                    <input placeholder="手机号码" type="number" v-model="tel" />
                </div>
            </div>
            <div class="regis-form-row">
                <div class="regis-info-icon">
                    <i class="el-icon-message"></i>
                </div>
                <div class="regis-info-value">
                    <input placeholder="邮箱" v-model="email" />
                </div>
            </div>
            <div style="height:80px;"></div>
            <div class="regis-form-submit">
                <el-button type="primary" round style="width:80%;" @click="regist()">立即注册</el-button>
                <p style="font-size:12px;color:#999;">注册即代表您同意<span style="color:#409EFF">《用户服务协议》</span></p>
            </div>
        </div>
    </div>
</template>
<script>
import _global from '@/global/global.vue'
export default {
    data(){
        return{
            proId:'',
            loginId:'',
            password:'',
            passwordConfirm:'',
            tel:'',
            email:'',
        }
    },
    mounted(){
        this.clearForm();
    },
    methods:{
        regist(){
            if(this.proId == '' && this.proId.replace(/\s*/g,"") == ''){
                this.$alert('产品序列号不能为空！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            };
            if(this.proId.length > 300){
                this.$alert('产品序列号字数超过限制！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            }
            if(this.loginId == '' && this.loginId.replace(/\s*/g,"") == ''){
                this.$alert('账号不能为空！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            };
            if(this.loginId.length > 300){
                this.$alert('账号字数超过限制！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            }
            if(this.password == '' && this.password.replace(/\s*/g,"") == ''){
                this.$alert('密码不能为空！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            };
            if(this.password.length > 300){
                this.$alert('密码字数超过限制！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            }
            if(this.passwordConfirm == '' && this.passwordConfirm.replace(/\s*/g,"") == ''){
                this.$alert('密码不能为空！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            };
            if(this.passwordConfirm.length > 300){
                this.$alert('密码字数超过限制！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            };
            if(this.password != this.passwordConfirm){
                this.$alert('密码不一致！','提示',{
                    confirmButtonText: '确定',
                    customClass: 'message-logout'
                });
                return;
            }

            var params = new URLSearchParams();
            params.append('cjr', '客户注册');
            params.append('optFlag', 'add');
            params.append('loginId', this.loginId);
            params.append('password', this.password);
            params.append('proId', this.proId);
            params.append('email', this.email);
            params.append('tel', this.tel);
            params.append('type', 0);
            this.$axios({method:'post',url: _global.requestUrl+'/api/user/v1/regis', data: params})
                .then(response =>{
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        // this.$message({
                        //     message: res.msg,
                        //     type: 'success'
                        // });
                        this.$alert(res.msg,'提示',{
                            confirmButtonText: '确定',
                            customClass: 'message-logout',
                            callback: action =>{
                                this.$router.push({path: '/login'});
                            }
                        });
                        
                    }else{
                        console.log(res.data);
                        this.$alert(res.msg,'提示',{
                            confirmButtonText: '确定',
                            customClass: 'message-logout'
                        });
                    }
                });
        },
        goBack(){
            this.clearForm();
            this.$router.push({path: '/login'});
        },
        clearForm(){
            this.loginId = '';
            this.password = '';
            this.passwordConfirm = '';
            this.tel = '';
            this.email = '';
        }
    }
}
</script>

<style scoped>
.regis-container{
    width: 100%;
    height: 100%;
    background-color: #ccc;
}
.regis-header{
    width: 100%;
    height: 50px;
    background-color: #409EFF;
    position: relative;
}
.regis-header i{
    width: 50px;
    height: 50px;
    text-align: center;
    line-height: 50px;
    color: #fff;
    font-size: 20px;
    position: absolute;
    left: 0;
    z-index: 999;
}
.regis-header span{
    width: calc(100% - 0px);
    height: 50px;
    line-height: 50px;
    color: #fff;
    font-size: 14px;
    position: absolute;
    left: 0;
    text-align: center;
}
.regis-content{
    width: 100%;
    height: calc(100% - 50px);
    background-color: #fff;
}
.regis-form-row{
    width: 100%;
    height: 50px;
    /* background-color: #ccc; */
    position: relative;
}
.regis-info-icon{
    width: 30%;
    height: 50px;
    text-align: center;
    line-height: 50px;
    position: absolute;
    left: 0;
    color: #409EFF;
}
.regis-info-value{
    width: 96%;
    height: 50px;
    line-height: 50px;
    position: absolute;
    left: 2%;
}
.regis-info-value input{
    background: none;
    outline: none;
    border: none;
    width: 80%;
    height: 30px;
    padding-left: 20%;
    color: #666;
    border-bottom: 1px solid #eee;
}
.regis-form-submit{
    width: 100%;
    height: 50px;
    text-align: center;
    line-height: 50px;
}
*{
    -webkit-tap-highlight-color:rgba(0,0,0,0);
}
</style>
<style>
  .el-message-box {
    width: 350px;
  }
</style>


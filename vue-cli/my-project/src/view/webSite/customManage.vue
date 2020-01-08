<template>
    <div class="cusManage-container">
        <div class="cusManage-header">
            <span class="">当前位置<i class="el-icon-d-arrow-right"></i>&nbsp;&nbsp;</span><span>客户管理</span>
        </div>
        <div class="cusManage-content">
            <div class="cusManage-content-addBar">
                <el-button type="primary" @click="add()">新增客户</el-button>
            </div>
            <div class="cusManage-info">
                <div class="cusManage-table">
                    <el-table 
                        :data="tableData" 
                        stripe
                        v-loading="loading"
                        highlight-current-row
                        style="width: 100%">
                        <el-table-column prop="userName" label="用户名"></el-table-column>
                        <el-table-column prop="loginId" label="账号"></el-table-column>
                        <el-table-column prop="tel" label="联系方式"></el-table-column>
                        <el-table-column prop="email" label="邮箱"></el-table-column>                        
                        <el-table-column prop="cjsj" label="创建时间"></el-table-column>
                        <el-table-column prop="xgsj" label="修改时间"></el-table-column>
                        <el-table-column label="操作">
                            <template slot-scope="scope">
                                <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                                <el-button type="text" size="small" @click="del(scope.row)">删除</el-button>
                            </template>
                        </el-table-column>                  
                    </el-table>
                </div>
                <div class="cusManage-pageBar"></div>
            </div>
        </div>

        <el-dialog
            :title="dialogTitle"
            :visible.sync="dialogVisible"
            :close-on-click-modal="false"
            width="40%">
            <div class="addForm-container">
                <div class="addForm-row">
                    <div class="addForm-label">
                        <span>*</span>客户名：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="userNameAdd" clearable placeholder="请输入名称" style="width:200px;"></el-input>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        <span>*</span>账号：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="loginIdAdd" clearable placeholder="请输入账号" style="width:200px;"></el-input>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        <span>*</span>密码：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="passwordAdd" clearable placeholder="请输入密码" type="password" style="width:200px;"></el-input>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        <span>*</span>确认密码：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="passwordConfirmAdd" clearable placeholder="请确认密码" type="password" style="width:200px;"></el-input>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        联系方式：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="telAdd" clearable  style="width:200px;"></el-input>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        邮箱：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="emailAdd" clearable  style="width:200px;"></el-input>
                    </div>
                </div>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button @click="cancle()">取 消</el-button>
                <el-button type="primary" @click="save()">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
import _global from '@/global/global.vue'
export default {
    data(){
        return{
            loading:false,
            tableData:[],
            dialogTitle:'',
            dialogVisible:false,
            userId:'',
            userNameAdd:'',
            loginIdAdd:'',
            passwordAdd:'',
            passwordConfirmAdd:'',
            telAdd:'',
            emailAdd:'',

        }
    },
    mounted(){
        this.getUserList();
    },
    methods:{
        edit(row){
            this.userId = row.userId;
            this.userNameAdd = row.userName;
            this.loginIdAdd = row.loginId;
            this.telAdd = row.tel;
            this.emailAdd = row.email;
            this.dialogTitle = '更新用户信息';
            this.dialogVisible = true;
        },
        save(){
            if(this.userNameAdd == '' && this.userNameAdd.replace(/\s*/g,"") == ''){
                this.$message({
                    message: '客户名不能为空！',
                    type: 'warning'
                });
                return;
            };
            if(this.userNameAdd.length > 300){
                this.$message({
                    message: '客户名字数超过限制！',
                    type: 'warning'
                });
                return;
            }
            if(this.loginIdAdd == '' && this.loginIdAdd.replace(/\s*/g,"") == ''){
                this.$message({
                    message: '账号不能为空！',
                    type: 'warning'
                });
                return;
            };
            if(this.loginIdAdd.length > 300){
                this.$message({
                    message: '账号字数超过限制！',
                    type: 'warning'
                });
                return;
            }
            if(this.passwordAdd == '' && this.passwordAdd.replace(/\s*/g,"") == ''){
                this.$message({
                    message: '密码不能为空！',
                    type: 'warning'
                });
                return;
            };
            if(this.passwordAdd.length > 300){
                this.$message({
                    message: '密码字数超过限制！',
                    type: 'warning'
                });
                return;
            }
            if(this.passwordConfirmAdd == '' && this.passwordConfirmAdd.replace(/\s*/g,"") == ''){
                this.$message({
                    message: '密码不能为空！',
                    type: 'warning'
                });
                return;
            };
            if(this.passwordConfirmAdd.length > 300){
                this.$message({
                    message: '密码字数超过限制！',
                    type: 'warning'
                });
                return;
            };
            if(this.passwordAdd != this.passwordConfirmAdd){
                this.$message({
                    message: '密码不一致！',
                    type: 'warning'
                });
                return;
            }
            var params = new URLSearchParams();
            if(this.userId == ''){                
                params.append('cjr', this.$handleLocalStorage('get','userid'));
                params.append('optFlag', 'add');
            }else{
                params.append('userId', this.userId);
                params.append('xgr', this.$handleLocalStorage('get','userid'));
                params.append('optFlag', 'upt');
            }
            params.append('userName', this.userNameAdd);
            params.append('loginId', this.loginIdAdd);
            params.append('password', this.passwordAdd);
            params.append('email', this.emailAdd);
            params.append('tel', this.telAdd);
            params.append('type', 0);
            this.$axios({method:'post',url: _global.requestUrl+'/api/user/v1/addOrUpdateUser', data: params})
                .then(response => {
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.$message({
                            message: res.msg,
                            type: 'success'
                        });
                        this.dialogVisible = false;
                        this.getUserList();
                    }else{
                        console.log(res.data);
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                });
        },
        add(){
            this.dialogTitle = '新增客户';
            this.dialogVisible = true;
            this.clearForm();
        },
        cancle(){
            this.dialogVisible = false;
            this.clearForm();
        },
        clearForm(){
            this.userId = '';
            this.userNameAdd = '';
            this.loginIdAdd = '';
            this.passwordAdd = '';
            this.passwordConfirmAdd = '';
            this.telAdd = '';
            this.emailAdd = '';
        },
        del(row){
            this.$confirm('此操作将删除该客户, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                var params = new URLSearchParams();
                params.append('userId', row.userId);
                this.$axios({method:'post',url: _global.requestUrl+'/api/user/v1/deleteUser', data: params})
                    .then(response => {
                        var res = this.$handleRes(response);
                        if(res.code == 100){
                            this.$message({
                                message: res.msg,
                                type: 'success'
                            });
                            this.getUserList();
                        }else{
                            console.log(res.data);
                            this.$message({
                                message: res.msg,
                                type: 'warning'
                            });
                        }
                    });
            });
        },
        getUserList(){
            this.loading = true;
            var params = new URLSearchParams();
            params.append('type', 0);
            this.$axios({method:'post',url: _global.requestUrl+'/api/user/v1/getUserList', data: params})
                .then(response => {
                    var res = this.$handleRes(response);
                    if(res.code == 100){
                        this.tableData = res.data;
                        this.loading = false;
                    }else{
                        console.log(res.data);
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                        this.loading = false;
                    }
                });
        }
    }
}
</script>

<style scoped>
.cusManage-container{
    width: 98%;
    height: calc(98% - 20px);
    background-color: #fff;
    margin: 1% auto;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    position: relative;
}
.cusManage-header{
    width: 98%;
    height: 30px;
    font-size: 12px;
    line-height: 30px;
    color: #666;
    border-bottom: 1px solid #409EFF;
    position: absolute;
    top: 0;
    left: 1%;
}
.cusManage-header i{
    color: #409EFF;
}

.cusManage-content{
    width: 98%;
    height: calc(100% - 45px);
    position: absolute;
    top: 35px;
    left: 1%;
}
.cusManage-content-addBar{
    width: 100%;
    height: 50px;
    line-height: 50px;
}
.cusManage-form{
    background-color: #ccc;
    width: 100%;
}
.cusManage-info{
    width: 100%;
    height: calc(100% - 50px);    
    position: relative;
}
.cusManage-table{
    width: 100%;
    height: calc(100% - 50px);
    /* border:1px solid #409EFF;
    border-radius: 0px 0px 10px 10px; */
}
.cusManage-pageBar{
    width: 100%;
    height: 50px;
    position: absolute;
    bottom: 0;
}
.addForm-container{
    width: 100%;
    height: 350px;
}
.addForm-row{
    width: 100%;
    height: 60px;
    line-height: 60px;
    position: relative;
}
.addForm-row span{
    color: red;
}
.addForm-label{
    width: 40%;
    height: 60px;
    text-align: right;
    position: absolute;
    left: 0;
}
.addForm-ipt{
    width: 60%;
    height: 60px;
    text-align: left;
    position: absolute;
    right: 0;
}
</style>

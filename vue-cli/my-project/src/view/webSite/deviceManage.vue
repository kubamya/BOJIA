<template>
    <div class="devManage-container">
        <div class="devManage-header">
            <span class="">当前位置<i class="el-icon-d-arrow-right"></i>&nbsp;&nbsp;</span><span>设备管理</span>
        </div>
        <div class="devManage-content">
            <div class="devManage-content-addBar">
                <el-button type="primary" @click="add()">新增设备</el-button>
            </div>
            <div class="devManage-info">
                <div class="devManage-table">
                    <el-table 
                        :data="tableData" 
                        stripe
                        v-loading="loading"
                        highlight-current-row
                        style="width: 100%">
                        <el-table-column prop="devName" label="设备名称"></el-table-column>
                        <el-table-column prop="devId" label="设备ID"></el-table-column>
                        <el-table-column prop="proName" label="产品名称"></el-table-column>                        
                        <el-table-column prop="sfzx" label="是否在线"></el-table-column>
                        <el-table-column prop="cjxj" label="创建时间"></el-table-column>
                        <el-table-column prop="xgxj" label="修改时间"></el-table-column>
                        <el-table-column label="操作">
                            <template slot-scope="scope">
                                <el-button @click="more(scope.row)" type="text" size="small">详情</el-button>
                                <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                                <el-button type="text" size="small" @click="del(scope.row)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </div>
                <div class="devManage-pageBar"></div>
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
                        <span>*</span>所属产品：
                    </div>
                    <div class="addForm-ipt">
                        <el-select v-model="sscpAdd" placeholder="请选择" clearable style="width:200px;">
                            <el-option
                                v-for="item in sscpOptions"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        <span>*</span>设备名称：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="sbmcAdd" clearable placeholder="请输入名称" style="width:200px;"></el-input>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        <span>*</span>设备秘钥：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="sbmyAdd" clearable placeholder="请输入名称" style="width:200px;"></el-input>
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
        return {
            dialogTitle:'',
            sbmcAdd:'',
            sscpAdd:'',
            sbmyAdd:'',
            devId:'',
            dialogVisible:false,
            loading:false,
            tableData:[],
            sscpOptions:[]
        }
    },
    mounted(){
        this.getDevList();
        this.getSellProList();
    },
    methods:{
        more(row){

        },
        del(row){

            this.$confirm('此操作将删除该设备, 是否继续?', '提示',{
                 confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                var params = new URLSearchParams();
                params.append('devId', row.devId);
                this.$axios({method:'post',url: _global.requestUrl+'/api/device/v1/deleteDev', data: params})
                    .then(response => {
                        var res = this.$handleRes(response);

                        if(res.code == 100){
                            this.getDevList();
                            this.$message({
                                message: res.msg,
                                type: 'success'
                            });
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
        edit(row){
            var params = new URLSearchParams();
            params.append('devId', row.devId);
            this.$axios({method:'post',url: _global.requestUrl+'/api/device/v1/getDevById', data: params})
                .then(response => {
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.sbmcAdd = res.data.devName;
                        this.sscpAdd = res.data.proId;
                        this.sbmyAdd = res.data.sbmy;
                        this.devId = res.data.devId;
                    }else{
                        console.log(res.data);
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                });
            this.dialogTitle = '更新设备';
            this.dialogVisible = true;
        },
        getSellProList(){
            var params = new URLSearchParams();
            this.$axios({method:'post',url: _global.requestUrl+'/api/pro/v1/getSellProList', data: params})
                .then(response => {
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.sscpOptions = res.data;
                    }else{
                        console.log(res.data);
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                });
        },
        save(){
            if(this.sbmcAdd == '' && this.sbmcAdd.replace(/\s*/g,"") == ''){
                this.$message({
                    message: '设备名称不能为空！',
                    type: 'warning'
                });
                return;
            };
            if(this.sbmcAdd.length > 300){
                this.$message({
                    message: '设备名称字数超过限制！',
                    type: 'warning'
                });
                return;
            }
            if(this.sbmyAdd == '' && this.sbmyAdd.replace(/\s*/g,"") == ''){
                this.$message({
                    message: '设备秘钥不能为空！',
                    type: 'warning'
                });
                return;
            };
            if(this.sbmyAdd.length > 300){
                this.$message({
                    message: '设备秘钥字数超过限制！',
                    type: 'warning'
                });
                return;
            }
            if(this.sscpAdd == ''){
                this.$message({
                    message: '所属产品不能为空！',
                    type: 'warning'
                });
                return;
            }
            var params = new URLSearchParams();
            params.append('proId', this.sscpAdd);
            params.append('devName', this.sbmcAdd);
            params.append('sbmy', this.sbmyAdd);
            if(this.devId != ''){
                params.append('devId', this.devId);
                params.append('xgr', this.$handleLocalStorage('get','userid'));
                params.append('optFlag', 'upt');
            }else{
                params.append('cjr', this.$handleLocalStorage('get','userid'));
                params.append('optFlag', 'add');
            }
            this.$axios({method:'post',url: _global.requestUrl+'/api/device/v1/addOrUpdateDev', data: params})
                .then(response => {
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.$message({
                            message: res.msg,
                            type: 'success'
                        });
                        this.dialogVisible = false;
                        this.getDevList();
                    }else{
                        console.log(res.data);
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                });
        },
        cancle(){
            this.sbmcAdd = '';
            this.sscpAdd = '';
            this.sbmyAdd = '';
            this.devId = '';
            this.dialogVisible = false;
        },
        add(){
            this.sbmcAdd = '';
            this.sscpAdd = '';
            this.sbmyAdd = '';
            this.devId = '';
            this.dialogTitle = '新增设备';
            this.dialogVisible = true;
        },
        getDevList(){
            this.loading = true;
            var params = new URLSearchParams();
            this.$axios({method:'post',url: _global.requestUrl+'/api/device/v1/getDevList', data: params})
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
.devManage-container{
    width: 98%;
    height: calc(98% - 20px);
    background-color: #fff;
    margin: 1% auto;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    position: relative;
}
.devManage-header{
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
.devManage-header i{
    color: #409EFF;
}
.devManage-content{
    width: 98%;
    height: calc(100% - 45px);
    position: absolute;
    top: 35px;
    left: 1%;
}
.devManage-content-addBar{
    width: 100%;
    height: 50px;
    line-height: 50px;
}
.devManage-info{
    width: 100%;
    height: calc(100% - 50px);    
    position: relative;
}
.devManage-table{
    width: 100%;
    height: calc(100% - 50px);
    /* border:1px solid #409EFF;
    border-radius: 0px 0px 10px 10px; */
}
.devManage-pageBar{
    width: 100%;
    height: 50px;
    position: absolute;
    bottom: 0;
}
.addForm-container{
    width: 100%;
    height: 180px;
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

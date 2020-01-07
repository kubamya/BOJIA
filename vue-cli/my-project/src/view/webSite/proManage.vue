<template>
    <div class="proManage-container">
        <div class="proManage-header">
            <span class="">当前位置<i class="el-icon-d-arrow-right"></i>&nbsp;&nbsp;</span><span>产品管理</span>
        </div>
        <div class="proManage-content">
            <div class="proManage-content-addBar">
                <el-button type="primary" @click="add()">新增产品</el-button>
            </div>
            <!-- <div class="proManage-form">
                <el-row>
                    <el-col :span="6">
                        <div>
                            <div>产品名称</div>
                            <div>
                                <el-input v-model="cpmc" clearable placeholder="请输入名称"></el-input>
                            </div>
                        </div>
                    </el-col>
                    <el-col :span="6">
                        <div>
                            <div>产品类型</div>
                            <div>
                                <el-select v-model="cplx" placeholder="请选择" clearable>
                                    <el-option
                                        v-for="item in cplxOptions"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                    </el-option>
                                </el-select>
                            </div>
                        </div>
                    </el-col>                    
                </el-row>
                <el-row>
                    <el-col :span="6">
                        <el-button type="primary">新增产品</el-button>
                    </el-col>
                </el-row>
            </div> -->
            <div class="proManage-info">
                <div class="proManage-table">
                    <el-table 
                        :data="tableData" 
                        stripe
                        v-loading="loading"
                        highlight-current-row
                        style="width: 100%">
                        <el-table-column prop="proId" label="产品序列号"></el-table-column>
                        <el-table-column prop="proName" label="产品名称"></el-table-column>
                        <el-table-column prop="type" label="产品类型"></el-table-column>
                        <el-table-column prop="user" label="所属客户"></el-table-column>
                        <el-table-column prop="cjr" label="创建人"></el-table-column>
                        <el-table-column prop="xgr" label="修改人"></el-table-column>
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
                <div class="proManage-pageBar"></div>
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
                        <span>*</span>产品名称：
                    </div>
                    <div class="addForm-ipt">
                        <el-input v-model="cpmcAdd" clearable placeholder="请输入名称" style="width:200px;"></el-input>
                    </div>
                </div>
                <div class="addForm-row">
                    <div class="addForm-label">
                        <span>*</span>产品类型：
                    </div>
                    <div class="addForm-ipt">
                        <el-select v-model="cplxAdd" placeholder="请选择" clearable style="width:200px;">
                            <el-option
                                v-for="item in cplxOptions"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
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
            cpmc:'',
            cpmcAdd:'',
            cplx:'',
            cplxAdd:'',
            cplxOptions:[
                {
                    label:'产品1',
                    value:'1'
                },
                {
                    label:'产品2',
                    value:'2'
                }
            ],
            tableData:[],
            dialogVisible: false,
            dialogTitle:'',
            proId:'',
        }
    },
    mounted(){
        this.getProList();
    },
    methods:{
        // 删除按钮
        del(row){
            this.$confirm('此操作将删除该产品, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
                }).then(() => {
                    var params = new URLSearchParams();
                    params.append('proId', row.proId);

                    this.$axios({method:'post',url: _global.requestUrl+'/api/pro/v1/setProDisable', data: params})
                        .then(response => {
                            var res = this.$handleRes(response);
                            if(res.code == 100){
                                this.$message({
                                    message: res.msg,
                                    type: 'success'
                                });
                                this.getProList();
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
        // 编辑按钮
        edit(row){
            this.dialogTitle = '编辑产品'
            this.dialogVisible = true;
            this.cpmcAdd = row.proName;
            this.cplxAdd = row.type;
            this.proId = row.proId;
        },
        // 获取产品列表
        getProList(){
            this.loading = true;
            var params = new URLSearchParams();
            this.$axios({method:'post',url: _global.requestUrl+'/api/pro/v1/getProList', data: params})
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
        },

        // 新增表单取消事件
        cancle(){
            this.cpmcAdd = '';
            this.cplxAdd = '';
            this.proId = '';
            this.dialogVisible = false;
        },

        add(){
            this.dialogTitle = '新增产品';
            this.dialogVisible = true;
            this.cpmcAdd = '';
            this.cplxAdd = '';
            this.proId = '';
        },
        // 新增表单保存事件
        save(){
            if(this.cpmcAdd == '' && this.cpmcAdd.replace(/\s*/g,"") == ''){
                this.$message({
                    message: '产品名称不能为空！',
                    type: 'warning'
                });
                return;
            };
            if(this.cpmcAdd.length > 300){
                this.$message({
                    message: '产品名称字数超过限制！',
                    type: 'warning'
                });
                return;
            }
            if(this.cplxAdd == ''){
                this.$message({
                    message: '产品类型不能为空！',
                    type: 'warning'
                });
                return;
            }

            var params = new URLSearchParams();
            params.append('proName', this.cpmcAdd);
            params.append('type', this.cplxAdd);
            if(this.proId == ''){                
                params.append('cjr', this.$handleLocalStorage('get','userid'));
                params.append('optFlag', 'add');
            }else{
                params.append('proId', this.proId);
                params.append('xgr', this.$handleLocalStorage('get','userid'));
                params.append('optFlag', 'upt');
            }

            this.$axios({method:'post',url: _global.requestUrl+'/api/pro/v1/addOrUpdatePro', data: params})
                .then(response => {
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.$message({
                            message: res.msg,
                            type: 'success'
                        });
                        this.dialogVisible = false;
                        this.getProList();
                    }else{
                        console.log(res.data);
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
.proManage-container{
    width: 98%;
    height: calc(98% - 20px);
    background-color: #fff;
    margin: 1% auto;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    position: relative;
}
.proManage-header{
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
.proManage-header i{
    color: #409EFF;
}
.proManage-content{
    width: 98%;
    height: calc(100% - 45px);
    position: absolute;
    top: 35px;
    left: 1%;
}
.proManage-content-addBar{
    width: 100%;
    height: 50px;
    line-height: 50px;
}
.proManage-form{
    background-color: #ccc;
    width: 100%;
}
.proManage-info{
    width: 100%;
    height: calc(100% - 50px);    
    position: relative;
}
.proManage-table{
    width: 100%;
    height: calc(100% - 50px);
    /* border:1px solid #409EFF;
    border-radius: 0px 0px 10px 10px; */
}
.proManage-pageBar{
    width: 100%;
    height: 50px;
    position: absolute;
    bottom: 0;
}
.addForm-container{
    width: 100%;
    height: 120px;
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


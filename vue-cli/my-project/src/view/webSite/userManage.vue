<template>
    <div class="userManage-container">
        <div class="userManage-header">
            <span class="">当前位置<i class="el-icon-d-arrow-right"></i>&nbsp;&nbsp;</span><span>用户管理</span>
        </div>
        <div class="userManage-content">
            <div class="userManage-content-addBar">
                <el-button type="primary" @click="add()">新增用户</el-button>
            </div>
            <div class="userManage-info">
                <div class="userManage-table"></div>
                <div class="userManage-pageBar"></div>
            </div>
        </div>
    </div>
</template>
<style scoped>
.userManage-container{
    width: 98%;
    height: calc(98% - 20px);
    background-color: #fff;
    margin: 1% auto;
    border-radius: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    position: relative;
}
.userManage-header{
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
.userManage-header i{
    color: #409EFF;
}

.userManage-content{
    width: 98%;
    height: calc(100% - 45px);
    position: absolute;
    top: 35px;
    left: 1%;
}
.userManage-content-addBar{
    width: 100%;
    height: 50px;
    line-height: 50px;
}
.userManage-form{
    background-color: #ccc;
    width: 100%;
}
.userManage-info{
    width: 100%;
    height: calc(100% - 50px);    
    position: relative;
}
.userManage-table{
    width: 100%;
    height: calc(100% - 50px);
    /* border:1px solid #409EFF;
    border-radius: 0px 0px 10px 10px; */
}
.userManage-pageBar{
    width: 100%;
    height: 50px;
    position: absolute;
    bottom: 0;
}
</style>


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
                <div class="cusManage-table"></div>
                <div class="cusManage-pageBar"></div>
            </div>
        </div>
    </div>
</template>
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
</style>

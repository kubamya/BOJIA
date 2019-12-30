<template>
    <div class="mine-container">
        <div class="mine-header-container">
            <div class="mine-header-title">我的</div>
        </div>

        <div class="mine-userInfo-container">
            <div class="mine-userInfo-img">
                <img src="../../../static/img/user.jpg" alt="">
            </div>
            <div class="mine-userInfo-text">超级管理员</div>
        </div>

        <div class="mine-opera-container">
            <div class="mine-opera-row">
                <div class="mine-opera-row-icon"><i class="el-icon-office-building"></i></div>
                <div class="mine-opera-row-text">企业主页</div>
            </div>
            <div class="mine-opera-row">
                <div class="mine-opera-row-icon"><i class="el-icon-setting"></i></div>
                <div class="mine-opera-row-text">个人设置</div>
            </div>
            <div class="mine-opera-row">
                <div class="mine-opera-row-icon"><i class="el-icon-chat-line-round"></i></div>
                <div class="mine-opera-row-text">消息中心</div>
            </div>
            <div class="mine-opera-row">
                <div class="mine-opera-row-icon"><i class="el-icon-edit-outline"></i></div>
                <div class="mine-opera-row-text">意见反馈</div>
            </div>
        </div>

        <div class="minue-logout-container">
            <el-button style="width:60%;" type="danger">退出登录</el-button>
        </div>
    </div>
</template>
<style scoped>
.mine-container{
    width: 100%;
    height: 100%;    
    background-color: #f1f1f1;
}
.mine-header-container{
    width: 100%;
    height: 50px;
    background-color: #409EFF;
}
.mine-header-title{
    width: 100%;
    height: 50px;
    line-height: 50px;
    text-align: center;
    font-size: 16px;
    color: #fff;
}
.mine-userInfo-container{
    width: 100%;
    height: 90px;
    background-color: #fff;
    border-bottom: 1px solid #f1f1f1;
    box-sizing: border-box;
    position: relative;
}
.mine-userInfo-img{
    width: 70px;
    height: 70px;
    text-align: center;
    overflow: hidden;
    border-radius: 5px;
    position: absolute;
    top: 10px;
    left: 10px;
}
.mine-userInfo-img img{
    width: 100%;
}
.mine-userInfo-text{
    width: calc(100% - 100px);
    height: 90px;
    line-height: 90px;
    font-size: 16px;
    color: #333;
    position: absolute;
    /* font-weight: 600; */
    top: 0;
    left: 100px;
}
.mine-opera-container{
    width: 100%;
    height: calc(100% - 150px);
    margin-top: 10px;
}
.mine-opera-row{
    width: 100%;
    height: 40px;
    background-color: #fff;
    border-bottom: 1px solid #f1f1f1;
    box-sizing: border-box;
    position: relative;
}
.mine-opera-row-icon{
    width: 40px;
    height: 40px;
    text-align: center;
    color: #409EFF;
    line-height: 40px;
    position: absolute;
    top: 0;
    left: 0;
}
.mine-opera-row-text{
    width: calc(100% - 40px);
    height: 40px;
    line-height: 40px;
    position: absolute;
    top: 0;
    left: 40px;
    color: #333;
}
.minue-logout-container{
    width: 100%;
    height: 50px;
    text-align: center;
    line-height: 50px;
    position: absolute;
    bottom: 60px;
}
</style>

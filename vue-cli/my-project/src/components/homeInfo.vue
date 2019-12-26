<template>
    <div class="homeInfo-container">
        <div class="homeInfo-header">
            <div class="homeInfo-header-icon">|</div>
            <div class="homeInfo-header-title">设备工作状态</div>
        </div>

        <div class="homeInfo-content">
            <div class="homeInfo-content-img">
                <img src="../../static/img/orange.jpg" alt="">
            </div>
            <div class="homeInfo-content-text">
                <ul>
                    <li>·模&nbsp;&nbsp;&nbsp;&nbsp;式：手动模式</li>
                    <li>·卷帘机：正在下行</li>
                    <li>·卷膜机：卷帘机已打开，无法操作卷膜机</li>
                    <li>·水&nbsp;&nbsp;&nbsp;&nbsp;泵：关闭</li>
                    <li>·电磁阀：关闭</li>
                    <li>·肥&nbsp;&nbsp;&nbsp;&nbsp;料：关闭</li>
                    <li>·补光灯：关闭</li>
                </ul>
            </div>
        </div>
    </div>
</template>
<style scoped>
.homeInfo-container{
    width: 100%;
    height: 100%;
    background-color: #fff;
}
.homeInfo-header{
    width: 100%;
    height: 30px;
    background-color: #fff;
    position: relative;
}
.homeInfo-header-icon{
    width: 20px;
    height: 100%;
    line-height: 30px;
    color: #409EFF;
    text-align: center;
    font-weight: 900;
    position: absolute;
    top: 0;
    left: 0;
}
.homeInfo-header-title{
    width: calc(100% - 20px);
    height: 100%;
    color: #333;
    font-size: 14px;
    line-height: 30px;
    position: absolute;
    top: 0;
    left: 20px;
    /* font-weight: 600; */
}
.homeInfo-content{
    width: 100%;
    height: calc(100% - 30px);
    position: relative;
}
.homeInfo-content-img{
    /* background-color: #cccccc; */
    text-align: center;
    width: 40%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
}
.homeInfo-content-img img{
    width: 90%;
}
.homeInfo-content-text{
    width: 60%;
    height: 100%;
    position: absolute;
    top: 0;
    right: 0;
    font-size: 14px;
    color: #333;
    padding-left: 20px;
}
.homeInfo-content-text ul{
    list-style: none;
}
</style>

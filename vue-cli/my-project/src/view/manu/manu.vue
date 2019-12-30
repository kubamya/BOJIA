<template>
    <div class="manu-container">
        <div class="manu-header-container">
            <div class="manu-header-title">手动控制</div>
        </div>

        <div class="manu-content">
            <div class="manu-item-mulRow">
                <div class="manu-item-mulRow-header">
                    <div class="manu-item-mulRow-header-icon"><i class="el-icon-toilet-paper"></i></div>
                    <div class="manu-item-mulRow-header-text">卷帘机</div>
                </div>
                <div class="manu-item-mulRow-content">
                    <el-radio-group v-model="radio">
                        <el-radio :label="1">上行</el-radio>
                        <el-radio :label="2">下行</el-radio>
                        <el-radio :label="3">停止</el-radio>
                    </el-radio-group>
                </div>
            </div>

            <div class="manu-item-mulRow">
                <div class="manu-item-mulRow-header">
                    <div class="manu-item-mulRow-header-icon"><i class="el-icon-toilet-paper"></i></div>
                    <div class="manu-item-mulRow-header-text">卷膜机</div>
                </div>
                <div class="manu-item-mulRow-content">
                    <el-radio-group v-model="radio2">
                        <el-radio :label="1">上行</el-radio>
                        <el-radio :label="2">下行</el-radio>
                        <el-radio :label="3">停止</el-radio>
                    </el-radio-group>
                </div>
            </div>

            <div class="manu-item-mulRowAuto">
                <div class="manu-item-mulRow-header">
                    <div class="manu-item-mulRow-header-icon"><i class="el-icon-set-up"></i></div>
                    <div class="manu-item-mulRow-header-text">电磁阀门</div>
                </div>
                <div class="manu-item-mulRowAuto-content">
                    <el-radio-group v-model="radio3">
                        <div class="radioRow">
                            <el-radio :label="1">1号阀门</el-radio>
                            <el-radio :label="2">2号阀门</el-radio>
                            <el-radio :label="3">3号阀门</el-radio>
                        </div>
                        <div class="radioRow">                            
                            <el-radio :label="4">4号阀门</el-radio>
                            <el-radio :label="5">关闭</el-radio>
                        </div>
                        
                    </el-radio-group>
                </div>
            </div>
            
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-odometer"></i></div>
                <div class="manu-item-text">水泵</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        style="-webkit-tap-highlight-color:rgba(0,0,0,0);"
                        v-model="sb">
                    </el-switch>
                </div>
            </div>
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-sold-out"></i></div>
                <div class="manu-item-text">肥料</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        style="-webkit-tap-highlight-color:rgba(0,0,0,0);"
                        v-model="fl">
                    </el-switch>
                </div>
            </div>
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-table-lamp"></i></div>
                <div class="manu-item-text">补光灯</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        style="-webkit-tap-highlight-color:rgba(0,0,0,0);"
                        v-model="bgd">
                    </el-switch>
                </div>
            </div> 
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return {
            //开关绑定数据
            sb:true,
            fl:true,
            bgd:false,

            radio:1,
            radio2:2,
            radio3:1,
        }
    }
}
</script>

<style scoped>
.manu-container{
    width: 100%;
    height: 100%;
    background-color: #f1f1f1;
}
.manu-header-container{
    width: 100%;
    height: 50px;
    background-color: #409EFF;
}
.manu-header-title{
    width: 100%;
    height: 50px;
    line-height: 50px;
    text-align: center;
    font-size: 16px;
    color: #fff;
}
.manu-content{
    width: 100%;
    height: calc(100% - 50px);
}
.manu-item-mulRowAuto{
    width: 100%;
    background-color: #fff;
    border-bottom: 1px solid #f1f1f1;
    box-sizing: border-box;
    position: relative;
}
.manu-item-mulRow{
    width: 100%;
    height: 65px;
    background-color: #fff;
    border-bottom: 1px solid #f1f1f1;
    box-sizing: border-box;
    position: relative;
}
.manu-item-mulRow-header{
    width: 100%;
    height: 30px;
    position: relative;
}
.manu-item-mulRow-header-icon{
    height: 30px;
    width: 60px;
    color: #409EFF;
    text-align: center;
    font-size: 20px;
    line-height: 30px;
    position: absolute;
    left: 0;
    top: 0;
}
.manu-item-mulRow-header-text{
    width: calc(100% - 60px);
    height: 30px;
    position: absolute;
    top: 0;
    left: 60px;
    line-height: 30px;
    font-size: 14px;
    color: #333;
}
.manu-item-mulRow-content{
    width: calc(100% - 30px);
    height: 30px;
    line-height: 30px;
    text-align: left;
    padding-left: 30px;
}
.manu-item-mulRowAuto-content{
    width: calc(100% - 30px);
    text-align: left;
    padding-left: 30px;
}
.radioRow{
    width: 100%;
    height: 30px;
    line-height: 30px;
}
.manu-item-row{
    width: 100%;
    height: 60px;
    background-color: #fff;
    border-bottom: 1px solid #f1f1f1;
    box-sizing: border-box;
    position: relative;
}
.manu-item-icon{
    width: 60px;
    height: 60px;
    text-align: center;
    position: absolute;
    top: 0;
    left: 0;
}
.manu-item-icon i{
    font-size: 20px;
    color: #409EFF;
    line-height: 60px;
}
.manu-item-siwtch{
    width: 60px;
    height: 60px;
    text-align: center;
    line-height: 60px;
    position: absolute;
    top: 0;
    right: 0;
}
.manu-item-text{
    width: calc(100% - 120px);
    height: 60px;
    color: #333;
    line-height: 60px;
    position: absolute;
    left: 60px;
    top: 0;
}
*{
    -webkit-tap-highlight-color:rgba(0,0,0,0);
}
</style>

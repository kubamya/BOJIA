<template>
    <div class="manu-container">
        <div class="manu-header-container">
            <div class="manu-header-title">手动控制</div>
        </div>

        <div class="manu-content">
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-odometer"></i></div>
                <div class="manu-item-text">卷帘机</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        v-model="jlj">
                    </el-switch>
                </div>
            </div>
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-odometer"></i></div>
                <div class="manu-item-text">卷膜机</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        v-model="jmj">
                    </el-switch>
                </div>
            </div>
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-odometer"></i></div>
                <div class="manu-item-text">水泵</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        v-model="sb">
                    </el-switch>
                </div>
            </div>
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-odometer"></i></div>
                <div class="manu-item-text">电磁阀</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        v-model="dcf">
                    </el-switch>
                </div>
            </div>
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-odometer"></i></div>
                <div class="manu-item-text">肥料</div>
                <div class="manu-item-siwtch">
                    <el-switch
                        v-model="fl">
                    </el-switch>
                </div>
            </div>
            <div class="manu-item-row">
                <div class="manu-item-icon"><i class="el-icon-odometer"></i></div>
                <div class="manu-item-text">补光灯</div>
                <div class="manu-item-siwtch">
                    <el-switch
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
            jlj:true,
            jmj:false,
            sb:true,
            dcf:true,
            fl:true,
            bgd:false,

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
    font-size: 30px;
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
</style>

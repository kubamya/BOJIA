<template>
    <div class="meter-container">
        <div class="meter-header">
            <div class="meter-header-icon">|</div>
            <div class="meter-header-title">实时数据监控</div>
        </div>

        <div class="echarts-area-container">
            <div class="echarts-area">
            <!-- <div id="echart-container" style="width:100%;height:100px;"></div> -->
                <el-progress type="dashboard" :width="progressWidth" :percentage="25"></el-progress>
                <div class="progress-text">室内温度</div>
            </div>
            <div class="echarts-area">
                <el-progress type="dashboard" :width="progressWidth" :percentage="30"></el-progress>
                <div class="progress-text">室内湿度</div>
            </div><div class="echarts-area">
                <el-progress type="dashboard" :width="progressWidth" :percentage="12"></el-progress>
                <div class="progress-text">室内土壤温度</div>
            </div>
        </div>

        <div class="echarts-area-container">
            <div class="echarts-area">
                <el-progress type="dashboard" :width="progressWidth" :percentage="58"></el-progress>
                <div class="progress-text">室内土壤湿度</div>
            </div>
            <div class="echarts-area">
                <el-progress type="dashboard" :width="progressWidth" :percentage="79"></el-progress>
                <div class="progress-text">室外温度</div>
            </div><div class="echarts-area">
                <el-progress type="dashboard" :width="progressWidth" :percentage="44"></el-progress>
                <div class="progress-text">室外湿度</div>
            </div>
        </div>

        
        
    </div>
</template>
<script>
export default {
    props:['devId'],
    data(){
        return {
            //仪表盘大小
            progressWidth:105
            
        }
    },
    mounted(){
        console.log('获得设备id',this.devId);
    },
     methods: {
        
    }
}
</script>

<style scoped>
.meter-container{
    width: 100%;
    height: 100%;
    background-color: #fff;
}
.meter-header{
    width: 100%;
    height: 30px;
    background-color: #fff;
    position: relative;
}
.meter-header-icon{
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
.meter-header-title{
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
.echarts-area-container{
    width: 90%;
    height: 100px;
    margin: 0 auto;
}
.echarts-area{
    width: 33.33333333%;
    height: 100px;
    background-color: #fff;
    text-align: center;
    float: left;
    position: relative;
}
.progress-text{
    width: 100%;
    text-align: center;
    position: absolute;
    bottom: 20px;
    font-size: 12px;
    color: #333;
}
/* .echart-container{
    width: 100%;
    height: 100px;
} */
</style>

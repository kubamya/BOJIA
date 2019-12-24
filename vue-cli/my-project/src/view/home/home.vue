<template>
    <div class="home-container">
        <div class="home-head-container">
            <div class="home-head-bar">
                <div class="home-head-more"><i class="el-icon-s-operation"></i></div>
                <div class="home-head-title">首页</div>
                <div class="home-head-select">
                    <!-- <el-select v-model="value" placeholder="请选择">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select> -->
                </div>
            </div>
            <div class="home-weather">
                <!-- <div class="home-weather-day">
                    <div class="home-weather-day-title">
                        <a>今日天气</a>
                    </div>
                    <div class="home-weather-day-info"></div>
                </div>
                <div class="home-weather-day">
                    <div class="home-weather-day-title">
                        <a>今日天气</a>
                    </div>

                </div> -->
                <weatherCom></weatherCom>
            </div>
        </div>
    </div>
</template>
<script>
import weather from '@/components/weather.vue';
export default {
    components:{
        weatherCom: weather
    },
    data(){
        return {
            value:'选项1',
            options: [
                {value:'选项1', label:'一号大棚'},
                {value:'选项2', label:'二号大棚'},
                {value:'选项3', label:'三号大棚'}
            ]
        }
    }
}
</script>

<style scoped>
.home-container{
    width: 100%;
    height: 100%;
    background-color: #ccc;
}
.home-head-container{
    background-color: #409EFF;
    width: 100%;
    height: 180px;
}
.home-head-bar{
    width: 100%;
    height: 50px;
    position: relative;
}
.home-head-more{
    width: 10%;
    height: 50px;
    line-height: 50px;
    padding-left: 10px;
    position: absolute;
    top: 0;
    left: 0;
}
.home-head-more i{
    color: #fff;
}
.home-head-title{
    width: 100%;
    height: 50px;
    position: fixed;
    top: 0;
    text-align: center;
    line-height: 50px;
    font-size: 16px;
    color: #fff;
}
.home-head-select{
    width: 30%;
    height: 50px;
    position: absolute;
    right: 10px;
    top: 0;
    line-height: 50px;
}
.el-input--small .el-input__inner {
    height: 32px;
    line-height: 32px;
    background: none !important;
    color: #fff;
    border: none;
}
.home-weather{
    width: 100%;
    height: calc(100% - 50px);
    position: relative;
}
/* .home-weather-day{
    width: 50%;
    height: 100%;
    float: left; */
    /* position: absolute;
    top: 0;
    left: 0;
    box-sizing: border-box;
    border-right: 1px solid rgba(255, 255, 255, 0.1); */
/* } */
</style>

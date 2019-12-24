<template>
    <div class="weather-container">
        <div class="home-weather-day">
            <div class="home-weather-day-title">
                <a>今日天气</a>
            </div>
            <div class="home-weather-day-info">
                <div class="home-weather-day-info-row" style="width:40%;">
                    <p class="weather-icon"><i class="el-icon-sunny"></i></p>
                    <p class="weather-tempurate">28℃</p>
                </div>
                <div class="home-weather-day-info-row" style="width:60%;text-align:left;">
                    <p class="weather-text">{{LocationCity}}</p>
                    <p class="weather-text">今日天气指数</p>
                    <p class="weather-text">28~32℃</p>
                    <p class="weather-text">微风</p>
                    <p class="weather-text">晴</p>
                </div>
            </div>
        </div>
        <div class="home-weather-day">
            <div class="home-weather-day-title">
                <a>明日天气</a>
            </div>
            <div class="home-weather-day-info">
                <div class="home-weather-day-info-row" style="width:40%;">
                    <p class="weather-icon"><i class="el-icon-sunny"></i></p>
                    <p class="weather-tempurate">28℃</p>
                </div>
                <div class="home-weather-day-info-row" style="width:60%;text-align:left;">
                    <p class="weather-text">{{LocationCity}}</p>
                    <p class="weather-text">今日天气指数</p>
                    <p class="weather-text">28~32℃</p>
                    <p class="weather-text">微风</p>
                    <p class="weather-text">晴</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import BMap from 'BMap'
import global_ from '@/global/global.vue';
import $ from 'jquery'
export default {
    data(){
        return{
            LocationCity:"正在定位",
        }
    },
    mounted(){
        // this.city();    //触发获取城市方法
        this.getWeather();//调用国家气象局接口获取天气数据
    },
    methods:{
        city(){    //定义获取城市方法
            var geolocation = new BMap.Geolocation();
            var _this = this
            geolocation.getCurrentPosition(function getinfo(position){
                let city = position.address.city;             //获取城市信息
                let province = position.address.province;    //获取省份信息
                _this.LocationCity = city
            }, function(e) {
                _this.LocationCity = "定位失败"
            }, {provider: 'baidu'});		
        },
        getWeather(){
            this.$axios.get('/101220101').then((response)=>{
                console.log('weather-------------',response);
            }).catch((response)=>{
                console.log(response);
            })
        }
    }
}
</script>

<style scoped>
.weather-container{
    width: 100%;
    height: 100%;
    position: relative;
}
.home-weather-day{
    width: 50%;
    height: 100%;
    float: left;
}
.home-weather-day-title{
    width: 100%;
    height: 30px;
    color: #fff;
    font-size: 10px;
}
.home-weather-day-title a{
    display: block;
    width: 60px;
    text-align: center;
    line-height: 20px;
    height: 20px;
    margin: 0 auto;
    background-color: #fc0;
    border-radius: 5px;
}
.home-weather-day-info{
    width: 100%;
    height: calc(100% - 30px);
}
.home-weather-day-info-row{
    text-align: center;
    width: 50%;
    height: 100%;
    float: left;
}
.weather-icon{
    color: #fff;
    font-size: 48px;
}
.weather-tempurate{
    color: #fff;
    font-size: 18px;
}
.weather-text{
    color: #fff;
    font-size: 14px;
    line-height: 20px;
}
</style>

<template>
    <div class="weather-container">
        <div class="home-weather-day">
            <div class="home-weather-day-title">
                <a>今日天气</a>
            </div>
            <div class="home-weather-day-info">
                <div class="home-weather-day-info-row" style="width:40%;">
                    <p class="weather-icon"><i :class="weahterToday.icon"></i></p>
                    <p class="weather-tempurate">{{weahterToday.type}}</p>
                </div>
                <div class="home-weather-day-info-row" style="width:60%;text-align:left;">
                    <p class="weather-text">{{LocationCity}}</p>
                    <!-- <p class="weather-text">今日天气指数</p> -->
                    <p class="weather-text">{{weahterToday.low}} ~ {{weahterToday.high}}</p>
                    <p class="weather-text">{{weahterToday.fx}} ~ {{weahterToday.fl}}</p>
                    <p class="weather-text" style="font-size:10px;">{{weahterToday.notice}}</p>
                </div>
            </div>
        </div>
        <div class="home-weather-day">
            <div class="home-weather-day-title">
                <a>明日天气</a>
            </div>
            <div class="home-weather-day-info">
                <div class="home-weather-day-info-row" style="width:40%;">
                    <p class="weather-icon"><i :class="weahterTomorrow.icon"></i></p>
                    <p class="weather-tempurate">{{weahterTomorrow.type}}</p>
                </div>
                <div class="home-weather-day-info-row" style="width:60%;text-align:left;">
                    <p class="weather-text">{{LocationCity}}</p>
                    <!-- <p class="weather-text">明日天气指数</p> -->
                    <p class="weather-text">{{weahterTomorrow.low}} ~ {{weahterTomorrow.high}}</p>
                    <p class="weather-text">{{weahterTomorrow.fx}} ~ {{weahterTomorrow.fl}}</p>
                    <p class="weather-text" style="font-size:10px;">{{weahterTomorrow.notice}}</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import BMap from 'BMap'
import _global from '@/global/global.vue';
import $ from 'jquery'
export default {
    data(){
        return{
            LocationCity:"正在定位",
            //天气
            weahterToday:{
                type:'',//晴、阴......
                low:'',//低温
                high:'',//高温
                fx:'',//风向
                fl:'',//风力
                notice:'',
                icon:''
            },
            weahterTomorrow:{
                type:'',//晴、阴......
                low:'',//低温
                high:'',//高温
                fx:'',//风
                fl:'',//风力
                notice:'',
                icon:''
            }
        }
    },
    mounted(){
        this.city();    //触发获取城市方法
        // this.getWeather();//调用国家气象局接口获取天气数据
    },
    methods:{
        city(){    //定义获取城市方法
            var geolocation = new BMap.Geolocation();
            var _this = this
            geolocation.getCurrentPosition(function getinfo(position){
                let city = position.address.city;             //获取城市信息
                let province = position.address.province;    //获取省份信息
                console.log(position.address);
                _this.LocationCity = city

                _this.getWeather(city);

            }, function(e) {
                _this.LocationCity = "定位失败"
            }, {provider: 'baidu'});		
        },

        //匹配天气图标
        getWeatherIcon(weatherStr){
            if(weatherStr.indexOf('阴') != -1){
                return 'el-icon-cloudy';
            }
            if(weatherStr.indexOf('晴') != -1){
                return 'el-icon-sunny';
            }
            if(weatherStr.indexOf('雨') != -1){
                return 'el-icon-heavy-rain';
            }
            if(weatherStr.indexOf('雪') != -1){
                return 'el-icon-light-rain';
            }
            if(weatherStr.indexOf('暴') != -1){
                return 'el-icon-lightning';
            }
            if(weatherStr.indexOf('云') != -1){
                return 'el-icon-cloudy-and-sunny';
            }
        },

        //接口调用获取天气信息
        getWeather(city){
            var params = new URLSearchParams();
            params.append('city', city);
            this.$axios({method:'post',url: _global.requestUrl+'/api/proxy/v1/getWeather', data: params})
                .then((response)=>{
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        console.log(res.data);
                        var forecastList = res.data.data.forecast;
                        this.weahterToday.type = forecastList[0].type;
                        this.weahterToday.low = forecastList[0].low.replace('低温 ','');
                        this.weahterToday.high = forecastList[0].high.replace('高温 ','');
                        this.weahterToday.fx = forecastList[0].fx;
                        this.weahterToday.fl = forecastList[0].fl;
                        this.weahterToday.notice = forecastList[0].notice;
                        this.weahterToday.icon = this.getWeatherIcon(forecastList[0].type);

                        this.weahterTomorrow.type = forecastList[1].type;
                        this.weahterTomorrow.low = forecastList[1].low.replace('低温 ','');
                        this.weahterTomorrow.high = forecastList[1].high.replace('高温 ','');
                        this.weahterTomorrow.fx = forecastList[1].fx;
                        this.weahterTomorrow.fl = forecastList[1].fl;
                        this.weahterTomorrow.notice = forecastList[1].notice;
                        this.weahterTomorrow.icon = this.getWeatherIcon(forecastList[1].type);  
                    }else{
                        console.log(res.data);
                        this.$alert(res.msg,'提示',{
                            confirmButtonText: '确定',
                            customClass: 'message-logout'
                        });
                    }
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

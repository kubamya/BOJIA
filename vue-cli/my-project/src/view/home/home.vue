<template>
    <div class="home-container">
        <div class="home-head-container">
            <div class="home-head-bar">
                <!-- <div class="home-head-more" @click="openMore()"><i class="el-icon-s-operation"></i></div> -->
                <!-- <div class="home-head-more" ><i class="el-icon-s-operation"></i></div> -->
                <div class="home-head-title">首页</div>
                <div class="home-head-select">
                    <el-select v-model="value" placeholder="请选择">
                        <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                    </el-select>
                </div>
            </div>
            <div class="home-weather">
                <weatherCom></weatherCom>
            </div>
        </div>
        <div class="home-meter">
            <meterCom :devId="value"></meterCom>
        </div>
        <div class="home-info">
            <homeInfoCom></homeInfoCom>
        </div>

        <el-drawer
            title="首页更多"
            :visible.sync="drawer"
            :show-close="false"
            :direction="direction">
            <span>暂无内容</span>
        </el-drawer>

    </div>
</template>
<script>
import _global from '@/global/global.vue'
import weather from '@/components/weather.vue';
import meter from '@/components/meter.vue';
import homeInfo from '@/components/homeInfo.vue';
export default {
    components:{
        weatherCom: weather,
        meterCom: meter,
        homeInfoCom: homeInfo
    },
    data(){
        return {
            value:'',
            options: [],

            //抽屉
             drawer: false,
             direction: 'ltr',
        }
    },
    mounted(){
        this.getDevByUserId();
        
    },
    methods:{
        getDevByUserId(){
            var params = new URLSearchParams();
            params.append('userId', this.$handleLocalStorage('get','userid'));

            this.$axios({method:'post',url: _global.requestUrl+'/api/device/v1/getDevByUserId', data: params})
                .then(response => {
                    var res = this.$handleRes(response);

                    if(res.code == 100){
                        this.options = res.data;
                        this.value = this.options[0].value;
                    }else{
                        this.$message({
                            message: res.msg,
                            type: 'warning'
                        });
                    }
                });
        },
        openMore(){
            this.drawer = true;
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
    height: 200px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
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
    z-index: 666;
}
.home-head-more i{
    color: #fff;
    font-size: 24px;
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
    height: 25px;
    line-height: 25px;
    background-color: #409Eff;
    color: #fff;
}
.home-weather{
    width: 100%;
    height: calc(100% - 50px);
    position: relative;
}
.home-meter{
    width: 100%;
    height: 230px;
    /* position: absolute;
    bottom: 50px; */
    box-sizing: border-box;
    border-top: 1px solid #eee;
}
.home-info{
    background-color: #fff;
    width: 100%;
    height: calc(100% - 430px);
    /* position: absolute;
    top: 200px; */
    overflow-y: auto;
}
.el-drawer ltr{
    width: 80% !important;
}
</style>

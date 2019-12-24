<template>
    <div class="main-container">
        <div class="main-content">
            <router-view/>
        </div>
        <div class="main-footer">
            <div class="nav-container">
                <div class="nav-item" @click="navItemClick(1, '/home')">
                    <i class="el-icon-house" :style="style1_i"></i><br>
                    <a :style="style1_a">首页</a>
                </div>
                <div class="nav-item" @click="navItemClick(2, '/manu')">
                    <i class="el-icon-thumb" :style="style2_i"></i><br>
                    <a :style="style2_a">手动</a>
                </div>
                <div class="nav-item" @click="navItemClick(3, '/auto')">
                    <i class="el-icon-cpu" :style="style3_i"></i><br>
                    <a :style="style3_a">自动</a>
                </div>
                <div class="nav-item" @click="navItemClick(4, '/mine') ">
                    <i class="el-icon-user" :style="style4_i"></i><br>
                    <a :style="style4_a">我的</a>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
// import mainNav from '@/components/nav.vue'
export default {
    // components:{
    //     mainNav
    // },
    data(){
        return {
           style1_i:{
                fontSize:'16px',
                color:'#409EFF'
            },
            style1_a:{
                fontSize:'12px',
                color:'#409EFF'
            },
            style2_i:{
                fontSize:'16px',
                color:'#666'
            },
            style2_a:{
                fontSize:'12px',
                color:'#666'
            },
            style3_i:{
                fontSize:'16px',
                color:'#666'
            },
            style3_a:{
                fontSize:'12px',
                color:'#666'
            },
            style4_i:{
                fontSize:'16px',
                color:'#666'
            },
            style4_a:{
                fontSize:'12px',
                color:'#666'
            },
        }
    },
    mounted(){
        this.$router.push({path: '/home'});
    },
    methods:{
        //导航栏项目点击时方法
        navItemClick(itemId, url){
            this.initNavItemColor();
            switch(itemId){
                case 1:
                    this.style1_i.color = '#409EFF';
                    this.style1_a.color = '#409EFF';                    
                    break;
                case 2:
                    this.style2_i.color = '#409EFF';
                    this.style2_a.color = '#409EFF';
                    break;
                case 3:
                    this.style3_i.color = '#409EFF';
                    this.style3_a.color = '#409EFF';
                    break;
                case 4:
                    this.style4_i.color = '#409EFF';
                    this.style4_a.color = '#409EFF';
                    break;                
            }
            this.$router.push({path: url});
        },
        //初始化菜单颜色
        initNavItemColor(){
            this.style1_i.color = '#666';
            this.style1_a.color = '#666';
            this.style2_i.color = '#666';
            this.style2_a.color = '#666';
            this.style3_i.color = '#666';
            this.style3_a.color = '#666';
            this.style4_i.color = '#666';
            this.style4_a.color = '#666';
        }
    }
}
</script>
<style scoped>
.main-container{
    width: 100%;
    height: 100%;
}
.main-content{
    width: 100%;
    height: calc(100% - 50px);
}
.main-footer{
    width: 100%;
    height: 50px;
    position: fixed;
    bottom: 0;
    box-sizing: border-box;
    border-top: 1px solid #eee;
}
.nav-container{
    width: 100%;
    height: 100%;
    background-color: #f1f1f1;
}
.nav-item{
    width: 25%;
    height: 100%;
    text-align: center;
    float: left;
}
</style>

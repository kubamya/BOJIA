<template>
    <div class="nav-container">
        <div class="nav-item" @click="navItemClick(1,'http://www.baidu.com')">
            <i class="el-icon-house" :style="style1_i"></i><br>
            <a :style="style1_a">首页</a>
        </div>
        <div class="nav-item" @click="navItemClick(2)">
            <i class="el-icon-thumb" :style="style2_i"></i><br>
            <a :style="style2_a">手动</a>
        </div>
        <div class="nav-item" @click="navItemClick(3)">
            <i class="el-icon-cpu" :style="style3_i"></i><br>
            <a :style="style3_a">自动</a>
        </div>
        <div class="nav-item" @click="navItemClick(4)">
            <i class="el-icon-user" :style="style4_i"></i><br>
            <a :style="style4_a">我的</a>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            style1_i:{
                fontSize:'16px',
                color:'#666'
            },
            style1_a:{
                fontSize:'12px',
                color:'#666'
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
    methods:{
        //导航栏项目点击时方法
        navItemClick(itemId, url){
            this.initNavItemColor();
            switch(itemId){
                case 1:
                    this.style1_i.color = '#409EFF';
                    this.style1_a.color = '#409EFF';
                    this.$router.push({path: url});
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
.nav-container{
    width: 100%;
    height: 100%;
}
.nav-item{
    width: 25%;
    height: 100%;
    text-align: center;
    float: left;
}
/* .nav-item i{
    font-size: 16px;
    color: #666;
}
.nav-item a{
    font-size: 14px;
    color: #666;
} */
</style>

<template>
    <div>
        <el-button @click="test()">测试</el-button>
        <div v-for="item in t1" :key="item.id">
            {{item.name}}
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            t1:[
                {id:1,name:2}
            ]
        }
    },
    methods:{
        test(){
            this.t1.push({id:2, name:3});
        }
    }
}
</script>


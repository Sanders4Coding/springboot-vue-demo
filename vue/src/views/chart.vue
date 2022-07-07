<template>
<!--    echarts容器默认宽高为零，不设置不显示-->
    <div ref="myChart" id="demoDiv"></div>
</template>

<script>
    //1.全局引入Echarts
    import * as echarts from 'echarts'
    export default {
        mounted() {
            let myEcharts = echarts.init(this.$refs.myChart)
            // 设置参数
            myEcharts.setOption({
                title:{//echarts标题
                    text:'helloWorld'
                },
                xAxis:{//坐标轴
                    data:["EZ","VN","NOC","MF"]
                },
                yAxis:{},
                series:{//系列
                    name:"lol英雄",
                    type:"bar",//柱状图
                    data:[6300,4800,3200,600]
                }

            })
        }
    }
</script>

<style scoped>
    #demoDiv{
        width: 1300px;
        height: 400px;
        border:1px solid springgreen;
    }
</style>
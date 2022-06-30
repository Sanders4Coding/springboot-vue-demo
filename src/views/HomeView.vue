<template>
    <div style="padding: 10px">
        <!--      功能区域-->
        <div style="margin: 10px 0">
            <el-button type="primary" size="small">新增</el-button>
            <el-button type="primary" size="small">导入</el-button>
            <el-button type="primary" size="small">导出</el-button>
        </div>
        <!--      搜索区域-->
        <div style="margin: 10px 0">
            <el-input v-model="search" placeholder="键入关键字" style="width: 20%" size="small"></el-input>
            <el-button type="primary" size="small" style="margin-left: 5px">查询</el-button>

        </div>
        <!--        表格-->
        <el-table :data="tableData" stripe border style="width: 100%" size="small">
            <el-table-column prop="date" label="日期"/>
            <el-table-column prop="name" label="姓名"/>
            <el-table-column prop="degree" label="学位"/>
            <el-table-column prop="address" label="授予单位"/>
            <el-table-column fixed="right" label="操作">
                <template #default>
                    <el-button link type="primary" size="small" @click="handleEdit">
                        编辑
                    </el-button>
                    <el-popconfirm title="你确定这么做吗?此操作无法恢复!">
                        <template #reference>
                            <el-button type="danger" size="small">删除</el-button>
                        </template>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
        <!--        分页-->
        <div style="margin: 10px 0">
            <el-pagination
                    v-model:currentPage="currentPage"
                    v-model:page-size="pageSize"
                    :page-sizes="[5, 10, 15, 20]"
                    :small="small"
                    :disabled="disabled"
                    :background="background"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
            />
        </div>
    </div>
</template>

<script>
    import {ref} from 'vue'
    const currentPage = ref(1)
    const pageSize = ref(1)
    const small = ref(true)
    const background = ref(true)
    const disabled = ref(true)

    export default {
        name: 'HomeView',
        components: {},
        methods: {
            handleEdit() {
                console.log('编辑被点击了')
            },
            handleSizeChange(){
                // 几条每页改变执行
                console.log('handleSizeChange called')
            },
            handleCurrentChange(){
                //改变页码执行
                console.log('handleCurrentChange called')
            }
        },
        data() {
            return {
                total: 6,
                search: '',
                tableData: [
                    {
                        date: '2022-07-01',
                        name: '田杰',
                        degree: 'Bachelor\'s degree',
                        address: 'NUC, No. 3, College St, Tai Yuan',
                    },
                    {
                        date: '2022-07-01',
                        name: '荆常颉',
                        degree: 'Bachelor\'s degree',
                        address: 'NUC, No. 3, College St, Tai Yuan',
                    },
                    {
                        date: '2022-07-01',
                        name: '赵品一',
                        degree: 'Bachelor\'s degree',
                        address: 'NUC, No. 3, College St, Tai Yuan',
                    },
                    {
                        date: '2022-07-01',
                        name: '邓恩夏',
                        degree: 'Bachelor\'s degree',
                        address: 'NUC, No. 3, College St, Tai Yuan',
                    },
                    {
                        date: '2022-07-01',
                        name: '郝海波',
                        degree: 'Bachelor\'s degree',
                        address: 'NUC, No. 3, College St, Tai Yuan',
                    },{
                        date: '2022-07-01',
                        name: '赵子博',
                        degree: 'Bachelor\'s degree',
                        address: 'NUC, No. 3, College St, Tai Yuan',
                    },
                ]
            }
        }
    }

</script>

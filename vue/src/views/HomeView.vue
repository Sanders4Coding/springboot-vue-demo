<template>
    <div style="padding: 10px">
        <!--      功能区域-->
        <div style="margin: 10px 0">
            <el-button type="primary" @click="add">新增</el-button>
            <el-button type="primary">导入</el-button>
            <el-button type="primary">导出</el-button>
        </div>
        <!--      搜索区域-->
        <div style="margin: 10px 0">
            <el-input v-model="search" placeholder="键入关键字" style="width: 20%" clearable></el-input>
            <el-button type="primary" style="margin-left: 5px" @click="load">查询</el-button>

        </div>
        <!--        表格-->
        <el-table
                :data="tableData"
                :cell-style="{'text-align':'center'}"
                :header-cell-style="{'text-align':'center'}"
                stripe border
                style="width: 100%;"
                fit>
            <el-table-column prop="id" label="编号" sortable/>
            <el-table-column prop="userName" label="用户名"/>
            <el-table-column prop="nickName" label="昵称"/>
            <el-table-column prop="age" label="年龄"/>
            <el-table-column prop="sex" label="性别"/>
            <el-table-column prop="address" label="地址"/>
            <el-table-column fixed="right" label="操作">
                <template #default="scope">
                    <el-button type="primary" @click="handleEdit(scope.row)">
                        编辑
                    </el-button>
                    <el-popconfirm title="你确定这么做吗?此操作无法恢复!" @confirm="handleDelete(scope.row.id)">
                        <template #reference>
                            <el-button type="danger">删除</el-button>
                        </template>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
        <!--        分页-->
        <div style="margin: 10px 0">
            <el-pagination
                    v-model:currentPage="pageInfo.pageNum"
                    :page-size="pageInfo.pageSize"
                    :page-sizes="[10, 20, 50]"
                    :total="total"
                    :small="small"
                    :disabled="disabled"
                    :background="background"
                    layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
            />
            <!--            弹窗-->
            <el-dialog v-model="dialogVisible" title="新增用户" width="30%">
                <el-form :model="form" label-width="120px">
                    <el-form-item label="用户名">
                        <el-input v-model="form.userName" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item label="昵称">
                        <el-input v-model="form.nickName" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item label="年龄">
                        <el-input v-model="form.age" style="width: 80%"></el-input>
                    </el-form-item>
                    <el-form-item label="性别">
                        <el-radio v-model="form.sex" label="男">男</el-radio>
                        <el-radio v-model="form.sex" label="女">女</el-radio>
                        <el-radio v-model="form.sex" label="未知">Unknown</el-radio>
                    </el-form-item>
                    <el-form-item label="地址">
                        <el-input type="textarea" v-model="form.address" style="width: 80%"></el-input>
                    </el-form-item>
                </el-form>
                <template #footer>
                <span class="dialog-footer">
                <el-button type="danger" @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click="save">确定</el-button>
      </span>
                </template>
            </el-dialog>
        </div>
<!--        图表-->
        <echart/>

    </div>
</template>

<script>
    import {ref} from 'vue'
    import request from "../../utils/request";
    import axios from 'axios'
    import chart from "@/views/chart";


    const small = ref(true)
    const background = ref(true)
    const disabled = ref(true)
    const url = "http://192.168.2.2:8081"

    export default {
        name: 'HomeView',
        components: {
            "echart":chart
        },
        created() {
            this.load()
        },
        methods: {
            load() {
                axios.get(url + "/user", {
                    params: {
                        pageNum: this.pageInfo.pageNum,
                        pageSize: this.pageInfo.pageSize,
                        search: this.search
                    }
                }).then(res => {
                    console.log(res)
                    this.tableData = res.data.data.records
                    this.total = res.data.data.total
                })
            },
            save() {
                //form有id为更新，否则为新增
                if (this.form.id) {
                    axios.put(url + "/user", this.form).then(res => {
                        console.log(res)
                        if (res.data.code === '0') {
                            this.$message({
                                type: 'success',
                                message: '修改成功',
                                showClose: true
                            })
                            this.dialogVisible = false
                            this.load()
                        } else {
                            this.$message({
                                type: "error",
                                message: '发生了未知错误：' + res.data.msg,
                            })
                        }
                    })
                } else {
                    // 传数据到后台
                    console.log(this.form)
                    request.post(url + "/user", this.form).then(res => {
                        console.log(res)
                        this.$message.success("添加成功")
                        this.dialogVisible = false
                        this.load()
                    })
                }
            },
            add() {
                console.log('新增被点击了')
                this.dialogVisible = true
                this.form = {}
            },
            handleDelete(id){
                axios.delete(url+"/user/"+id).then(res=>{
                    console.log(res)
                    if(res.data.code==="0"){
                        this.$message.success('删除成功')
                        this.load()
                    }else{
                        this.$message.error('未知错误'+res.data.msg)
                        this.load()
                    }
                })
            },
            handleEdit(row) {
                console.log('编辑被点击了')
                this.form = JSON.parse(JSON.stringify(row))
                this.dialogVisible = true
            },
            handleSizeChange(newSize) {
                // 几条每页改变执行
                console.log('handleSizeChange called')
                this.pageInfo.pageSize = newSize
                this.load()
            },
            handleCurrentChange(newPage) {
                //改变页码执行
                console.log('handleCurrentChange called')
                this.pageInfo.pageNum = newPage
                this.load()
            }
        },
        data() {
            return {
                pageInfo: {
                    pageNum: 1,
                    pageSize: 10
                },
                search: '',
                form: {},
                dialogVisible: false,
                total: 0,
                tableData: []
            }
        }
    }

</script>

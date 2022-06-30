<template>
    <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
        <div style="width: 200px;padding-left: 30px;font-weight: bold;color: dodgerblue">后台管理</div>
        <div style="flex: 1"></div>
        <div style="width: 100px;display: flex">
            <el-dropdown style="align-self: center">
                <span class="el-dropdown-link">
                    杰哥
                    <el-icon class="el-icon--right">
                        <arrow-down/>
                    </el-icon>
                </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item>个人信息</el-dropdown-item>
                        <el-dropdown-item divided>退出系统</el-dropdown-item>
<!--                        保留两种写法以后使用-->
<!--                        <el-dropdown-item disabled>Action 4</el-dropdown-item>-->
<!--                        <el-dropdown-item divided>Action 5</el-dropdown-item>-->
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
    import { ArrowDown } from '@element-plus/icons-vue'

    export default {
        name: "",
        components:{
            'arrow-down':ArrowDown
        }
    }

</script>

<style scoped>
    .el-dropdown-link {
        cursor: pointer;
        color: var(--el-color-primary);
        display: flex;
        align-items: center;
    }
</style>
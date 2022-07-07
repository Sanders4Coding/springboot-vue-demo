<template>
    <div>
        <el-menu
                style="width: 200px;min-height: calc(100vh - 50px)"
                active-text-color="#ffd04b"
                background-color="#545c64"
                class="el-menu-vertical-demo"
                default-active="user"
                router
                text-color="#fff">
            <!--                @open="handleOpen"-->
            <!--                @close="handleClose"-->
            <!--        >-->

            <el-sub-menu index="1">
                <template #title>系统管理</template>
                <el-menu-item index="home">用户管理</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="chart">数据管理</el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    import {
        Document,
        Menu as IconMenu,
        Location,
        Setting,
    } from '@element-plus/icons-vue'

    export default {
        name: "",
        components: {
            Document, IconMenu, Location, Setting
        }
    }
</script>

<style scoped>

</style>
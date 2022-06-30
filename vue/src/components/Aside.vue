<template>
    <div>
        <el-menu
                style="width: 200px;min-height: calc(100vh - 50px)"
                active-text-color="#ffd04b"
                background-color="#545c64"
                class="el-menu-vertical-demo"
                default-active="2"
                text-color="#fff">
<!--                @open="handleOpen"-->
<!--                @close="handleClose"-->
<!--        >-->

            <el-sub-menu index="1">
                <template #title>item one</template>
                <el-menu-item index="1-4-1">item one-one</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="2">
                <el-icon><icon-menu /></el-icon>
                <span>导航 Two</span>
            </el-menu-item>
            <el-menu-item index="3" disabled>
                <el-icon><document /></el-icon>
                <span>导航 Three</span>
            </el-menu-item>
            <el-menu-item index="4">
                <el-icon><setting /></el-icon>
                <span>导航 Four</span>
            </el-menu-item>
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
        components:{
            Document,IconMenu,Location,Setting
        }
    }
</script>

<style scoped>

</style>
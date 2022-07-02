<template>
    <div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow: hidden">
        <div style="width: 400px;margin: 150px auto">
            <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 30px 0">
                欢迎登录
            </div>
            <el-form ref="form" :model="form" size="normal">
                <el-form-item>
                    <el-input prefix-icon="avatar" v-model="form.username"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-input prefix-icon="lock" v-model="form.password" show-password></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" style="width: 100%" @click="login">
                        登录
                    </el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>

    import {Avatar, Lock} from "@element-plus/icons-vue";
    import axios from "axios";
    const url = "http://192.168.2.2:8081"
    export default {
        name: "",
        methods:{
            login(){
                axios.post(url+"/user/login",this.form).then(res=>{
                    console.log(res)
                    // this.$router.push("/") 页面跳转
                })
            }
        },
        data() {
            return {
                form: {}
            }
        },
        component:{
            'avatar':Avatar,
            'lock':Lock
        }
    }
</script>

<style scoped>

</style>
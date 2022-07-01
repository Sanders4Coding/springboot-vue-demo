// 封装axios
import axios from 'axios'

const request = axios.create({
    timeout: 5000
})

// request拦截器，可以在请求发送前对请求做点处理
request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8'
    return config
}, error => {
    return Promise.reject(error)
})

// response拦截器，在接口响应后统一处理结果
request.interceptors.response.use(
    response => {
        let res = response.data
        // 如果返回的是文件
        if (response.config.responseType === 'bolb') {
            return res
        }
        if (typeof res === 'string') {
            res = res ? JSON.parse(res) : res
        }
    }, error => {
        console.log('error' + error)
        return Promise.reject(error)
    }
)

export default request
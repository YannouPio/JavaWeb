import axios from "axios";
import {getToken} from '@/utils/auth'

let baseUrl = "/dev-api"
const request = axios.create({
    baseURL: baseUrl,
    timeout: 10000
})

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
//请求拦截器
request.interceptors.request.use(config => {
    // 是否需要设置 token
    const isToken = (config.headers || {}).isToken === false
    if (getToken() && !isToken) {
        config.headers['Authorization'] = 'Bearer ' + getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
    }
    return config;
}, error => {
    Promise.reject(error)
})

// 响应拦截器
request.interceptors.response.use(response => {
    return Promise.resolve(response.data)
})

export default request;
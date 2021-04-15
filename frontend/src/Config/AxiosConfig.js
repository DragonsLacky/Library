import axios from "axios";

const axios_instance = axios.create({
    baseURL: 'http://localhost:5000/api',
    headers: {
        'Access-Control-Alloy-Origin' : '*'
    }
})

export default axios_instance;
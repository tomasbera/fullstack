import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import './assets/main.css'
import store from "@/stores/store";

const app = createApp(App)
    .use(createPinia())
    .use(router)
    .use(store)
    .mount('#app')

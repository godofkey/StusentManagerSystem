// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import store from './vuex/store.js'

//axios
import Axios from 'axios'
import Vueaxios from 'vue-axios';
Vue.prototype.Axios=Axios


import 'element-ui/lib/theme-chalk/index.css';

// import './assets/css/basic.scss'

Vue.config.productionTip = false

Vue.use(ElementUI);

Vue.use(Vueaxios,Axios);



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  
  components: { App },
  template: '<App/>'
})

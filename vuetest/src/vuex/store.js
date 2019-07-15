import Vuex from 'vuex'

import Vue from 'vue'

Vue.use(Vuex);

//里面放属性
var state={

    count:1
}

//放方法，主要改变state的数据
var mutations={

    ChangeName(a,b){
        a.count=b;
    }
}

const store = new Vuex.Store({
    state,
    mutations

})

export default store;
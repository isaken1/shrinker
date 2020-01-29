import Vue from "vue";
import Vuex from "vuex";

import { authentication } from "@/store/authentication";
import { alert } from "@/store/alert";

Vue.use(Vuex);

export const store = new Vuex.Store({
  modules: {
    authentication,
    alert
  }
});

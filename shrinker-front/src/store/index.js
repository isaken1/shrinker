import Vue from "vue";
import Vuex from "vuex";

import { authentication } from "@/store/authentication";
import { alert } from "@/store/alert";
import { userSignup } from "@/store/userSignup";
import { urlHelper } from "@/store/urlHelper";

Vue.use(Vuex);

export const store = new Vuex.Store({
  modules: {
    authentication,
    alert,
    userSignup,
    urlHelper
  }
});

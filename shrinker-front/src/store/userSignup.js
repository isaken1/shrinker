import { userService } from "@/helper/user_service";
import { router } from "@/router";

export const userSignup = {
  namespaced: true,
  state: {
    status: {},
    user: null
  },
  actions: {
    signUp({ dispatch, commit }, { nome, senha, email }) {
      commit("signUpRequest", { email, nome });

      userService.newUser(email, senha, nome).then(
        user => {
          commit("signUpSuccess", user);
          router.replace("/");
        },
        error => {
          commit("signUpFail", error);
          dispatch("alert/error", error, { root: true });
        }
      );
    }
  },
  mutations: {
    signUpRequest(state, user) {
      state.status = { signingUp: true };
      state.user = user;
    },
    signUpSuccess(state, user) {
      state.status = { signedUp: true };
      state.user = user;
    },
    signUpFail(state) {
      state.status = {};
      state.user = null;
    }
  }
};

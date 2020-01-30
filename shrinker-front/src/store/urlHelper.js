import { urlService } from "@/helper/url_service";

const initialState = { status: {}, data: [], latest: {} };

export const urlHelper = {
  namespaced: true,
  state: initialState,
  actions: {
    getAll({ commit, dispatch }) {
      commit("getAllRequest");

      urlService.fetchAll().then(
        urls => commit("getAllSuccess", urls),
        error => {
          commit("insertNewUrlFailure", error);
          dispatch("alert/error", error, { root: true });
        }
      );
    },
    insertNewUrl({ commit }, url) {
      commit("insertNewUrlRequest");
      urlService.insert(url).then(
        response => {
          commit("insertNewUrlSuccess", response);
        },
        error => {
          commit("insertNewUrlFailure", error);
        }
      );
    }
  },
  mutations: {
    getAllRequest(state) {
      state.status = { fetching: true };
    },
    getAllSuccess(state, urls) {
      state.status = {};
      state.data = urls;
    },
    getAllFailure(state, error) {
      state.status = { error };
    },
    insertNewUrlRequest(state) {
      state.status = { inserting: true };
    },
    insertNewUrlSuccess(state, url) {
      state.status = {};
      state.latest = { url };
    },
    insertNewUrlFailure(state, error) {
      state.status = { error: error };
    }
  }
};

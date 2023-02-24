import { createStore } from 'vuex'

export default createStore({
  state: {
    log: [],
    feedback: {
      recentEmail: '',
      recentName: '',
    }
  },
  mutations: {
    ADD_TO_LOG(state, newLog){
      state.log = newLog;
    },

    CLEAR_LOG(state){
      state.log = [];
    },

    SET_RECENT_INFO(state, info){
      state.feedback.recentName = info.name;
      state.feedback.recentEmail = info.email;
    },
  },
  actions: {
    addToLog( {commit}, solution) {
      return commit(`ADD_TO_LOG`, solution);
    },

    clearLog( {commit}) {
      return commit(`CLEAR_LOG`);
    },

    savedRecentInfo( { commit }, info) {
      commit("SET_RECENT_INFO", info)
    },
  },
  modules: {}
})
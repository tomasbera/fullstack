<template>
  <div class="wrapper">
    <nav>
      <RouterLink to="/about">About</RouterLink>
      <RouterLink to="/feedback">Feedback</RouterLink>
      <RouterLink v-if="LoggedIn" to="/calc">Calc</RouterLink>
      <RouterLink to="login" id="logout" v-if="loggedIn" @click="logout">Logout</RouterLink>
    </nav>
  </div>
  <RouterView />
</template>

<script>
import { RouterLink, RouterView } from 'vue-router'
import store from "@/stores/store";
import {watchEffect} from "vue";
import { useStorage } from 'vue3-storage';

export default {
  setup() {
    let loggedIn = store.state.credentials.token !== ''
    const storage = useStorage();

    watchEffect(() => {
      loggedIn = store.state.credentials.token !== ''
    });

    const logout = () => {
      store.commit('setToken', '');
      store.commit('setUsername', '');
      storage.removeStorageSync('token');
      storage.removeStorageSync('username');
    };

    return {
      loggedIn,
      store,
      logout,
    };
  }
}
</script>

<style scoped>

</style>
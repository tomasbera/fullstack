<template>
  <div id="loginContainer">
    <h1>Please login!</h1>
    <fieldset>
      <div id="info">
        <legend>Enter Your Username</legend>
        <BasicInput
            id="username"
            label="username"
            type="Username"
            v-model="username"
        />
        <legend>Enter Your Password</legend>
        <BasicInput
            id="password"
            label="Password"
            type="password"
            v-model="password"
        />
      </div>
      <button
          id="submit_button"
          class="-fill-gradient"
          v-on:click="handleLoginClick()"
      >
        Sign in
      </button>
      <label id="loginstatusLabel">{{ loginStatus }}</label>
    </fieldset>
  </div>
</template>

<script>
import router from '@/router';
import axios from "axios";
import BasicInput from "@/components/BasicInput.vue";
export default {
  name: "LoginForm",
  components: {BasicInput},
  methods: {
    handleLoginClick() {
      axios.get("http://localhost:3000/login").then(response => {
        if(response.data.status === "true"){
          router.push("/calc");
        }
      })
    },
  },
  data() {
    return {
      username: "",
      password: "",
      loginStatus: "",
    };
  },
};
</script>

<style scoped>

#loginContainer {
  display: grid;
  justify-content: center;
  margin: 40px;
}

#password {
  display: flex;
  flex-direction: row;
  align-items: center;
  column-gap: 20px;
}

h1{
  padding: 10px;
}

legend {
  padding: 15px
}

#info{
  padding: 10px;
}

BasicInput {
  padding: 10px;
}

button {
  border-width: 2px;
  padding-left: 12px;
  padding-right: 12px;
  background-color: rgb(30 41 59);
  color: white;
}

button:active{
  background-color: white;
  color: rgb(30 41 59);
}

button:disabled {
  opacity: 0.5;
}

button:hover{
  background-color: white !important;
  color: rgb(30 41 59) !important;
}

legend {
  padding: 20px;
}

BasicInput {
  padding: 10px;
}

form {
  padding-top: 20px;
  background-color: #f0f0f0;
  padding-bottom: 20px;
  border-radius: 8px;
}


</style>

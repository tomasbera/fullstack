<template>
  <h1>Authorization</h1>
  <form name="login-form" role="form" @submit="submit">
    <fieldset>
      <legend>Registration & Login</legend>
      <div>
        <label for="nameInput">Username</label>
        <BasicInput
            id="nameInput"
            type="text"
            v-model="username"
            :error="errors.username"
              autocomplete="username"
        />
        <label for="passwordInput">Password</label>
        <BasicInput
            id="passwordInput"
            type="password"
            v-model="password"
            :error="errors.password"
        />
      </div>
      <button
          id="submit_button"
          :disabled="hasErrors"
          type="submit"
          class="-fill-gradient"
      >
        Register
      </button>
      <button
          id="login_button"
          :disabled="hasErrors"
          type="button"
          class="-outlined"
          @click="login()"
      >
        Login
      </button>
    </fieldset>
  </form>
  <h2 v-if="submitMessage" id="submit-message" aria-describedby="login-form">{{ submitMessage }}</h2>
</template>

<script>
import BasicInput from "@/components/BasicInput.vue";
import * as yup from 'yup'
import {useField, useForm } from "vee-validate";
import store from "@/stores/store";
import {ref} from "vue";
import router from '@/router';
import {loginUser, registerUser} from "@/services/Authenticator";
import { useStorage } from 'vue3-storage';


export default {
  name: "Register",
  components: {BasicInput},

  setup () {
    const submitMessage = ref('');
    const storage = useStorage();

    const validationSchema = yup.object({
      username: yup.string()
          .required('Username is Required'),
      password: yup.string()
          .required('Password required')
          .min(8)
    })

    const { handleSubmit, errors } = useForm({ validationSchema });
    const { value: username } = useField('username');
    const { value: password } = useField('password')


    const submit = handleSubmit(async values => {
      const token = await registerUser(username.value, password.value)
      console.log(username.value + " " + password.value);
      if (token !== undefined) {
        await store.dispatch("setCredentials", values);
        submitMessage.value = "Registration Successful";
        setTimeout(() => {
          submitMessage.value = "";
        }, 3000);
        await router.push("/calc");
      } else {
        submitMessage.value = "Something went wrong. Please try again later.";
        setTimeout(() => {
          submitMessage.value = "";
        }, 3000);
      }
    });

    const login = async () => {
      const token = await loginUser(username.value, password.value);
      if (token !== undefined) {
        storage.setStorageSync('token', token.token);
        storage.setStorageSync('username', username.value);
        store.commit('setToken', token.token);
        router.push("/calc");
      } else {
        submitMessage.value = "Something went wrong. Please try again later.";
        setTimeout(() => {
          submitMessage.value = "";
        }, 3000);
      }
    };

    return {
      password,
      username,
      errors,
      submit,
      validationSchema,
      submitMessage,
      login
    }
  },
  computed: {
    hasErrors() {
      return !this.validationSchema.isValidSync({
        username: this.username,
        password: this.password,
      });
    },
  },
}
</script>

<style scoped>

* {
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
}

form {
  padding: 20px 0;
}

input,
textarea {
  padding: 10px;
  border-radius: 5px;
  border: 2px solid #ccc;
  margin-bottom: 10px;
  font-size: 1rem;
}

h1,
h2,
h3 {
  font-size: 2rem;
  margin: 0;
}

h1 {
  padding: 10px;
}

label{
  padding: 10px;
}

/* Common styles for button elements */
button {
  border-width: 2px;
  padding: 10px 20px;
  background-color: #1E293B;
  color: white;
}

button:active {
  background-color: white;
  color: #1E293B;
}

button:disabled {
  opacity: 0.5;
}

button:hover {
  color: #1E293B !important;
  background-color: white !important;
}

/* Style for error messages */
h5 {
  color: red;
  border: 1px solid red;
  padding: 5px;
  border-radius: 5px;
  margin: 10px 0;
}



</style>
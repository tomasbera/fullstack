<template>
  <h1>FeedBack</h1>
  <form @submit="submit">
    <fieldset>
      <legend>Feedback Form</legend>
      <legend>What Is Your Name?</legend>
      <div>
        <BasicInput
            id="nameInput"
            label="Username"
            type="username"
            v-model="username"
            :error="errors.username"

        />
        <legend>What Is Your Email?</legend>
        <BasicInput
            id="emailInput"
            label="Email"
            type="email"
            :error="errors.email"
            :modelValue="email"
            @change="handleChange"
        />
        <legend>What Is Your Feedback?</legend>
        <textarea
            id="messageInput"
            v-model="message"
            cols="40"
            rows="10"></textarea>
        <h5 v-if="errors.message">{{errors.message}}</h5>
      </div>
      <button
          id="submit_button"
          :disabled="hasErrors"
          type="submit"
          class="-fill-gradient"
      >
        Submit
      </button>
    </fieldset>
  </form>

  <h2 v-if="submitMessage" id="submit-message">
    {{ submitMessage }}
  </h2>

</template>

<script>
import BasicInput from "@/components/BasicInput.vue";
import * as yup from 'yup'
import {useField, useForm } from "vee-validate";
import store from "@/stores/store";
import axios from "axios";
import {ref} from "vue";

export default {
  name: "FeedbackForm",
  components: {BasicInput},

  setup () {
    const submitMessage = ref('')
    const validationSchema = yup.object({
      username: yup.string()
          .required('Username is Required'),
      email: yup.string()
          .required('Email required')
          .email('This Email Is Not A Valid Email-address'),
      message: yup.string()
          .required('Feedback required')
          .min(10)
    })

    const { handleSubmit, errors } = useForm({ validationSchema });
    const { value: email, handleChange } = useField('email');
    const { value: username } = useField('username');
    const { value: message, handleBlur } = useField('message');



    const submit = handleSubmit(async values => {
      try {
        const response = await axios.post('http://localhost:3000/feedback', {
          name: values.username,
          email: values.email,
          message: values.message,
          status: 'true'
        });

        if (response.data.email === email.value) {
          submitMessage.value = 'Thanks for your feedback';
        } else {
          throw new Error('Something went wrong. Please try again later.');
        }

        setTimeout(() => {
          submitMessage.value = '';
          }, 3000);

        await store.dispatch('savedRecentInfo', values);
        console.log('submit', values);

      } catch (error) {
        submitMessage.value = error.message;
      }
    });

    return {
      email,
      username,
      errors,
      message,
      submit,
      validationSchema,
      handleChange,
      handleBlur,
      submitMessage
    }
  },
  computed: {
    hasErrors() {
      return !this.validationSchema.isValidSync({
        username: this.username,
        email: this.email,
        message: this.message,
      });
    },
  },
}
</script>

<style scoped>

form {
  background-color: #f0f0f0;
  padding: 20px;
  border-radius: 8px;

}

form {
  padding-top: 20px;
  padding-bottom: 20px;
}

textarea {
  padding: 10px;
  border-radius: 5px;
  border: 2px solid #ccc;
  margin-bottom: 10px;
  font-size: 1rem;
}

h1, h2, h3 {
  font-size: 2rem;
  margin: 0;
}

h1{
  padding: 10px;
}

legend {
  padding: 20px
}

BasicInput {
  padding: 10px;
}

button {
  border-width: 2px;
  padding-left: 12px;
  padding-right: 12px;
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

#submit-message {
  margin-top: 40px;
  border-bottom: rgb(238,300,100) solid 4px;
}

h5 {
  color: red;
  border: 1px solid red;
  padding: 5px;
  border-radius: 5px;
  margin: 10px 0;
}



</style>
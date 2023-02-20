<template>
<h1>Oops!</h1>
  <h3>The {{resource}} you're  looking for is not here.</h3>
  <router-link :to="{ name: 'Calc'}">Back to home page</router-link>
</template>

<script>
import CalcView from "@/views/CalcView.vue";

export default {
  name: "NotFound",
  props: {
    resource: {
      type: String,
      required: true,
      default: 'page'
    }
  }
}
</script>


<style scoped>

</style>


<template>
  <h3>Log</h3>
  <ul id="scroll_log">
    <li v-for="item in this.$store.state.log" :key="item">{{item}}</li>
  </ul>
</template>


<script>
export default {
  name: 'calcLog',
};
</script>

<style scoped>

#scroll_log{
  list-style-type: none;
  border: 5px solid;
  margin: auto auto;
  width: 300px;
  min-height: 200px;
  min-width: 200px;
  background-color: white;
  text-align: center;
}
</style>
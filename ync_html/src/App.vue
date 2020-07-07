<template>
  <div id="app">
	<visitorls></visitorls>
  </div>
</template>

<script>
import visitorls from './components/visitorls.vue'

export default {
  name: 'app',
  components: {
    visitorls
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

<script setup lang="ts">
import TheFooter from './components/TheFooter.vue'
import TheHeader from './components/TheHeader.vue'
</script>

<template>
  <TheHeader />
  <main>
    <RouterView />
  </main>
  <TheFooter />
</template>

<style scoped>
main {
  padding-top: 5vh;
  max-width: 768px;
  margin: 0 auto;
}
</style>

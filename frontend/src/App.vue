<script setup lang="ts">
import TheHeader from './components/TheHeader.vue'
</script>

<template>
  <TheHeader />

  <main>
    <RouterView />
  </main>
</template>

<style scoped>
main {
  padding-top: 5vh;
  max-width: 768px;
  margin: 0 auto;
}
</style>

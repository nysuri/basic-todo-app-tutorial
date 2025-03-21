<script lang="ts" setup>
import { ref } from 'vue'

const count = ref(0)
</script>

<template>
  <div class="container">
    <p class="counter">{{ count }}</p>
    <button class="btn" @click="count++">Add count</button>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  gap: 16px;
  justify-content: center;
  align-items: center;
  height: 75vh;
}
.counter {
  font-size: 2rem;
}
</style>

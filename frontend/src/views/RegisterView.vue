<script lang="ts" setup>
import { ref } from 'vue'

const email = ref('john@gmail.com')
</script>

<template>
  <div class="container">
    <h1 style="color: red">{{ email }}</h1>
    <input placeholder="type your email.." v-model="email" />
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  gap: 12px;
}
</style>

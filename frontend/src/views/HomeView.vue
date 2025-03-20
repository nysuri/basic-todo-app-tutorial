<script setup lang="ts">
import { ListChecks, X } from 'lucide-vue-next'
</script>

<template>
  <div class="container">
    <h1><ListChecks class="icon" :size="32" /> Todo List</h1>

    <div class="todo-list">
      <div class="list-item">
        <div class="checkbox">
          <input type="checkbox" id="checkbox1" />
          <label for="checkbox1">Checkbox 1</label>
        </div>
        <X :size="24" class="close" />
      </div>

      <div class="list-item">
        <div class="checkbox">
          <input type="checkbox" id="checkbox1" />
          <label for="checkbox1">Checkbox 1</label>
        </div>
        <X :size="24" class="close" />
      </div>
    </div>
  </div>
</template>

<style scoped>
.active {
  background-color: white;
  border-bottom: 0;
}
.container {
  padding: 2.5rem;
  height: 80vh;
  background-color: white;
  border-radius: 12px;
  color: #000;
}
h1 {
  display: flex;
  gap: 8px;
  align-items: center;
}
.icon {
  color: var(--primary-clr);
}

.todo-list {
  display: flex;
  flex-direction: column;
  gap: 24px;
  margin-top: 5vh;
}

.list-item {
  display: flex;
  justify-content: space-between;
  font-size: 1.2rem;
}
.close {
  cursor: pointer;
}
.close:hover {
  color: red;
}
</style>

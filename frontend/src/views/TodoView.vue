<script setup lang="ts">
import { ListChecks, X, Plus } from 'lucide-vue-next'

const tasks = [
  {
    id: 1,
    title: 'Groceries.',
    completed: false,
  },
  {
    id: 2,
    title: 'Do the dishes.',
    completed: true,
  },
]
</script>

<template>
  <div class="container">
    <!-- Title -->
    <div class="title-container">
      <h1><ListChecks class="icon" :size="32" /> Todo List</h1>
      <div>1 / 2</div>
    </div>

    <div class="todo-list">
      <!-- Tasks list -->
      <div class="list-item">
        <div class="checkbox">
          <input type="checkbox" id="checkbox-1" />
          <label for="checkbox-1">{{ tasks[0].title }}</label>
        </div>
        <X :size="24" class="close" />
      </div>

      <div class="list-item">
        <div class="checkbox">
          <input type="checkbox" id="checkbox-2" />
          <label for="checkbox-2">{{ tasks[1].title }}</label>
        </div>
        <X :size="24" class="close" />
      </div>

      <!-- Form for adding a new task -->
      <form>
        <input type="text" placeholder="title for todo..." />
        <button class="btn btn-add">Add <Plus /></button>
      </form>
    </div>
  </div>
</template>

<style scoped>
.active {
  color: lightgray;
  text-decoration: line-through;
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
  height: 80%;
  overflow: auto;
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
.btn-add {
  display: flex;
  align-items: center;
  gap: 6px;
  background-color: var(--primary-clr);
  color: #fff;
}
form {
  display: flex;
  gap: 16px;
}
form > input {
  width: 80%;
}
.title-container {
  display: flex;
  justify-content: space-between;
}
</style>

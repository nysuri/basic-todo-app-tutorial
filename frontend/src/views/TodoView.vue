<script setup lang="ts">
import type { Task } from '@/types'
import { ListChecks, X, Plus } from 'lucide-vue-next'
import { ref, onMounted, computed } from 'vue'

const title = ref('')
const tasks = ref<Task[]>([])

// this automatically gets changed when the tasks array gets changed (computed!)
const amountCompleted = computed(() => tasks.value.filter((x) => x.completed).length)

onMounted(async () => {
  await fetchTodos()
})

// fetching and setting the data from backend
const fetchTodos = async (): Promise<void> => {
  try {
    const response = await fetch('http://localhost:8080/api/tasks')
    const data = await response.json()
    tasks.value = data
  } catch (err: unknown) {
    console.log(err)
  }
}

// updating a single task
async function toggleComplete(id: number): Promise<void> {
  const foundTask = tasks.value.find((x) => x.id === id)
  if (!foundTask) return // do nothing when no task found

  // true => !true | false => !false
  foundTask.completed = !foundTask.completed

  try {
    const response = await fetch(`http://localhost:8080/api/tasks/${foundTask.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(foundTask),
    })

    // Check if the response is OK (status 200-299)
    if (!response.ok) {
      console.log(`Error: ${response.status}`)
      return
    }
  } catch (err: unknown) {
    console.log(err)
  }
}

async function addTodo() {
  try {
    const response = await fetch('http://localhost:8080/api/tasks', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ title: title.value }),
    })
    const data = await response.json()
    tasks.value.push(data)
  } catch (err: unknown) {
    console.log(err)
  }

  title.value = ''
}
</script>

<template>
  <div class="container">
    <!-- Title -->
    <div class="title-container">
      <h1><ListChecks class="icon" :size="32" /> Todo List</h1>
      <div>{{ amountCompleted }} / {{ tasks.length }}</div>
    </div>

    <div class="todo-list">
      <!-- Tasks list -->
      <div v-for="task in tasks" :key="task.id" class="list-item">
        <div class="checkbox">
          <input
            type="checkbox"
            :id="'checkbox-' + task.id"
            :checked="task.completed"
            @change="toggleComplete(task.id)"
          />
          <label :for="'checkbox-' + task.id" :class="{ completed: task.completed }">{{
            task.title
          }}</label>
        </div>
        <X :size="24" v-if="task.completed" class="close" />
      </div>
    </div>

    <!-- Form for adding a new task -->
    <form>
      <input type="text" placeholder="title for todo..." v-model="title" />
      <button class="btn btn-add" @click.prevent="addTodo">Add <Plus /></button>
    </form>
  </div>
</template>

<style scoped>
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
.title-container {
  display: flex;
  justify-content: space-between;
}
/* // Styles for todo-list */
.todo-list {
  display: flex;
  flex-direction: column;
  gap: 24px;
  margin-top: 5vh;
  height: 80%;
  overflow: auto;
}

/* Styles for list-item */
.completed {
  color: lightgray;
  text-decoration: line-through;
  border-bottom: 0;
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

/* Styles for adding todo section */
form {
  display: flex;
  gap: 16px;
}
form > input {
  width: 80%;
}
.btn-add {
  display: flex;
  align-items: center;
  gap: 6px;
  background-color: var(--primary-clr);
  color: #fff;
}
</style>

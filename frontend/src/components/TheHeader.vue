<script lang="ts"></script>
<template>
  <header class="container">
    <RouterLink to="/">
      <div class="title">My<span style="color: var(--primary-clr)">Tasks</span></div>
    </RouterLink>

    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">New</RouterLink>
    </nav>
  </header>
</template>

<style scoped>
header {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

nav {
  display: flex;
  gap: 1.1rem;
}

.title {
  font-weight: bold;
  font-size: 2rem;
  cursor: pointer;
}
.title:hover {
  /* opacity: 0.8; */
  border-bottom: 2px solid var(--primary-clr);
}

a {
  color: var(--light-clr);
  text-decoration: none;
}
a:hover {
  color: var(--primary-clr);
}
</style>

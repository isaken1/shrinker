<template>
  <div>
    <b-nav tabs>
      <b-nav-item exact exact-active-class="active" to="/login"
        >Sair</b-nav-item
      >
      <b-nav-item exact exact-active-class="active" to="/"
        >Lista de URLs</b-nav-item
      >
      <b-nav-item exact exact-active-class="active" to="/nova"
        >Encurtar URL</b-nav-item
      >
    </b-nav>
    <b-container>
      <router-view />
    </b-container>
  </div>
</template>

<script>
export default {
  name: "HomePage"
};
</script>

<style scoped>
h3 {
  margin-bottom: 32px;
  margin-top: 32px;
}
</style>

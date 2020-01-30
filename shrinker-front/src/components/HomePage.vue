<template>
  <div>
    <b-nav tabs>
      <b-nav-item exact exact-active-class="active" to="/login"
        >Sair</b-nav-item
      >
      <b-nav-item exact exact-active-class="active" to="/"
        >Lista de URLs</b-nav-item
      >
      <b-nav-item exact exact-active-class="active" disabled to="/nova"
        >Encurtar URL</b-nav-item
      >
    </b-nav>
    <b-container>
      <h3>Olá, {{ user }}!</h3>
      <router-view />
    </b-container>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  computed: {
    user() {
      return this.$store.state.authentication.user.nome;
    }
  }
};
</script>

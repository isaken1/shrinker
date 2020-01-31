<template>
  <b-container fluid class="vertical-center">
    <b-col sm="12">
      <b-jumbotron>
        <b-col sm="10" offset-sm="1">
          <div v-if="alert.message" :class="`alert ${alert.type}`">
            {{ alert.message }}
          </div>
          <router-view />
        </b-col>
      </b-jumbotron>
    </b-col>
  </b-container>
</template>

<script>
export default {
  name: "app",
  computed: {
    alert() {
      return this.$store.state.alert;
    }
  },
  watch: {
    $route() {
      this.$store.dispatch("alert/clear");
    }
  }
};
</script>

<style scoped>
.vertical-center {
  min-height: 100%;
  min-height: 100vh;

  display: flex;
  align-items: center;
}
</style>

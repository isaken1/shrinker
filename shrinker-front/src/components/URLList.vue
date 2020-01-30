<template>
  <b-container fluid="lg">
    <b-table striped hover :items="urls" />
  </b-container>
</template>

<script>
export default {
  name: "URLList",
  computed: {
    urls() {
      return this.$store.state.urlHelper.data;
    }
  },
  created() {
    this.$store.dispatch("urlHelper/getAll");
  }
};
</script>

<style scoped />

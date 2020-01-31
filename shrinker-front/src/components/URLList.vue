<template>
  <b-container fluid class="container-list">
    <h3>Olá, {{ user }}!</h3>
    <p>Aqui estão suas URLs:</p>
    <b-table
      small
      striped
      responsive="sm"
      bordered
      hover
      :items="urls"
      :fields="fields"
    >
      <template v-slot:cell(dtCriacao)="data">
        <p>{{ data.value }}</p>
      </template>

      <template v-slot:cell(urlOriginal)="data">
        <a target="_blank" :href="'//' + data.value">{{ data.value }}</a>
      </template>

      <template v-slot:cell(urlEncurtada)="data">
        <a target="_blank" :href="'//' + data.item.urlOriginal">{{ data.value }}</a>
      </template>
    </b-table>
  </b-container>
</template>

<script>
export default {
  name: "URLList",
  data() {
    return {
      fields: [
        { key: "dtCriacao", label: "Data de criação", sortable: false },
        { key: "urlEncurtada", label: "URL Encurtada", sortable: false },
        { key: "urlOriginal", label: "URL Original", sortable: false }
      ]
    };
  },
  computed: {
    urls() {
      return this.$store.state.urlHelper.data;
    },
    user() {
      return this.$store.state.authentication.user.nome;
    }
  },
  created() {
    this.$store.dispatch("urlHelper/getAll");
  }
};
</script>

<style scoped>
  .container-list {
    margin-top: 32px;
  }
</style>

<template>
  <b-container fluid="sm">
    <b-col style="margin-top: 64px;">
      <b-form inline @submit.prevent="handleSubmit">
        <b-input-group size="md" style="width: 100%" prepend="URL">
          <b-form-input placeholder="www.foo.bar" v-model="url"/>
          <b-input-group-append>
            <b-button type="submit" variant="danger">Encurtar</b-button>
          </b-input-group-append>
        </b-input-group>
      </b-form>
    </b-col>
  </b-container>
</template>

<script>
export default {
  name: "NewUrl",
  data() {
    return {
      url: ""
    };
  },
  methods: {
    handleSubmit() {
      const { url } = this;
      const { dispatch } = this.$store;
      if (url) {
        dispatch("urlHelper/insertNewUrl", url);
      }
    }
  }
};
</script>

<style scoped>
</style>

<template>
  <div>
    <h2>Novo usuário</h2>
    <b-form @submit.prevent="handleSubmit">
      <b-form-group label="E-mail:" label-for="input-email">
        <b-form-input
          id="input-email"
          v-model="email"
          name="email"
          :class="{ 'is-invalid': formEmailState }"
          :invalid-feedback="invalidFeedbackEmail"
        />
      </b-form-group>
      <b-form-group label="Nome:" label-for="input-nome">
        <b-form-input
          id="input-nome"
          v-model="nome"
          name="nome"
          :class="{ 'is-invalid': formEmailState }"
          :invalid-feedback="invalidFeedbackEmail"
        />
      </b-form-group>
      <b-form-group label="Senha:" label-for="input-password">
        <b-form-input
          id="input-password"
          type="password"
          v-model="password"
          name="password"
          :invalid-feedback="invalidFeedbackPassword"
          :class="{ 'is-invalid': formPasswordState }"
        />
      </b-form-group>
      <b-form-group>
        <b-button :disabled="loggingIn" type="submit" variant="primary"
          >Entrar</b-button
        >
        <img
          v-show="loggingIn"
          src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="
        />
      </b-form-group>
    </b-form>
  </div>
</template>

<script>
export default {
  name: "NewUserPage",
  computed: {
    formNameState() {

    }
    },
    formPasswordState() {
      return this.submitted && !this.password;
    },
    formEmailState() {
      return this.submitted && !this.email;
    },
    invalidFeedbackEmail() {
      if (this.formEmailState) {
        return "Insira um email!";
      } else {
        return "";
      }
    },
    invalidFeedbackPassword() {
      if (this.formPasswordState) {
        return "Insira uma senha!";
      } else {
        return "";
      }
    },
  methods: {
    handleSubmit() {}
  }
};
</script>

<style scoped />

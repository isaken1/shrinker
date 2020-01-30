<template>
  <div>
    <h2 style="text-align: center">Login</h2>
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
      <b-form-group label="Senha:" label-for="input-senha">
        <b-form-input
          id="input-senha"
          type="password"
          v-model="senha"
          name="senha"
          :invalid-feedback="invalidFeedbackPassword"
          :class="{ 'is-invalid': formPasswordState }"
        />
      </b-form-group>
      <b-form-group>
        <b-button block :disabled="loggingIn" type="submit" variant="primary"
          >Entrar</b-button
        >
        <img
          v-show="loggingIn"
          src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="
        />
      </b-form-group>
    </b-form>
    <b-container class="form-buttons">
      <b-button-group :disabled="loggingIn">
        <b-button to="/cadastrar" variant="link" style="text-decoration: none"
          >Cadastrar</b-button
        >
        <b-button
          disabled
          to="cadastro"
          variant="link"
          style="text-decoration: none"
          >Esqueci minha senha</b-button
        >
      </b-button-group>
    </b-container>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  data() {
    return {
      email: "",
      senha: "",
      submitted: false
    };
  },
  computed: {
    formPasswordState() {
      return this.submitted && !this.senha;
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
    loggingIn() {
      return this.$store.state.authentication.status.loggingIn;
    }
  },
  methods: {
    handleSubmit() {
      this.submitted = true;
      const { email, senha } = this;
      const { dispatch } = this.$store;
      if (email && senha) {
        dispatch("authentication/login", { email, senha });
      }
    }
  }
};
</script>

<style scoped>
.form-buttons {
  display: flex;
  justify-content: space-around;
}
</style>

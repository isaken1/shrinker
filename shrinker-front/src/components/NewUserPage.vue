<template>
  <div>
    <h2 style="text-align: center">Novo usuário</h2>
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
          :class="{ 'is-invalid': formNameState }"
          :invalid-feedback="invalidFeedbackName"
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
      <div class="form-buttons">
        <b-button type="submit" variant="primary">Cadastrar</b-button>
        <b-button type="reset" variant="outline-primary">Limpar</b-button>
      </div>
      <img
        v-show="signingUp"
        src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA=="
      />
    </b-form>
  </div>
</template>

<script>
export default {
  name: "NewUserPage",
  data() {
    return {
      nome: "",
      email: "",
      senha: "",
      submitted: false
    };
  },
  computed: {
    signingUp() {
      return this.$store.state.userSignup.status.signingUp;
    },
    formNameState() {
      return this.submitted && !this.name;
    },
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
    invalidFeedbackName() {
      if (this.formNameState) {
        return "Insira um nome!";
      } else {
        return "";
      }
    }
  },
  methods: {
    handleSubmit() {
      this.submitted = true;
      const { nome, email, senha } = this;
      const { dispatch } = this.$store;
      if (email && senha && nome) {
        dispatch("userSignup/signUp", { email, nome, senha });
      }
    }
  }
};
</script>

<style scoped>
.form-buttons {
  display: flex;
  justify-content: space-evenly;
}
</style>

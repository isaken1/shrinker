import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const LoginPage = () => import("@/components/LoginPage");
const HomePage = () => import("@/components/HomePage");
const NewUserPage = () => import("@/components/NewUserPage");

export const router = new Router({
  mode: "history",
  routes: [
    { path: "/", component: HomePage },
    { path: "/login", component: LoginPage },
    { path: "/cadastrar", component: NewUserPage, name: "cadastro" },
    { path: "*", redirect: "/" }
  ]
});

router.beforeEach((to, from, next) => {
  const publicPages = ["/login", "/cadastrar"];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem("user");

  if (authRequired && !loggedIn) {
    return next("/login");
  }

  next();
});

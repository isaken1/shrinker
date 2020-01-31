import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const LoginPage = () => import("@/components/LoginPage");
const HomePage = () => import("@/components/HomePage");
const NewUserPage = () => import("@/components/NewUserPage");
const URLList = () => import("@/components/URLList");
const NewUrl = () => import("@/components/NewUrl");

export const router = new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      component: HomePage,
      children: [
        { path: "", component: URLList },
        { path: "/nova", component: NewUrl }
      ]
    },
    { path: "/login", component: LoginPage },
    { path: "/cadastrar", component: NewUserPage },
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

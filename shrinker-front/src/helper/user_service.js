export const userService = {
  login,
  logout,
  newUser,
  handleResponse
};


function logout() {
  localStorage.removeItem("user");
}

function login(email, senha) {
  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "*"
    },
    body: JSON.stringify({ email, senha })
  };

  return fetch("http://localhost:8080/login", options)
    .then(handleResponse)
    .then(user => {
      if (user.token) {
        localStorage.setItem("user", JSON.stringify(user));
      }
      return user;
    });
}

function newUser(email, senha, nome) {
  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "*"
    },
    body: JSON.stringify({ email, senha, nome })
  };

  return fetch("http://localhost:8080/usuarios", options).then(handleResponse);
}

function handleResponse(response) {
  return response.text().then(text => {
    const data = text && JSON.parse(text);
    if (!response.ok) {
      if (response.status === 401) {
        logout();
        location.reload();
      }

      const error = (data && data.message) || response.statusText;
      return Promise.reject(error);
    }
    return data;
  });
}
import { authHeader } from "@/helper/http_header";
import { userService } from "@/helper/user_service"

export const urlService = {
  fetchAll,
  insert
};

function fetchAll() {
  const options = {
    method: "GET",
    headers: authHeader()
  };
  return fetch("localhost:8080/url", options).then(userService.handleResponse);
}

function insert(url) {
  const options = {
    method: "POST",
    headers: authHeader(),
    body: JSON.stringify({ urlOriginal: url })
  };
  return fetch("localhost:8080/url", options).then(userService.handleResponse);
}


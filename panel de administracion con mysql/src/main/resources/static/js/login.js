

async function login() {
  let url = URL_SERVER + 'auth/login';

  let email = document.getElementById('txtEmail').value;
  let password = document.getElementById('txtPassword').value;

  let data = {
    "email": email,
    "password": password
  }

  let config = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  }

  let response = await fetch(url, config);
  let token = await response.text();

  sessionStorage.token = token;
  window.location.href = '/customers.html';
}

function logout() {
  sessionStorage.token = null;
  window.location.href = '/login.html';
}
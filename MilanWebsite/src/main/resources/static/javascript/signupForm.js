// Attach event listeners to form fields
document.getElementById("username").addEventListener("input", validateUsername);
document.getElementById("password").addEventListener("input", validatePassword);
document.getElementById("confPassword").addEventListener("input", validateConfPassword);
document.getElementById("email").addEventListener("input", validateEmail);
document.getElementById("phone").addEventListener("input", validatePhone);

function validateForm() {
  // Call individual validation functions
  return (
    validateUsername() &&
    validatePassword() &&
    validateConfPassword() &&
    validateEmail() &&
    validatePhone()
  );
}

function validateUsername() {
  var username = document.getElementById("username").value;
  // Example validation: Check if username is at least 3 characters long
  if (username.length < 3) {
    document.getElementById("usernameError").innerText = "Username must be at least 3 characters.";
    return false;
  } else {
    document.getElementById("usernameError").innerText = "";
    return true;
  }
}

function validatePassword() {
  var password = document.getElementById("password").value;
  // Example validation: Check if password is at least 6 characters long
  if (password.length < 6) {
    document.getElementById("passwordError").innerText = "Password must be at least 6 characters.";
    return false;
  } else {
    document.getElementById("passwordError").innerText = "";
    return true;
  }
}

function validateConfPassword() {
  var password = document.getElementById("password").value;
  var confPassword = document.getElementById("confPassword").value;
  // Example validation: Check if passwords match
  if (password !== confPassword) {
    document.getElementById("confPasswordError").innerText = "Passwords do not match.";
    return false;
  } else {
    document.getElementById("confPasswordError").innerText = "";
    return true;
  }
}

function validateEmail() {
  var email = document.getElementById("email").value;
  // Example validation: Check if email is valid
  if (!isValidEmail(email)) {
    document.getElementById("emailError").innerText = "Invalid email address.";
    return false;
  } else {
    document.getElementById("emailError").innerText = "";
    return true;
  }
}

function validatePhone() {
  var phone = document.getElementById("phone").value;
  // Example validation: Check if phone contains only digits
  if (!/^\d*$/.test(phone)) {
    document.getElementById("phoneError").innerText = "Phone must contain only digits.";
    return false;
  } else {
    document.getElementById("phoneError").innerText = "";
    return true;
  }
}

function isValidEmail(email) {
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
}

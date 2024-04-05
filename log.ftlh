<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: black;
            color: white;
        }
        .reg {
            background-color: #111;
            padding: 20px;
            margin-top: 50px;
            border-radius: 5px;
            margin-left: 250px;
            margin-right: 250px;
        }
        .form-control {
            background-color: #222;
            color: #bbb;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            <img src="img_1.png" width="150" height="40" alt="Картинка">
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="/home" class="nav-link" aria-current="page">Главная</a></li>
            <li class="nav-item"><a href="con" class="nav-link">Контакты</a></li>
            <li class="nav-item"><a href="ab" class="nav-link">О нас</a></li>
            <li class="nav-item"><a href="reg" class="nav-link active">Аккаунт</a></li>

        </ul>
    </header>
</div>
<div class="reg">
    <h2>Авторизация</h2>
    <form id="loginForm">
        <div class="mb-3">
            <label for="username" class="form-label">Имя пользователя</label>
            <input type="text" class="form-control" id="username" placeholder="Введите имя пользователя">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Пароль</label>
            <input type="password" class="form-control" id="password" placeholder="Введите пароль">
        </div>
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
</div>

<script>
    document.getElementById("loginForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Предотвращаем отправку формы

        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        // Здесь можно добавить код для проверки имени пользователя и пароля

        // Пример проверки:
        if (username === "admin" && password === "password") {
            alert("Авторизация успешна!");
            // Здесь можно добавить код для перенаправления на другую страницу
        } else {
            alert("Неверные имя пользователя или пароль. Попробуйте снова.");
        }
    });
</script>
</body>
</html>
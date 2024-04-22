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
    <h2>Регистрация</h2>
    <form>
        <div class="mb-3">
            <label for="name" class="form-label">Имя</label>
            <input type="text" class="form-control" id="name" placeholder="Введите имя">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" placeholder="Введите email">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Пароль</label>
            <input type="password" class="form-control" id="password" placeholder="Введите пароль">
        </div>
        <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
    </form>
</div>
</body>
</html>
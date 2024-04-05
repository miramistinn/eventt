<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        body {
            background-image: url("https://yamal-media.ru/images/insecure/rs:fill-down:1920:1080/aHR0cHM6Ly84NTQyMjAuc2VsY2RuLnJ1L3lhbWFsbmV3cy84Y2EyYjk5Ny1lN2Yud2VicA.webp");
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            margin: 0;
            padding: 0;
        }
        .container {
            background-color: black;
        }
        .form {
            background-color: white;
            padding: 20px;
            margin-top: 50px;
            margin-left: 250px;
            margin-right: 250px;
            border-radius: 5px;
        }
    </style>
</head>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            <img src="img_1.png" width="150" height="40" alt="Картинка">
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="/home" class="nav-link" aria-current="page">Главная</a></li>
            <li class="nav-item"><a href="con" class="nav-link">Контакты</a></li>
            <li class="nav-item"><a href="ab" class="nav-link">О нас</a></li>
            <li class="nav-item"><a href="reg" class="nav-link">Аккаунт</a></li>

        </ul>
    </header>
</div>
<div class="form">
    <h2>Форма обратной связи</h2>
    <form>
        <div class="mb-3">
            <label for="name" class="form-label">Имя</label>
            <input type="text" class="form-control" id="name" placeholder="Введите имя">
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Номер телефона</label>
            <input type="tel" class="form-control" id="phone" placeholder="Введите номер телефона">
        </div>
        <div class="mb-3">
            <label for="comments" class="form-label">Комментарии</label>
            <textarea class="form-control" id="comments" rows="3" placeholder="Введите комментарии"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Отправить</button>
    </form>
</div>
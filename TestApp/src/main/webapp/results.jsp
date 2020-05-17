<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 12.05.2020
  Time: 04:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результаты</title>
</head>
<body>
<jsp:include page="_navbar.jsp"></jsp:include>
<div class="container">
    <h1 class="my-4">Результаты</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>EMail</th>
            <th>ФИО кандидата</th>
            <th>Дата отправки</th>
            <th>Дата решения</th>
            <th>Верно решено</th>
            <th>Подробнее</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>yshashkin@yandex.ru</td>
            <td>Шашкин Юрий Анатольевич</td>
            <td>12.05.2020 4:00</td>
            <td>12.05.2020 4:14</td>
            <td>1 из 1</td>
            <td><a href="#">Посмотреть решение</a></td>
        </tr>
        <tr>
            <td>ivanov@mail.ru</td>
            <td>Иванов Иван Иванович</td>
            <td>12.05.2020 4:20</td>
            <td>Задание еще не решено</td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>

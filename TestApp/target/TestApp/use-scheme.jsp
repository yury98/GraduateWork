<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 21.04.2020
  Time: 09:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор схемы</title>
</head>
<body>
<jsp:include page="_navbar.jsp"></jsp:include>
<div class="container" style="margin-top: 10px">
    <div class="row">
        <div class="col">
        </div>
        <div class="col-6">
            <form>
                <div class="form-group">
                    <label for="DBSelect">Выберите СУБД:</label>
                    <select class="form-control" id="DBSelect">
                        <option>MS SQL 2016</option>
                        <option>Oracle 11G</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="schemeSelect">Выберите схему:</label>
                    <select class="form-control" id="schemeSelect">
                        <option>test</option>
                    </select>
                </div>
                <ul>
                    <li>TABLE
                    <ul>
                        <li>Users</li>
                        <li>Sales</li>
                        <li>Purchases</li>
                    </ul>
                    </li>
                </ul>
                <div class="btn-group mr-2 btn-lg btn-block" role="group" aria-label="First group">
                    <a href="/createScheme" class="btn btn-primary">Создать новую схему</a>
                    <button type="button" class="btn btn-primary">Выбор</button>
                </div>
            </form>
        </div>
        <div class="col">
        </div>
    </div>
</div>

</body>
</html>

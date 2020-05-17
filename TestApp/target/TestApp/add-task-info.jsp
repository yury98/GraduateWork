<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 07.05.2020
  Time: 07:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Task Info</title>
    <script src="js/jquery-3.5.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.8/js/select2.min.js" defer></script>
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
                    <label for="timer">Время на выполнение задания:</label>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" id="timer" aria-label="Recipient's username" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <span class="input-group-text" id="basic-addon2">мин.</span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tagSelect">Теги:</label>
                    <select class="js-example-basic-multiple" id="tagSelect" name="states[]" multiple="multiple" style="width: 100%">
                        <option value="AL">Средний уровень</option>
                        <option value="WY">Высокий уровень</option>
                        <option value="WY">Использование CTE</option>
                    </select>
                </div>
                <div class="btn-group mr-2 btn-lg btn-block" role="group" aria-label="First group">
                    <button type="button" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
        <div class="col">
        </div>
    </div>
</div>

</body>
<script>
    $(document).ready(function() {
        $('.js-example-basic-multiple').select2();
    });
</script>
</html>

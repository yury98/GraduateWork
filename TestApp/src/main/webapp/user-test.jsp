<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 29.04.2020
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Задание</title>
    <style type="text/css" media="screen">
        #editor {
            position: absolute;
            top: 50px;
            right: 0;
            bottom: 50px;
            left: 0;
        }

        #editor2 {
            position: absolute;
            top: 50px;
            right: 0;
            bottom: 50px;
            left: 0;
        }

        .split {
            height: 100%;
            width: 50%;
            position: fixed;
            z-index: 1;
            top: 0;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .left {
            left: 0;
        }

        .right {
            right: 0;
        }

        .buttons {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 50px;

        }

        .images {
            margin: 5px;
        }

        .save {
            position: fixed;
            right: 10px;
            margin: 5px;
        }
    </style>
</head>
<body>
<jsp:include page="_navbar_employee.jsp"></jsp:include>
<div class="split left">
    <div id="editor">Выведите все записи из таблицы USERS</div>
</div>
<div class="split right">
    <div id="editor2"></div>
</div>
<div class="buttons">
    <div class="form-row">
        <div class="custom-file col images">
            <button type="button" class="btn btn-primary">Скачать изображение</button>
        </div>
        <div class="col">
            <div class="btn-group save" role="group" aria-label="Basic example">
                <button type="button" class="btn btn-primary">Предыдущее задание</button>
                <button type="button" class="btn btn-primary">Следующее задание</button>
            </div>
            <button type="button" class="btn btn-primary save">Завершить тестирование</button>
        </div>
    </div>
</div>


<script src="https://github.com/ajaxorg/ace-builds/tree/master/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="//cdn.jsdelivr.net/ace/1.1.01/min/ace.js"
        type="text/javascript" charset="utf-8"></script>
<script>
    var editor = window.ace.edit("editor");
    //editor.setTheme("ace/theme/monokai");
    editor.session.setMode("ace/mode/sql");
    var editor2 = window.ace.edit("editor2");
    //editor.setTheme("ace/theme/monokai");
    editor2.session.setMode("ace/mode/sql");
</script>
</body>
</html>

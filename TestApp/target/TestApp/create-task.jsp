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
            bottom: 0px;
            left: 0;
        }

        #editor2 {
            position: absolute;
            top: 50px;
            right: 0;
            bottom: 0px;
            left: 0;
        }

        .split {
            height: 95%;
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
            margin-top: 5px;
            margin-left: 20px;
            margin-right: 20px;
        }

        .save {
            position: fixed;
            right: 5px;
            margin-top: -45px;
        }

        .check {
            padding: 11px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<jsp:include page="_navbar.jsp"></jsp:include>
<div class="split left">
    <div id="editor">Введите сюда текст задания</div>
</div>
<div class="split right">
    <div id="editor2">Введите сюда эталонное решение вашего задания</div>
</div>
<div class="buttons">
    <div class="form-row">
        <div class="col custom-file images">
            <input type="file" class="custom-file-input" id="customFile">
            <label class="custom-file-label" for="customFile" data-browse="Обзор">Схема.png</label>
        </div>
        <div class="col">
            <div class="col-md-8 form-check check">
                <input class="form-check-input" type="checkbox" value="1" id="invalidCheck">
                <label class="form-check-label" for="invalidCheck">
                    Разрешить другим менежерам использовать данное задание
                </label>
            </div>
            <div class="col-md-3">
                <button type="button" class="btn btn-primary save">Сохранить</button>
            </div>

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

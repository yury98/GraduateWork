<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 12.05.2020
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Комплекты заданий</title>
</head>
<body>
<jsp:include page="_navbar.jsp"></jsp:include>
    <div class="container">
        <h1 class="my-4">Комплекты заданий
        </h1>
        <div class="row">
            <div class="col-md-12">
                <h3>Комплект 1</h3>
                <p>Количество заданий: 1</p>
                <p>Время на выполнение: 120 мин.</p>
                <p>Теги: Средний уровень</p>
                <a class="btn btn-primary" href="#">Подробнее о заданиях</a>
                <a class="btn btn-primary" href="#">Изменить</a>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >Отправить</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Новое сообщение</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Почта кандидата:</label>
                                        <input type="text" class="form-control" id="recipient-name">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="col-form-label">ФИО:</label>
                                        <input class="form-control" id="message-text">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                                <button type="button" class="btn btn-primary">Отправить</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-12">
                <h3>Комплект 2</h3>
                <p>Количество заданий: 1</p>
                <p>Время на выполнение: 120 мин.</p>
                <p>Теги: Средний уровень</p>
                <a class="btn btn-primary" href="#">Подробнее о заданиях</a>
                <a class="btn btn-primary" href="#">Изменить</a>
                <a class="btn btn-primary" href="#">Отправить</a>
            </div>
        </div>
    </div>
</body>
</html>
<script>
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('Отправить')
        modal.find('.modal-body input').val(recipient)
    })
</script>

<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL |</h1><hr>
<#if user.email??>
    <hr3>Имя пользователя: <i>${user.name}</i></hr3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
    <a href="/login">Войти</a>
</#if><hr>

<h4>Товары со всей России</h4>
<form action="/" method="get">
    Поиск по названию объявления: <input type="text" name="title"><br>
    <input type="submit" value="Поиск">
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Товар нет</h3>
</#list>

private UUID orderId;   //уникальный id заказа
private int customerId; //заказчик
private int employeeId;  //сотрудник
private String deliveryTimeLeft;
private String cancelReason; //причина отмены
private int productId;
private int price;  //стоимость заказа
<#if user.email??>
    <hr>
    <h3>Создать новый заказ</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Заказчик: <input type="text" name="customerId"/><br><br>
        Сотрудник: <input type="text" name="employeeId"/><br><br>
        Стоимость заказа: <input type="number" name="price"/><br><br>
        Товар: <input type="number" name="productId"/><br><br>
        Город: <input type="text" name="city"/><br><br>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Добавить заказ"/>
    </form>
</#if>
</body>
</html>
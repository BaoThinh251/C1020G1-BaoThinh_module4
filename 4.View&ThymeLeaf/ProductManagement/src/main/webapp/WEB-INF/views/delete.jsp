<!DOCTYPE html>
<html lang="en">
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="/layout :: head">
    <meta charset="UTF-8">
    <title>Delete Product</title>
</head>
<body>
<h2>Delete Product</h2>
<div id="form">
    <form action="#" th:action="@{/product/delete}" th:object="${product}" method="POST" novalidate="novalidate">
        <input type="hidden" th:field="*{id}"/>
        <div>
            <label>Product Name</label>
            <input type="text" th:field="*{name}"/>
        </div>
        <div>
            <label>Price</label>
            <input type="number" th:field="*{price}"/>
        </div>
        <div>
            <label>Description</label>
            <input type="text" th:field="*{description}"/>
        </div>
        <div>
            <label>Producer</label>
            <input type="text" th:field="*{producer}"/>
        </div>
        <div>
            <input type="submit" value="Delete"/>
        </div>
    </form>
</div>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>
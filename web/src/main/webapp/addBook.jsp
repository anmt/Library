<%--
  Created by IntelliJ IDEA.
  User: ankae
  Date: 19.09.2018
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <form action="/AddBookServlet" method="post">
        <div class="form-group">
            <label>Title</label>
            <input type="text" class="form-control" name="title">
        </div>
        <div class="form-group">
            <label>ISBN</label>
            <input type="text" class="form-control" name="isbn">
        </div>
        <div class="form-group">
            <label>Pages</label>
            <input type="number" class="form-control" name="pages">
        </div>

        <div class="form-group">
            <label>Category</label>
            <select class="form-control" name="category">
                <option>..........</option>
            </select>
        </div>

        <div class="form-group">
            <label>Author</label>
            <select class="form-control" name="author">
                <option>..........</option>
            </select>
        </div>

        <div class="form-group">
            <label>Release date</label>
            <input type="date" class="form-control" name="releaseDate">
        </div>
        <div class="form-group">
            <label>Summary</label>
            <input type="text" class="form-control" name="summary">
        </div>

    </form>
</div>

</body>
</html>

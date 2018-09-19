<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
</head>

<body>

    <div class="container">
        <form action="/HomeServlet" method="post">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Tytuł</th>
                <th scope="col">Autor</th>
                <th scope="col">ISBN</th>
                <th scope="col">Kategoria</th>
                <th scope="col">Wydana</th>
                <th scope="col">Wypożyczona?</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.books}" var="book" varStatus="loop">
            <tr>
                <td>${book.title}</td>
                <td>${book.authorName}</td>
                <td>${book.isbn}</td>
                <td>${book.category}</td>
                <td>${book.releaseDate}</td>
                <td>${book.borrowerName}</td>
                <td>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="choice" value="${book.bookId}">
                    </div>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
            <input class="btn btn-outline-success" type="submit" name="action" value="Add">
            <input class="btn btn-outline-primary" type="submit" name="action" value="Edit">
            <input class="btn btn-outline-secondary" type="submit" name="action" value="Show">
            <input class="btn btn-outline-danger" type="submit" name="action" value="Delete">
        </form>

    </div>


</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base/header.jsp" %>
<body>


<section class="login-page">
    <h2>Zaloguj się</h2>
    <h3 class="login-error">
        <c:if test="${error}">
            Nieprawidłowy login lub hasło.
        </c:if>
        </h3>
    <form:form modelAttribute="user"
               action="${pageContext.request.contextPath}/login"
               method="post">

        <div class="form-group">
            <form:input type="email" name="email" placeholder="Email" path="email"/>
        </div>
        <div class="form-group">
            <form:input type="password" name="password" placeholder="Hasło" path="password"/>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form:form>
</section>

<%@include file="base/footer.jsp" %>
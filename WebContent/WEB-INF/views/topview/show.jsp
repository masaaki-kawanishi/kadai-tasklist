<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../layout/app.jsp">
  <c:param name ="content">
    <%request.setCharacterEncoding("UTF-8"); %>

    <h2>タスクの詳細ページ</h2>

    <p>タスク：<c:out value="${message.tasks}" /></p>
    <p>タスク内容：<c:out value="${message.content}" /></p>

    <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>

  </c:param>
</c:import>
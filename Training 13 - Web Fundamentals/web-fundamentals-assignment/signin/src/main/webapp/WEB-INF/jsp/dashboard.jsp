<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

Welcome back, ${user}!
<a href="<c:url value="/user/logout"/>" class="btn btn-danger btn-xs">Logout</a>

<jsp:include page="footer.jsp" />
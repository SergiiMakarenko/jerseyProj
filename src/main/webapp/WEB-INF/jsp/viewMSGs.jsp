<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>hello</title>
    <script>
        function changePage(newPage){
            window.location = newPage;
        }
    </script>
    <link rel="stylesheet" type="text/css" href="css/mainStyle.css">
    <style type="text/css"></style>

</head>
<body>

<div class="headDiv">MSGs list:</div>

<table class="resultTable" >
    <TR>

        <Th>MSG date</Th>
        <Th>Phone</Th>
        <Th>MSG text</Th>
    </TR>

    ${it.user}
    <c:forEach var="msgs" items="${it.msgs}">
        <TR >

            <TD>${msgs.date}</TD>
            <TD>${msgs.phoneNumber}</TD>
            <TD>${msgs.msg}</TD>

        </TR>
    </c:forEach>
</table>


<div class="menuDiv" onclick="changePage('/')">Back to menu</div>
</body>

</body>

</html>
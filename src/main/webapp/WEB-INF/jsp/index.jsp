<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View menus</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyle.css">
    <style type="text/css"> </style>

    <script>
        function changePage(newPage){
            window.location = newPage;
        }
    </script>

</head>
<body>

<div class="headDiv">Menu</div>


<div class = "menuDiv" onclick="changePage('createMSG')">Send message</div>
<BR>
<div class = "menuDiv" onclick="changePage('viewMSGs')">View messages</div>


</body>

</html>
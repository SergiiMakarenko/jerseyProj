<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Create msg</title>
    <link rel="stylesheet" type="text/css" href="css/mainStyle.css">
    <style type="text/css"> </style>

    <script>
        function changePage(newPage){
            window.location = newPage;
        }
    </script>

</head>
<body>

<div class="headDiv">Send message</div>


<form method="post" action="/createMSG" />
    <div>input phone number</div>
<input type="text" name="phone">

    <BR>
    <div>input message</div>
    <input type="textarea" name="msg">
    <BR>
    <input type="submit" value="send">
</form>

<div>${it.result}</div>


<div class="menuDiv" onclick="changePage('/')">Back to menu</div>
</body>

</html>
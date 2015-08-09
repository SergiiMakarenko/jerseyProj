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

        function checkForEmpty(classNameInput, classNameError ){
            var x=0;
            var input = document.getElementsByClassName(classNameInput);
            var massive = document.getElementsByClassName(classNameError)
            for(i=0;i<input.length;i++){
                if(input[i].value==undefined || input[i].value =='') {
                    massive[i].innerHTML = ('Can not be empty');

                    x++;
                } else{
                    massive[i].innerHTML = ('');
                }
            }
            if(x!=0){
                return false;
            }
            return true;
        }
    </script>

</head>
<body>

<div class="headDiv">Send message</div>


<form onsubmit="return checkForEmpty('check','errorDiv')" method="post" action="/createMSG" />
    <div>input phone number</div>
    <input class="check" type="text" name="phone">
    <div class="errorDiv"></div>
    <BR>
    <div>input message</div>
    <input class="check" type="textarea" name="msg">
    <div class="errorDiv"></div>
    <BR>
    <input type="submit" value="send">
</form>

<div>${it.result}</div>


<div class="menuDiv" onclick="changePage('/')">Back to menu</div>
</body>

</html>
<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Time to get lost!</title>
</head>
<body>
    
    <canvas width="1000" height="750" id="mazeCanvas"></canvas>
    
    <script id="jsonInput" type="application/json">
        ${jsonRoom}
    </script>

    <script src="/script/Maze.js"></script>

</body>
</html>
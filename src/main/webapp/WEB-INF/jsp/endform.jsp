<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sweet Freedom!</title>
</head>
<body>

    <h1>You've escaped from the maze</h1>
    <h2>It took you</h2>
    <p>${mazeDuration} seconds</p>
    <p>Insert your name so I register it in the halls of fame, for centuries to come</p>
    <form action="/endform" method="post">
        <label for="playerName">Name: </label>
        <input type="text" name="playerName" id="playerName">
        <input type="submit" value="Submit">
    </form>

</body>
</html>
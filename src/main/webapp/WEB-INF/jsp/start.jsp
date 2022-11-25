<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Select Maze</title>
</head>
<body>

    <div id="mazeSelectForm">
        <h1>Select Maze</h1>

        <form method="post" action="/start">
            <label for="mazeSelection"></label>
            <select id="mazeSelection" name="mapid">
                <option value="1">Maze A</option>
            </select>
            <input type="submit" value="Select">
        </form>
    </div>

</body>
</html>
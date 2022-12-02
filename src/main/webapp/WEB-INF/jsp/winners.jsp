<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hall of fame</title>
        <link rel="stylesheet" href="/style/style.css">
    </head>
    <body>
        
        <table>

            <tr>
                <th>Name</th>
                <th>Maze</th>
                <th>Time</th>
            </tr>

            <c:forEach items="${winners}" var="winner">
                <tr>
                    <td class="displayName">
                        ${winner.playerName}
                    </td>
                    <td class="displayMaze">
                        ${winner.gameVersion}
                    </td>
                    <td class="displayTime">
                        ${winner.gameLength}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
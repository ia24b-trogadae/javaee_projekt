<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rezepte</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap');
        body {
            font-family: 'Pacifico', cursive;
            text-align: center;
            background-color: #ffe4e1;
            color: #ff1493;
        }
        h1 {
            font-size: 2em;
        }
        .container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
            max-width: 600px;
            margin: auto;
            padding: 20px;
        }
        .rezept {
            background: white;
            padding: 10px;
            margin-bottom: 60px;
            border-radius: 15px;
            border: 3px solid #ff1493;
            text-align: center;
            height: 200px;
        }
        .rezept img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 10px;
            background: #d3d3d3;
            display: block;
        }
        .rezept h2 {
            font-size: 1.5em;
            color: #ff1493;
            margin-top: 10px;
        }
        .rezept img:hover {
            opacity: 0.5;
            cursor: pointer;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>Rezepte</h1>

<div class="container">
    <c:forEach var="rezept" items="${rezepteListe}" begin="0" end="7">
        <div class="rezept">
            <a href="VorlageServlet?id=${rezept.rezeptId}">
                <img src="${rezept.bild}" alt="${rezept.titel}">
                <h2>${rezept.titel}</h2>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>
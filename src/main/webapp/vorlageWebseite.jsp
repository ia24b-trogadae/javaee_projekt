<!--Vorlage für die Kuchenrezepte-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${rezept.titel} Rezept</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap');
        body {
            font-family: 'Pacifico', cursive;
            background-color: ${rezept.farbe4};
            color: ${rezept.farbe1};
            text-align: center;
            padding: 20px;
            background-size: cover;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border: 5px dashed ${rezept.farbe2};
        }
        h1 {
            color: ${rezept.farbe3};
            text-shadow: 2px 2px ${rezept.farbe2};
        }
        img {
            width: 100%;
            border-radius: 10px;
            border: 3px solid ${rezept.farbe3};
        }
        ul {
            text-align: left;
            display: inline-block;
            background: ${rezept.farbe4};
            padding: 10px;
            border-radius: 10px;
            border: 2px solid ${rezept.farbe2};
        }
        .button {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 20px;
            background-color: ${rezept.farbe2};
            color: white;
            text-decoration: none;
            border-radius: 25px;
            font-size: 18px;
            box-shadow: 2px 2px 5px rgba(0,0,0,0.2);
            transition: 0.3s;
        }
        .button:hover {
            background-color: ${rezept.farbe3};
            transform: scale(1.1);
        }
        .cute-icon {
            font-size: 24px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>${rezept.emoji} ${rezept.titel} 🍰</h1>
    <img src="${rezept.bild}" alt="${rezept.titel}">
    <h2>Zutaten:</h2>
    <ul>
        <c:forEach var="zutaten" items="${rezept.zutaten}">
            <li>${zutaten}</li>
        </c:forEach>
    </ul>
    <h2>Zubereitung:</h2>
    <p>${rezept.zubereitung}</p>
    <a href="index.jsp" class="button">${rezept.emoji} Weitere Rezepte 🎀</a>
</div>
<a href="rezensionen.jsp?rezeptId=${rezept.rezeptId}" class="button">📝 Rezensionen</a>
</body>
</html>
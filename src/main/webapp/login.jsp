<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Einloggen</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap');

        body {
            font-family: 'Pacifico', cursive, sans-serif;
            text-align: center;
            background-color: #ffe4e1;
            color: #ff1493;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        h1 {
            font-size: 2em;
            margin-bottom: 10px;
        }

        .login-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: auto;
        }

        .input-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 8px;
            margin-bottom: 10px;
        }

        .input-field {
            width: 250px;
            padding: 10px;
            border: 2px solid #ff1493;
            border-radius: 20px;
            background: white;
            font-size: 1em;
            text-align: center;
        }

        .login-button {
            background-color: #ff69b4;
            color: white;
            border: none;
            padding: 12px 30px;
            border-radius: 30px;
            font-size: 1.2em;
            cursor: pointer;
            margin-top: 10px;
            font-family: 'Pacifico', cursive, sans-serif;
        }

        .login-button:hover {
            background-color: #ff1493;
        }

        .error-message {
            color: red;
            font-size: 1.2em;
            padding: 10px;
            background: rgba(255, 0, 0, 0.1);
            border: 1px solid red;
            border-radius: 10px;
            width: fit-content;
            position: fixed;
            bottom: 20px;
            left: 50%;
            transform: translateX(-50%);
            display: none;
        }
    </style>
</head>
<body>

<h1>Einloggen</h1>

<div class="login-container">
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post" onsubmit="return validateForm()">
        <div class="input-container">
            <input type="text" name="username" class="input-field" placeholder="Name" required>
            <input type="password" name="password" class="input-field" placeholder="Passwort" required>
        </div>
        <button type="submit" class="login-button">🎀 Einloggen 🎀</button>
    </form>
</div>

<% String error = request.getParameter("error"); %>
<% if (error != null) { %>
<p class="error-message" id="errorBox"><%= error %></p>
<script>document.getElementById("errorBox").style.display = "block";</script>
<% } %>

<script>
    function validateForm() {
        var username = document.querySelector('input[name="username"]').value.trim();
        var password = document.querySelector('input[name="password"]').value.trim();
        if (username === "" || password === "") {
            alert("Bitte füllen Sie alle Felder aus.");
            return false;
        }
        return true;
    }
</script>

</body>
</html>

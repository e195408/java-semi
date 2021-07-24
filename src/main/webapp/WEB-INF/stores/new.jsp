<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新規店舗登録</title>
</head>
<body>
<p>店舗情報を入力してください</p>
<form action="/Store/New" method="post">
    <table>
        <tr>
            <td>店舗名</td>
            <td><input type="text" name="name" required /></td>
        </tr>
        <tr>
            <td>詳細</td>
            <td><input type="text" name="details" required /></td>
        </tr>
    </table>
    <input type="submit" name="button" value="登録" >
</form>
</body>
</html>
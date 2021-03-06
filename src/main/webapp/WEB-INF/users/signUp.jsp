<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新規ユーザー情報登録</title>
</head>
<body>
<p>ユーザー情報を入力してください</p>
<form action="/User/SignUp" method="post">
    <table>
        <tr>
            <td>氏名</td>
            <td><input type="text" name="name" required /></td>
        </tr>
        <tr>
            <td>メールアドレス</td>
            <td><input type="email" name="mail" required /></td>
        </tr>
        <tr>
            <td>パスワード</td>
            <td><input type="password" name="ps" maxlength="20" required></td>
        </tr>
        <tr>
            <td>秘密の質問</td>
            <td>
                <select name="question">
                    <option value="0">出身地は？</option>
                    <option value="1">飼っていたペットの名前は？</option>
                    <option value="2">母親の旧姓は？</option>
                    <option value="3">兄弟姉妹の名前は？</option>
                </select>
                →質問の答え
                <input type="answer" name="answer" required />
            </td>
        </tr>
    </table>
    <input type="submit" name="button" value="登録" >
</form>
</body>
</html>
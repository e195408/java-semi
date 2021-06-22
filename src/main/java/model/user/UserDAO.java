package model.user;
//  自分が格納されているフォルダの外にある必要なクラス

import lib.mysql.Client;
import model.user.User;

import java.sql.*;

public class UserDAO extends Client {
    //User登録メソッド
    public static void registUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //SQLコマンド
            String sql = "insert into Users (name,mail,ps,answer,created_at,updated_at,Questions_id) values(?, ?, ?, ?, ?, ?, ?)";

            connection = create();

            //SQLコマンドの実行
            stmt = connection.prepareStatement(sql);

            //現在時間の取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //SQLコマンドの?に値を代入する
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getMail());
            stmt.setString(3, user.getPs());
            stmt.setString(4, user.getAnswer());
            stmt.setTimestamp(5, currentTime);
            stmt.setTimestamp(6, currentTime);
            stmt.setInt(7, user.getQuestionId());

            stmt.executeUpdate();
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally {
            close(connection, stmt, rs);
        }
    }
}
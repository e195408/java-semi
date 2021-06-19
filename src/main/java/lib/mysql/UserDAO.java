package lib.mysql;
//  自分が格納されているフォルダの外にある必要なクラス
import beans.User;

import java.sql.*;

public class UserDAO {
    // データベースの接続先アドレスを静的変数として記述
    private final static String HOST_NAME = "db";
    private final static String DATABASE_NAME = "java_semi";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "root";
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String DRIVER_URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=utf-8";
    // データベースとの接続を行う
    // データベースの接続情報を持ったConnectionオブジェクトを返す
    public Connection createConnection() {
        try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Can't Find JDBC Driver.\n");
        } catch (SQLException e) {
            System.out.println("Connect Error.\n");
            e.printStackTrace();
        }
        return null;
    }
    // Connectionオブジェクトを使って、データベースとの接続を切断する
    // 引数Connectionオブジェクト
    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
    //User登録メソッド
    public void registUser(User user, Connection connection) {
        try {
            //SQLコマンド
            String sql = "insert into Users (name,mail,ps,answer,created_at,updated_at,Questions_id) values(?, ?, ?, ?, ?, ?, ?)";

            //SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);

            //現在時間の取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            //SQLコマンドの?に値を代入する
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserMail());
            stmt.setString(3, user.getUserPs());
            stmt.setString(4, user.getUserAnswer());
            stmt.setTimestamp(5, currentTime);
            stmt.setTimestamp(6, currentTime);
            stmt.setInt(7, user.getQuestionId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
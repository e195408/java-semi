package control;

import beans.User;
import lib.mysql.UserDAO;

import java.sql.Connection;

public class UserManager {

    //属性
    private Connection connection = null;

    //引数を持たないコンストラクタ
    public  UserManager(){
    }

    //User登録する用のメソッド
    public void signUpUser(User user){

        //UserDAOオブジェクト生成
        UserDAO userDAO = new UserDAO();

        //DBとのつながりをつくる
        this.connection = userDAO.createConnection();

        //DAOのメソッドを用いて登録
        userDAO.registUser(user, this.connection);

        //DBとの接続を解除
        userDAO.closeConnection(this.connection);

        //connectionを初期化
        this.connection = null;
    }

}

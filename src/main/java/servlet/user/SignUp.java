package servlet.user;

import beans.User;
import control.UserManager;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/User/SignUp")
public class SignUp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/users/signUp.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //requestオブジェクトから情報を取り出す
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        Integer question = Integer.parseInt(request.getParameter("question"));
        String answer = request.getParameter("answer");

//        System.out.println("取得した文字列は"+ name + "です！");
//        System.out.println("取得した文字列は"+ mail + "です！");
//        System.out.println("取得した文字列は"+ pass + "です！");
//        System.out.println("取得した文字列は"+ question + "です！");
//        System.out.println("取得した文字列は"+ answer +"です！");

        //Userインスタンスの生成
        User user =new User(
                name,
                mail,
                pass,
                question,
                answer
        );

        //UserManagerオブジェクトを生成
        UserManager manager = new UserManager();

        //登録
        manager.signUpUser(user);

        //成功したらsampleTest.javaにGETリクエストを送る
        response.sendRedirect("/test");
    }
}
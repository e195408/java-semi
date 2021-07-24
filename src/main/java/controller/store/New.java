package controller.store;

import model.store.Store;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Store/New")
public class New extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stores/new.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");

        //requestオブジェクトから情報を取り出す
        String name = request.getParameter("name");
        String details = request.getParameter("details");

        System.out.println("取得した文字列は"+ name + "です！");
        System.out.println("取得した文字列は"+ details + "です！");

        //Storeインスタンスの生成
        Store store = new Store(
                null,
                name,
                details,
                null,
                null
        );

        store.registStore();

        //成功したらsampleTest.javaにGETリクエストを送る
        response.sendRedirect("/stores");
    }
}
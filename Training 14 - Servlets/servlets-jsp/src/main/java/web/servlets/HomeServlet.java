package web.servlets;

import db.User;
import util.Keys;
import util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by iciuta on 7/29/2016.
 */
@WebServlet(urlPatterns = "/home")
public class HomeServlet extends AbstractServlet {
    private HttpSession session;
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        session = req.getSession(true);
        user = (User) session.getAttribute(Keys.PARAM_USER);

        Log.i(TAG, "User: " + user.getUsername());
        req.getRequestDispatcher("/jsp/Home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
        String button = req.getParameter("button");
        if(button.equals("val1")) {
            Log.i(TAG, "Sign out");
        } else if(button.equals("val2")) {
            Log.i(TAG, "Delete");
        } else {
            Log.i(TAG, "Error");
        }
    }
}


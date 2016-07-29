package web.servlets;

import db.User;
import db.UserDao;
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
@WebServlet(urlPatterns = "/")
public class SignUpServlet extends AbstractServlet {
    private final String TAG = getClass().getSimpleName();
    private final String PARAM_USERNAME         = "username";
    private final String PARAM_PASSWORD         = "password";
    private final String PARAM_ERROR_PASSWORD   = "passwordError";
    private final String PARAM_ERROR_USERNAME   = "usernameError";
    private final int CHECK_MIN_INPUT           = 3;

    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        req.getRequestDispatcher("/jsp/SignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String username = req.getParameter(PARAM_USERNAME);
        String password = req.getParameter(PARAM_PASSWORD);
        Log.i(TAG, username + " " + password);

        if(username.length() < CHECK_MIN_INPUT) {
            Log.i(TAG, "username error");
            req.setAttribute(PARAM_ERROR_USERNAME, true);
            req.getRequestDispatcher("/jsp/SignUp.jsp").forward(req, resp);
        }

        if(password.length() < CHECK_MIN_INPUT) {
            Log.i(TAG, "password error");
            req.setAttribute(PARAM_ERROR_PASSWORD, true);
            req.setAttribute(PARAM_USERNAME, username);
            req.getRequestDispatcher("/jsp/SignUp.jsp").forward(req, resp);
        }

        try {
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(username);
            UserDao.insert(newUser);

            newUser = UserDao.findUserByName(username);
            Log.i(TAG, "New user has ID: " + newUser.getId());

            session = req.getSession(true);
            session.setAttribute(Keys.PARAM_USER, newUser);

            resp.sendRedirect(req.getContextPath() + "/home");
        } catch (Exception e) {
            Log.i(TAG, e.getMessage());
            e.printStackTrace();
        }
    }
}

package web.servlets;

import util.Log;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by iciuta on 7/29/2016.
 */
public abstract class AbstractServlet extends HttpServlet{
    protected final String TAG = getClass().getSimpleName();

    @Override
    public void init() throws ServletException {
        Log.i(TAG, "init()");
    }

    @Override
    public void destroy() {
        Log.i(TAG, "destroy()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log.i(TAG, "doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log.i(TAG, "doPost()");
    }
}

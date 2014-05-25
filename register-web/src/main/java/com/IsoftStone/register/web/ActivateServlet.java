package com.IsoftStone.register.web;

import com.IsoftStone.register.service.RegisterService;
import com.IsoftStone.register.service.RegisterServiceException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Bachelor Wang on 2014/5/25.
 */
public class ActivateServlet extends HttpServlet {

    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        if (key == null || key.length() == 0) {
            resp.sendError(400, "No activation key provided.");
            return;
        }

        RegisterService service = (RegisterService) context.getBean("registerService");

        try {
            service.activate(key);
            resp.getWriter().write("Account is activated, now you can login.");
        } catch (RegisterServiceException e) {
            resp.sendError(400, "Unable to activate account");
            return;
        }
    }
}

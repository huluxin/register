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
public class LoginServlet extends HttpServlet {

    private ApplicationContext context;

    @Override
    public void init() throws ServletException
    {
        super.init();
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter( "id" );
        String password = req.getParameter( "password" );

        if ( id == null || id.length() == 0 || password == null || password.length() == 0 )
        {
            resp.sendError( 400, "incomplete parameter" );
            return;
        }

        RegisterService service = (RegisterService) context.getBean( "registerService" );

        try
        {
            service.login( id, password );
            resp.getWriter().print( "Login Successful!" );
        }
        catch ( RegisterServiceException e )
        {
            resp.sendError( 400, e.getMessage() );
        }
    }
}

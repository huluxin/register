package com.IsoftStone.register.web;

import com.IsoftStone.register.service.RegisterService;
import com.IsoftStone.register.service.RegisterServiceException;
import com.IsoftStone.register.service.SignUpRequest;
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
public class SignUpServlet extends HttpServlet {

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
        String email = req.getParameter( "email" );
        String name = req.getParameter( "name" );
        String password = req.getParameter( "password" );
        String confirmPassword = req.getParameter( "confirm_password" );
        String captchaKey = req.getParameter( "captcha_key" );
        String captchaValue = req.getParameter( "captcha_value" );

        if ( id == null || id.length() == 0 || email == null || email.length() == 0 || name == null
                || name.length() == 0 || password == null || password.length() == 0 || confirmPassword == null
                || confirmPassword.length() == 0 || captchaKey == null || captchaKey.length() == 0 || captchaValue == null
                || captchaValue.length() == 0 )
        {
            resp.sendError( 400, "Parameter Incomplete." );
            return;
        }

        RegisterService service = (RegisterService) context.getBean("registerService");

        SignUpRequest request = new SignUpRequest();
        request.setId( id );
        request.setEmail(email);
        request.setName(name);
        request.setPassword(password);
        request.setConfirmPassword(confirmPassword);
        request.setCaptchaKey(captchaKey);
        request.setCaptchaValue(captchaValue);

        String url = req.getRequestURL().toString();
        String serverUrl = url.substring(0,url.lastIndexOf("/") + 1);
   //     request.setActivateServiceUrl( getServletContext().getRealPath( "/" ) + "activate" );
        request.setActivateServiceUrl(serverUrl  + "activate");
        try{
           service.signUp( request );

           resp.getWriter().print( "register Success, please use email to Activate you account!!!" );
        }catch (RegisterServiceException e){
            resp.sendError( 400, e.getMessage() );
            return;
        }
    }
}

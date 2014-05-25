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
import java.io.OutputStream;

/**
 * Created by Bachelor Wang on 2014/5/25.
 */
public class CaptchaImageServlet extends HttpServlet {

    private ApplicationContext context;

    @Override
    public void init() throws ServletException {
        super.init();
        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,IOException {

        String key = request.getParameter("key");
        if(key == null || key.length() == 0){
            response.sendError( 400, "No Captcha Key Found" );
        }else{
            RegisterService service = (RegisterService) context.getBean("registerService");

            try{
                response.setContentType("image/jpeg");
                OutputStream out = response.getOutputStream();
                out.write(service.generateCaptchaImage(key));

                out.close();
            }catch (RegisterServiceException e){
                response.sendError(400,e.getMessage());
            }
        }
    }
}

//package com.todo.api.security.handler;
//
//import com.google.gson.Gson;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Map;
//
//public class APILoginFailHandler implements AuthenticationFailureHandler {
//    private static final Logger log = LoggerFactory.getLogger(APILoginFailHandler.class);
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        log.info("Login fail...." + exception);
//
//        Gson gson = new Gson();
//
//        String jsonStr = gson.toJson(Map.of("error", "ERROR_LOGIN"));
//
//        response.setContentType("application/json");
//        PrintWriter printWriter = response.getWriter();
//        printWriter.println(jsonStr);
//        printWriter.close();
//    }
//}

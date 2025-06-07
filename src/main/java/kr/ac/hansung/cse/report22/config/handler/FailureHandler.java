// CustomAuthenticationFailureHandler.java
package kr.ac.hansung.cse.report22.config.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse res,
                                        AuthenticationException ex) throws IOException, ServletException {
        req.getSession().setAttribute("loginErrorMessage",
                "로그인에 실패하였습니다: " + ex.getMessage());
        res.sendRedirect("/login?error");
    }
}

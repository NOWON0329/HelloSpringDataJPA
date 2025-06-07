// CustomAuthenticationSuccessHandler.java
package kr.ac.hansung.cse.report22.config.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse res,
                                        Authentication auth) throws IOException, ServletException {
        String username = auth.getName();
        // 세션에 메시지 저장 (혹은 FlashAttribute)
        req.getSession().setAttribute("loginSuccessMessage",
                "안녕하세요, " + username + "님! 성공적으로 로그인하였습니다.");
        // 원하는 경로로 리다이렉트
        res.sendRedirect("/products");
    }
}

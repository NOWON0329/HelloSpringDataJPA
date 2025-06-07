package kr.ac.hansung.cse.report22.config.Handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        // FlashMap 대신 세션에 직접 저장
        request.getSession().setAttribute("successMsg",
                authentication.getName() + "님, 환영합니다!");

        // 로그인 후 리다이렉트
        response.sendRedirect("/products");
    }
}

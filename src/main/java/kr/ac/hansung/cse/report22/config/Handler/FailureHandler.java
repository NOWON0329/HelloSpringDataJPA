package kr.ac.hansung.cse.report22.config.Handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.io.IOException;

@Component
public class FailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse res,
                                        AuthenticationException ex)
            throws IOException {
        RequestContextUtils.getOutputFlashMap(req)
                .put("errorMsg", "로그인에 실패했습니다: " + ex.getMessage());
        res.sendRedirect("/login?error");
    }
}
package fi.tuomas.chassis.loggingapi.interceptor;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;
import fi.tuomas.chassis.loggingapi.annotation.Audited;

@Component
@Slf4j
public class AuditInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            Optional.ofNullable(((HandlerMethod) handler).getMethodAnnotation(Audited.class)).ifPresent(a -> {
                log.info("Audit {} {} {}", request, response, handler);
            });
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (handler instanceof HandlerMethod) {
            Optional.ofNullable(((HandlerMethod) handler).getMethodAnnotation(Audited.class)).ifPresent(a -> {
                log.info("Audited {} {} {}", request, response, handler);
            });
        }
    }
}

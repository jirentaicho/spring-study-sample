package com.volkruss.misaka.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 設定ファイル
 * com.volkruss.misaka.config.WebMvcConfig
 */
@Component
@Slf4j
public class RequestTracking extends AbstractInterceptor {

    private static final ThreadLocal<Long> startTimeHolder = new ThreadLocal<>();

    //コントローラーの動作前
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long beforeTime = System.nanoTime();
        startTimeHolder.set(beforeTime);

        log.info("処理開始" + this.getHandlerMethodDesc(handler));
        return true;
    }

    //コントローラーの操作後
    @Override
    public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {
        long beforTime = startTimeHolder.get();
        long totalTime = System.nanoTime() - beforTime;
        long sec = TimeUnit.NANOSECONDS.toSeconds(totalTime);

        log.info("処理時間" + sec + " 秒 " + "処理終了" + this.getHandlerMethodDesc(handler));
    }
}

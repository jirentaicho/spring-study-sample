package com.volkruss.misaka.aop;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;
@Component
public class AuthUpdateInterceptor extends AbstractAuthInterceptor{
    //コントローラーの動作前
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 権限KEYを持っているか検査する
        boolean isAllowed = this.hasAuthority("update");
        // 権限がない場合は例外とする
        if(!isAllowed){
            throw new AccessDeniedException("更新権限がありません。");
        }
        return true;
    }
}

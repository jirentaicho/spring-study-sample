package com.volkruss.misaka.aop;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.AccessDeniedException;

@Component
public class AuthDeleteInterceptor extends AbstractAuthInterceptor{
    //コントローラーの動作前
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 権限KEYを持っているか検査する
        boolean isAllowed = this.hasAuthority("delete");
        // 権限がない場合は例外とする
        if(!isAllowed){
            throw new AccessDeniedException("削除権限がありません。");
        }
        return true;
    }
}

package com.volkruss.misaka.aop;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Collection;
import java.util.stream.Collectors;


public abstract class AbstractAuthInterceptor implements HandlerInterceptor {

    /**
     * ログイン中のユーザーが渡された権限KEYを持っているかどうか確認します。
     * 持っている場合 true
     * 持っていない場合 false
     *
     * @return boolean 権限有無
     */
    protected final boolean hasAuthority(final String key){
        // 認証情報を取得する
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // GrantedAuthorityのCollectionを取得して、KEYに一致するものがあるか検査する
        Collection<? extends GrantedAuthority> grants = auth.getAuthorities();
        // 一度文字列のリストにしてから検索します。
        int result = grants.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).indexOf(key);

        if(result == -1){
            return false;
        }
        return true;
    }

}

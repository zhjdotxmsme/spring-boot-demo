package com.example.demo.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月21日 16:14
 * @modified By
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String,AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();

        AtomicInteger retryCount = passwordRetryCache.get(username);
        if( null == retryCount){
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username,retryCount);
        }

        if (retryCount.getAndIncrement() > 5){
            throw new ExcessiveAttemptsException("密码输入错误次数超过 5 次");
        }
        boolean match = super.doCredentialsMatch(token,info);
        if (match){
            passwordRetryCache.remove(username);
        }
        return match;
    }
}

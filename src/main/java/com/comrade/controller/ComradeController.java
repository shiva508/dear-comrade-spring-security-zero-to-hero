package com.comrade.controller;

import org.springframework.security.concurrent.DelegatingSecurityContextCallable;
import org.springframework.security.concurrent.DelegatingSecurityContextExecutorService;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api/v1")
public class ComradeController {

    @GetMapping("/welcome")
    public Map<String, String> helloSecurity() throws ExecutionException, InterruptedException {
        Callable<String> securityContext = ()->{
            SecurityContext context = SecurityContextHolder.getContext();
            return context.getAuthentication().getName();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        /**
         * Approach-1
         */
//
//        DelegatingSecurityContextCallable<String> contextCallable = new DelegatingSecurityContextCallable<>(securityContext);
//        String securityName = executorService.submit(contextCallable).get();
        /**
         * Approach-2
         */
        executorService = new DelegatingSecurityContextExecutorService(executorService);
        String securityName = executorService.submit(securityContext).get();
        return Map.of("name","Shiva","sec",securityName);
    }
}

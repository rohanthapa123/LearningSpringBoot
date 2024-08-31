package com.transaction.Transaction.Demo.config;

import com.transaction.Transaction.Demo.interceptor.AuthenticationInterceptor;
import com.transaction.Transaction.Demo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoggingInterceptor())
               .order(2);
//       registry.addInterceptor(new AuthenticationInterceptor())
//               .order(1)
//               .addPathPatterns("/api/bank/transfer");
    }
}

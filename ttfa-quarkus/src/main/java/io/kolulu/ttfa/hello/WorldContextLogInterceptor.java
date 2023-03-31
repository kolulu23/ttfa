package io.kolulu.ttfa.hello;

import io.quarkus.arc.Priority;
import lombok.extern.slf4j.Slf4j;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


@Interceptor
@WorldInterceptor
@Priority(1)
@Slf4j
public class WorldContextLogInterceptor {

    @AroundInvoke
    Object logContextData(InvocationContext invocationContext) throws Exception {
        Object ret = invocationContext.proceed();
        invocationContext.getContextData().forEach((k, v) -> log.info("{} -> {}", k, v));
        return ret;
    }
}

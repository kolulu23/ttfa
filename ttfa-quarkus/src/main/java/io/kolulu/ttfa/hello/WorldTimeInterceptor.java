package io.kolulu.ttfa.hello;

import io.quarkus.arc.Priority;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.Duration;
import java.time.Instant;

@WorldInterceptor
@Priority(2)
@Interceptor
public class WorldTimeInterceptor {
    public static final String CTX_KEY_PREFIX = "TimeCost-";

    @AroundInvoke
    Object reportTime(InvocationContext invocationContext) throws Exception {
        Instant now = Instant.now();
        Object ret = invocationContext.proceed();
        Instant after = Instant.now();
        Duration elapsed = Duration.between(now, after);

        String methodName = invocationContext.getMethod().getName();
        String ctxKey = CTX_KEY_PREFIX + methodName;
        invocationContext.getContextData().put(ctxKey, elapsed);
        return ret;
    }
}

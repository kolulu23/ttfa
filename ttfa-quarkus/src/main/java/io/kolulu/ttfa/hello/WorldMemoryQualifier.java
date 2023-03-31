package io.kolulu.ttfa.hello;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface WorldMemoryQualifier {
    /**
     * If a memory is long term, it got to be persisted somewhere else or hardcoded
     */
    boolean longTerm();

    boolean readonly() default false;
}

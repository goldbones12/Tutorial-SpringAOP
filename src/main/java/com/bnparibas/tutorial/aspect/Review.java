package com.bnparibas.tutorial.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * Title: Review interface
 * Description: Annotation definition
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Review {
	String method();
}

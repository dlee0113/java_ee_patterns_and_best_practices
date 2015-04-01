package de.twitterng.business.messaging.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
@Documented
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=TweetValidatr.class)
public @interface ValidTweet {
    String message() default "To stupid to tweet!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    String expected();
}
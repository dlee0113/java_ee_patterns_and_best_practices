package de.twitterng.business.messaging.entity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Adam Bien <blog.adam-bien.com>
 */
public class TweetValidatr implements ConstraintValidator<ValidTweet, String> {

    private ValidTweet annotation;
    
    @Override
    public void initialize(ValidTweet constraintAnnotation) {
        annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
         return (annotation.expected().equalsIgnoreCase(value));
    }

}

package com.vehicles.annotation;

import javax.validation.Payload;

public @interface ValidateDate {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    String message() default "";
    String pattern();
}

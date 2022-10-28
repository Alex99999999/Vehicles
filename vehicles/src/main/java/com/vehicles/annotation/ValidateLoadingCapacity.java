package com.vehicles.annotation;

//TODO implement

import javax.validation.Payload;

public @interface ValidateLoadingCapacity {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    String message() default "";

}

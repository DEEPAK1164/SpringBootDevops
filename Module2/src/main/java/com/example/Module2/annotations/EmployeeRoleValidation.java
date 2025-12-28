package com.example.Module2.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy= {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {
	   String message() default "Invalid employee role";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
}

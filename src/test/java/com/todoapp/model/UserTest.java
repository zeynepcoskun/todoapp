package com.todoapp.model;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class UserTest {


 public Validator validator;

    @Before
    public void setUp() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenAllFieldsBlank_ConstraintsViolated(){
        User myuser = new User();
        myuser.setTitle(null);
        myuser.setFirstName(null);
        myuser.setLastName("test");
        myuser.setEmail(null);
        Set<ConstraintViolation<User>> violations = validator.validate(myuser);
        assertEquals(3, violations.size());
    }
}
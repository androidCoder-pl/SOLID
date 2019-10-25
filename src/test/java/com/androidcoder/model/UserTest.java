package com.androidcoder.model;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class UserTest {

    @Test
    public void testPOJOClass() {
        PojoClass userPojo = PojoClassFactory.getPojoClass(User.class);
        ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new GetterTester()).build().validate(userPojo);
    }

    @Test
    public void testEqualsContract(){
        EqualsVerifier.forClass(User.class).verify();
    }
}
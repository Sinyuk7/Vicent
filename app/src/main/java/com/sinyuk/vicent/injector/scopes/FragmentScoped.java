package com.sinyuk.vicent.injector.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sinyuk on 2016/12/21.
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScoped {
}
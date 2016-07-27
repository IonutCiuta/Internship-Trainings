package com.endava.patterns.visitor;

/**
 * Created by rburlacioiu on 7/22/2016.
 */
public interface Element {

    int accept(Visitor visitor);
}

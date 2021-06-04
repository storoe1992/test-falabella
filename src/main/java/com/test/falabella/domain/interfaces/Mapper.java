package com.test.falabella.domain.interfaces;

public interface Mapper <E,O> {

    O map(E e);
    E reverse(O eo);
}

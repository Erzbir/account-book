package com.erzbir.accountbook.entity;

import java.util.stream.Stream;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface EntityContainer<K, E> {
    void add(E e);

    E get(K key);

    void remove(K key);

    boolean contains(E e);

    Stream<E> stream();
}

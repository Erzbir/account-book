package com.erzbir.accountbook.entity;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface MapEntityContainer<K, E> extends EntityContainer<K, E> {
    Map<K, E> getItems();

    @Override
    default Stream<E> stream() {
        return getItems().values().stream();
    }
}

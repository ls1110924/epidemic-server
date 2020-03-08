package com.example.epidemic.utils;

import java.util.*;

public class CollectionUtils {

    public static <T> Collection<T> wrapNullCollection(Collection<T> collection) {
        return collection == null ? Collections.<T>emptySet() : collection;
    }

    /**
     * 将一个null列表包装成一个空列表，避免空指针异常
     *
     * @param list 原始列表，可以为null
     * @param <T>  元素类型
     * @return 包装后的不为null的列表
     */
    public static <T> List<T> wrapNullList(List<T> list) {
        return list == null ? Collections.<T>emptyList() : list;
    }

    public static <T> Set<T> wrapNullSet(Set<T> set) {
        return set == null ? Collections.<T>emptySet() : set;
    }

    public static <K, V> Map<K, V> wrapNullMap(Map<K, V> map) {
        return map == null ? Collections.<K, V>emptyMap() : map;
    }

    /**
     * 包装成一个可编辑的Map
     */
    public static <K, V> Map<K, V> convertEditableMap(Map<K, V> map) {
        return new HashMap<K, V>(wrapNullMap(map));
    }

    public static boolean isEmpty(Map<?, ?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static int size(Collection<?> collection) {
        return collection != null ? collection.size() : 0;
    }

}

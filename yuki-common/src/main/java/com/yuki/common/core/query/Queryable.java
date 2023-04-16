package com.yuki.common.core.query;

import org.springframework.data.jpa.domain.Specification;

public interface Queryable<T> extends Specification<T> {
}

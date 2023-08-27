package com.yuki.framework.dict.web;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.dict.DictType;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Conjunction(
        value = {
                @Or({
                        @Spec(params = Constants.SEARCH_KEYWORD_FIELD, path = DictType.TYPE_FIELD, spec = Like.class),
                        @Spec(params = Constants.SEARCH_KEYWORD_FIELD, path = DictType.TYPE_FIELD, jsonPaths = Constants.SEARCH_KEYWORD_FIELD, spec = Like.class),
                        @Spec(params = Constants.SEARCH_KEYWORD_FIELD, path = DictType.NAME_FIELD, spec = Like.class),
                        @Spec(params = Constants.SEARCH_KEYWORD_FIELD, path = DictType.NAME_FIELD, jsonPaths = Constants.SEARCH_KEYWORD_FIELD, spec = Like.class),
                }),
        },
        and = {
                @Spec(params = DictType.TYPE_FIELD, path = DictType.TYPE_FIELD, spec = Like.class),
                @Spec(params = DictType.TYPE_FIELD, path = DictType.TYPE_FIELD, jsonPaths = DictType.TYPE_FIELD, spec = Like.class),
                @Spec(params = DictType.NAME_FIELD, path = DictType.NAME_FIELD, spec = Like.class),
                @Spec(params = DictType.NAME_FIELD, path = DictType.NAME_FIELD, jsonPaths = DictType.NAME_FIELD, spec = Like.class),
                @Spec(params = DictType.BUILTIN_FIELD, path = DictType.BUILTIN_FIELD, spec = Equal.class),
                @Spec(params = DictType.BUILTIN_FIELD, path = DictType.BUILTIN_FIELD, jsonPaths = DictType.BUILTIN_FIELD, spec = Equal.class),
        }
)
public interface DictTypeSearchSpecification extends Specification<DictType> {

}

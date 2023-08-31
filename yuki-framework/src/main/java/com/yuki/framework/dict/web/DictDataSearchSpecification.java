package com.yuki.framework.dict.web;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.domain.entity.BaseEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Conjunction;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Conjunction(
        value = {
                @Or({
                        @Spec(params = Constants.SEARCH_KEYWORD_FIELD, path = DictData.CODE_FIELD, spec = Like.class),
                        @Spec(jsonPaths = Constants.SEARCH_KEYWORD_FIELD, path = DictData.CODE_FIELD, spec = Like.class),
                        @Spec(params = Constants.SEARCH_KEYWORD_FIELD, path = DictData.NAME_FIELD, spec = Like.class),
                        @Spec(jsonPaths = Constants.SEARCH_KEYWORD_FIELD, path = DictData.NAME_FIELD, spec = Like.class),
                }),
        },
        and = {
                @Spec(params = DictData.CODE_FIELD, path = DictData.CODE_FIELD, spec = Like.class),
                @Spec(jsonPaths = DictData.CODE_FIELD, path = DictData.CODE_FIELD, spec = Like.class),
                @Spec(params = DictData.NAME_FIELD, path = DictData.NAME_FIELD, spec = Like.class),
                @Spec(jsonPaths = DictData.NAME_FIELD, path = DictData.NAME_FIELD, spec = Like.class),
                @Spec(params = DictData.DISABLED_FIELD, path = DictData.DISABLED_FIELD, spec = Equal.class),
                @Spec(jsonPaths = DictData.DISABLED_FIELD, path = DictData.DISABLED_FIELD, spec = Equal.class),
                @Spec(params = DictData.DICT_TYPE_FIELD_SUFFIX + BaseEntity.ID_FIELD, path = DictData.DICT_TYPE_FIELD_SUFFIX + BaseEntity.ID_FIELD, spec = Equal.class),
                @Spec(jsonPaths = DictData.DICT_TYPE_FIELD_SUFFIX + BaseEntity.ID_FIELD, path = DictData.DICT_TYPE_FIELD_SUFFIX + BaseEntity.ID_FIELD, spec = Equal.class),
        }
)
public interface DictDataSearchSpecification extends Specification<DictData> {

}

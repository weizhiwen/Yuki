package com.yuki.admin.position.web;

import com.yuki.admin.position.dao.Position;
import com.yuki.common.core.domain.entity.BaseEntity;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(params = Position.DEPARTMENT_SUFFIX + BaseEntity.ID_FIELD, path = Position.DEPARTMENT_SUFFIX + BaseEntity.ID_FIELD, spec = Equal.class),
        @Spec(jsonPaths = Position.DEPARTMENT_SUFFIX + BaseEntity.ID_FIELD, path = Position.DEPARTMENT_SUFFIX + BaseEntity.ID_FIELD, spec = Equal.class),
        @Spec(params = Position.CODE_FIELD, path = Position.CODE_FIELD, spec = Like.class),
        @Spec(jsonPaths = Position.CODE_FIELD, path = Position.CODE_FIELD, spec = Like.class),
        @Spec(params = Position.NAME_FIELD, path = Position.NAME_FIELD, spec = Like.class),
        @Spec(jsonPaths = Position.NAME_FIELD, path = Position.NAME_FIELD, spec = Like.class),
        @Spec(params = Position.TITLE_FIELD, path = Position.TITLE_FIELD, spec = Like.class),
        @Spec(jsonPaths = Position.TITLE_FIELD, path = Position.TITLE_FIELD, spec = Like.class),
        @Spec(params = Position.PROPERTY_FIELD, path = Position.PROPERTY_FIELD, spec = Equal.class),
        @Spec(jsonPaths = Position.PROPERTY_FIELD, path = Position.PROPERTY_FIELD, spec = Equal.class),
        @Spec(params = Position.DISABLED_FIELD, path = Position.DISABLED_FIELD, spec = Equal.class),
        @Spec(jsonPaths = Position.DISABLED_FIELD, path = Position.DISABLED_FIELD, spec = Equal.class),
})
public interface PositionSearchSpecification extends Specification<Position> {

}

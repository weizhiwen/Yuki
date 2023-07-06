package com.yuki.common.core.reader;

import com.yuki.common.core.exception.BaseException;
import lombok.Getter;
import org.springframework.core.convert.ConversionService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseReader<S, T> {
    private Class<S> sourceClass;
    private Class<T> targetClass;

    @Resource
    @Getter
    private ConversionService conversionService;

    private ThreadLocal<T> target = new ThreadLocal<>();
    private ThreadLocal<List<T>> targetList = new ThreadLocal<>();

    @PostConstruct
    protected void init() {
        sourceClass = (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        targetClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public void setTarget(T target) {
        this.target.set(target);
    }

    public T getTarget() {
        return target.get();
    }

    public T fetchTarget() {
        T t = target.get();
        clear();
        return t;
    }

    public void clear() {
        target.remove();
        targetList.remove();
    }

    public void setTargetList(List<T> targetList) {
        this.targetList.set(targetList);
    }

    public List<T> getTargetList() {
        List<T> list = this.targetList.get();
        if (list == null) {
            list = new ArrayList<>();
            this.targetList.set(list);
        }
        return list;
    }

    public List<T> fetchTargetList() {
        List<T> list = getTargetList();
        clear();
        return list;
    }

    protected void addToTargetList(T target) {
        getTargetList().add(target);
    }

    public void read(Iterable<S> sourceList) {
        if (sourceList == null) {
            setTargetList(Collections.emptyList());
        } else {
            clear();
            checkConvert();
            sourceList.forEach(s -> {
                setTarget(conversionService.convert(s, targetClass));
                T t = getTarget();
                postListItem(s, t);
                if (t != null) {
                    addToTargetList(t);
                }
            });
        }
    }

    private void checkConvert() {
        if (!conversionService.canConvert(sourceClass, targetClass)) {
            throw new BaseException("common.convert.not.supported", sourceClass, targetClass);
        }
    }

    protected void postListItem(S source, T target) {
        postDetails(source, target);
    }

    public void read(S source) {
        if (source == null) {
            setTarget(null);
        }
        checkConvert();
        setTarget(conversionService.convert(source, targetClass));
        postDetails(source, getTarget());
    }

    protected void postDetails(S source, T target) {

    }
}

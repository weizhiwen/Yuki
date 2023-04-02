package com.ruoyi.common.core.reader;

import com.ruoyi.common.core.domain.BaseData;
import org.springframework.core.convert.ConversionService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseReader<S extends BaseData, T extends BaseData> {
    private Class<T> targetClass;

    @Resource
    protected ConversionService conversionService;

    private ThreadLocal<T> target = new ThreadLocal<>();
    private ThreadLocal<List<T>> targetList = new ThreadLocal<>();

    @PostConstruct
    protected void init() {
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
        List<T> targetList = this.targetList.get();
        if (targetList == null) {
            targetList = new ArrayList<>();
            this.targetList.set(targetList);
        }
        return targetList;
    }

    public List<T> fetchTargetList() {
        List<T> targetList = this.targetList.get();
        clear();
        return targetList;
    }

    protected void addToTargetList(T target) {
        getTargetList().add(target);
    }

    public void read(List<S> souceList) {
        if (souceList == null) {
            setTargetList(Collections.emptyList());
        } else {
            clear();
            souceList.forEach(s -> {
                setTarget(conversionService.convert(s, targetClass));
                T target = getTarget();
                postListItem(s, target);
                if (target != null) {
                    addToTargetList(target);
                }
            });
        }
    }

    protected void postListItem(S source, T target) {

    }

    public void read(S source) {
        if (source == null) {
            setTarget(null);
        }
        setTarget(conversionService.convert(source, targetClass));
        postDetails(source, getTarget());
    }

    protected void postDetails(S source, T target) {

    }
}

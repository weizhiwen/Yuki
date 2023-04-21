package com.yuki.common.core.dict;

import java.util.Objects;

public class Dict {
    private String code;

    private String name;

    public Dict() {
    }

    public Dict(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dict dict = (Dict) o;
        return code.equals(dict.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

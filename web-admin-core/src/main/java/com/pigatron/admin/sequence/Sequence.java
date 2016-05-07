package com.pigatron.admin.sequence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Sequence {

    @Id private String id;
    @Indexed(unique = true) private String name;
    private int value;

    public Sequence(String name, int startValue) {
        this.name = name;
        this.value = startValue;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNextValue() {
        value += 1;
        return value;
    }

    public int getValue() {
        return value;
    }
}

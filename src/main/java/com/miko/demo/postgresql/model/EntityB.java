package com.miko.demo.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * The MIT License
 *
 * Copyright 2014 Miroslav Kopecky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/2/14
 */

@Entity
@Table(name= EntityB.TABLE)
public class EntityB extends AbstractEntity implements GeneralVariables{
    public static final String TABLE = "EntityB";

    @Column(name=NAME, nullable=true)
    private String name;

    @Column(name=VALUE, nullable=true)
    private Long value;

    @ManyToOne
    private EntityA parent;

    public EntityB() {
    }

    public EntityB(String name, Long value, EntityA parent) {
        this.name = name;
        this.value = value;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public EntityA getParent() {
        return parent;
    }

    public void setParent(EntityA parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "EntityB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
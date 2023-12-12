package com.Probeprojekt.demo.models;

public class FeedBackItemAbstract<T> implements FeedbackItem<T>{
 protected String name;
 protected T value;
 public FeedBackItemAbstract(String name) {
     this.name = name;
 }
    public FeedBackItemAbstract() {}
    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

package com.Probeprojekt.demo.models;

public interface FeedbackItem<T> {
    T getValue();
  void setValue(T value);
    String getName();
    void setName(String name);

}

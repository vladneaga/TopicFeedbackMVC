package com.Probeprojekt.demo.models;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Topic {
   private static Integer counter = 0;
    private int id;

    String title;
    String text;
    String date;
    Double starRating;
    List<Feedback> feedbackList;
public Topic() {
    this.feedbackList = new ArrayList<>();
    this.id = counter++;
    this.starRating = 0.0;
}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

        public void setStarRating(Double mark) {
        this.starRating = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getStarRating() {
        if(starRating == null) return 0;
        starRating = feedbackList.stream()
                .filter(feedback -> feedback.starFeedbackItem != null)
                .mapToDouble(feedback -> feedback.starFeedbackItem.getValue())  // Assuming 'value' is the field name
                .sum()
        /feedbackList.size();
        return starRating;
    }
}

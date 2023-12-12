package com.Probeprojekt.demo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Feedback {

    static private  Integer counter = 0;
    int id;
    int topicId;
    FeedbackItem<Integer> numberFeedbackItem;
    FeedbackItem<Boolean> yesNoFeedbackItem;
    FeedbackItem<String> textFeedbackItem;
    FeedbackItem<Integer> percentFeedbackItem;
    FeedbackItem<Integer> starFeedbackItem;


    List<FeedbackItem<?>> feedbackItemList;
   public Feedback() {
           this.id = counter++;
           feedbackItemList = new ArrayList<>();
           initializeFeedbackItemList();
           this.setNumberFeedbackItemValue(1);
    }
public void initializeFeedbackItemList() {
        numberFeedbackItem = new NumberFeedbackItem("Mark(1-6): ");
        yesNoFeedbackItem = new YesNoFeedbackItem("Overall compliance with the idea: ");
        textFeedbackItem = new TextFeedbackItem("Comment: ");
        percentFeedbackItem = new PercentFeedbackItem("Relevance: ");
        starFeedbackItem = new StarFeedbackItem("Overall impression: ");
       this.feedbackItemList.add(numberFeedbackItem);
       this.feedbackItemList.add(yesNoFeedbackItem);
       this.feedbackItemList.add(textFeedbackItem);
       this.feedbackItemList.add(percentFeedbackItem);
       this.feedbackItemList.add(starFeedbackItem);
}

    public List<FeedbackItem<?>> getFeedbackItemList() {
        return feedbackItemList;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setNumberFeedbackItemValue(Integer value) {
       this.numberFeedbackItem.setValue(value);
    }
    public void setYesNoFeedbackItemValue(Boolean value) {
       this.yesNoFeedbackItem.setValue(value);
    }
    public void setPercentFeedbackItemValue(Integer value) {
       this.percentFeedbackItem.setValue(value);
    }
    public void setTextFeedbackItemValue(String value) {
       this.textFeedbackItem.setValue(value);
    }
    public void setStarFeedbackItemValue(Integer value) {
       this.starFeedbackItem.setValue(value);
    }
}

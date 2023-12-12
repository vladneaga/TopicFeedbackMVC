package com.Probeprojekt.demo.services;

import com.Probeprojekt.demo.models.Feedback;
import com.Probeprojekt.demo.models.Topic;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {
    List<Topic> topicList;
    TopicService() {
        topicList  = new ArrayList<>();
        fullWithData();
    }

    public void fullWithData() {
        for (int i = 0; i < 3; i++) {
            Topic topic = new Topic();
            topic.setTitle("Title " + (i + 1));
            topic.setText("Text " + (i + 1));
                  topic.setDate( "Date " + (i + 1));
                  Feedback feedback = new Feedback();
                  feedback.setTopicId(topic.getId());
                  feedback.setStarFeedbackItemValue(1);
                  topic.addFeedback(feedback);
            topicList.add(topic);
        }
    }
    public List<Topic> getTopicList() {
        return this.topicList;
    }
    public Topic findTopicById(int id) {
        for(Topic topic: topicList) {
            if(topic.getId() == id) return topic;
        }
        return null;
    }

}

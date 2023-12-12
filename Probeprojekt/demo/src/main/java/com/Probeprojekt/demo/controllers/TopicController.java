package com.Probeprojekt.demo.controllers;

import com.Probeprojekt.demo.models.Feedback;
import com.Probeprojekt.demo.models.Topic;
import com.Probeprojekt.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;
@GetMapping("")
public String index(Model model) {
    model.addAttribute("topics", topicService.getTopicList());
    return "topicIndex";
    }
    @GetMapping("/{id}")
    public String showDetails(Model model, @PathVariable("id") long id) {
    model.addAttribute("topic", topicService.findTopicById((int) id));

    return "topicDetails";
    }
    @GetMapping("/{id}/newFeedback")
    public String addFeedback(Model model, @PathVariable("id") long id) {
   int numberFeedback = 6, percentFeedback = 50, starFeedback = 5;
    Boolean yesNoFeedback = false;
    String textFeedback = "";
        model.addAttribute("topicId", id);
        model.addAttribute("numberFeedback", numberFeedback);
        model.addAttribute("percentFeedback", percentFeedback);
        model.addAttribute("starFeedback", starFeedback);
        model.addAttribute("yesNoFeedback", yesNoFeedback);
        model.addAttribute("textFeedback", textFeedback);

        return "newFeedback";
    }
    @PostMapping("/newFeedback")
    public String addFeedbackPost(Model model, @RequestParam("topicId") long topicId,
                                  @RequestParam("numberFeedback") int numberFeedback,
                                  @RequestParam("percentFeedback") int percentFeedback,
                                  @RequestParam("starFeedback") int starFeedback,
                                  @RequestParam("yesNoFeedback") boolean yesNoFeedback,
                                  @RequestParam("textFeedback")String textFeedback) {

    Feedback feedback = new Feedback();
    feedback.setNumberFeedbackItemValue(numberFeedback);
    feedback.setPercentFeedbackItemValue(percentFeedback);
    feedback.setStarFeedbackItemValue(starFeedback);
    feedback.setTextFeedbackItemValue(textFeedback);
    feedback.setYesNoFeedbackItemValue(yesNoFeedback);

    feedback.getFeedbackItemList().stream().forEach(feedbackItem -> {

    });
        System.out.println("Feedback id = " + feedback.getId());
        feedback.setTopicId((int) topicId);
        System.out.println("TopicId of the feedback: " + feedback.getTopicId());
        topicService.findTopicById(feedback.getTopicId()).addFeedback(feedback);
       topicService.findTopicById(feedback.getTopicId()).getFeedbackList().stream().
               forEach( feedback1 -> System.out.println("Topic id:" + feedback1.getTopicId() + "Feedback id: " + feedback1.getId()));



        System.out.println(numberFeedback + " " + percentFeedback + " " + starFeedback + " " + yesNoFeedback + " " + textFeedback);


    return "redirect:/topic";
    }
}

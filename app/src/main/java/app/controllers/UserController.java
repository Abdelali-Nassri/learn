package app.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import app.dao.AdminRepo;
import app.dao.FieldRepo;
import app.dao.TopicRepo;
import app.dao.WordRepo;
import app.models.Admin;
import app.models.Field;
import app.models.Topic;
import app.models.Word;

@Controller 
public class UserController {
	@Autowired
	TopicRepo trepo;
	
	@Autowired
	AdminRepo arepo;
	
	@Autowired
	FieldRepo frepo;
	
	@Autowired
	WordRepo wrepo;
	
	String language="Fr";
	List<Word> words;
	List<Topic> topics;
	List<Field> fields;
	ModelAndView mv1 =new ModelAndView();
	
	@RequestMapping("/language")
	public String language()
	{
		if(language =="Fr")
			language="Ar";
		else
			language="Fr";
		return "/learn";
	}
	
	
	
	@GetMapping("/learn")
	public ModelAndView home()
	{
		mv1.setViewName("home/userPage.jsp");
		topics = trepo.findAll();
		mv1.addObject("language", language);
		mv1.addObject("topics", topics);
		return mv1;
	}
	
	
	@GetMapping("/learngettopicuser")
	public ModelAndView gettopic(@RequestParam String topicName) {
		fields = frepo.findByTopicName(trepo.findById(topicName));
		mv1.setViewName("home/userPageTopic.jsp");
		mv1.addObject("fields", fields);
		mv1.addObject("language", language);
		mv1.addObject("topicChoix", topicName);
		return mv1;
	}
	
	@GetMapping("/learngetFielduser")
	public ModelAndView getField(@RequestParam String fieldName) {
		words = wrepo.findByFieldName(frepo.findById(fieldName));
		mv1.setViewName("home/userPageField.jsp");
		mv1.addObject("words", words);
		mv1.addObject("language", language);
		mv1.addObject("fieldChoix", fieldName);
		return mv1;
	}
}

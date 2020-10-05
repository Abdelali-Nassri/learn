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
public class AdminController {
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
	ModelAndView mv =new ModelAndView();
	
	/*@GetMapping(path="/users")
	public Iterable<Topic> home() {
		return repo.findAll();
	}*/
	
	@GetMapping(path="/admin")
	public ModelAndView hhome() {
		long a =arepo.count();
		mv.addObject("adminexist", a);
		mv.setViewName("home/adminLogin.jsp");
		
		return mv;
	}
	@RequestMapping("/login")
	public String login()
	{
		if(arepo.count()==0)
			return "home/adminSignup.jsp";
		else 
			return "home/adminLogin.jsp";
	}
	
	@PostMapping("/signup")
	public String signup(@RequestParam String username, @RequestParam String password)
	{
		Admin admin =new Admin(username,password);
		arepo.save(admin);
		return "home/adminLogin.jsp";
	}
	
	@RequestMapping("/Adminlanguage")
	public String language()
	{
		if(language =="Fr")
			language="Ar";
		else
			language="Fr";
		return "/";
	}
	
	
	
	@RequestMapping("/")
	public ModelAndView adminhome()
	{
		
			mv.setViewName("home/AdminPage.jsp");
			topics = trepo.findAll();
			mv.addObject("topics", topics);
			mv.addObject("language", language);
		
		
		return mv;
	}
	
	
	
	
	
	@PostMapping("/AdminaddTopic")
	public ModelAndView addTopic(@RequestParam String topicName, @RequestParam String topicNameArabe,
			@RequestParam String topicNameFrancais ,@RequestParam MultipartFile topicImg)
	{
		try {
			Files.write(Paths.get("src\\main\\resources\\static\\"+topicImg.getOriginalFilename()), topicImg.getBytes());
			Topic t =new Topic(topicName, topicImg.getOriginalFilename(), topicNameArabe, topicNameFrancais);
			trepo.save(t);
			topics=trepo.findAll();
			
			mv.addObject("topics", topics);
			mv.addObject("language", language);
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("home/AdminPage.jsp");
		return mv;
	}
	
	@GetMapping("/Admingettopic")
	public ModelAndView gettopic(@RequestParam String topicName) {
		fields = frepo.findByTopicName(trepo.findById(topicName));
		mv.setViewName("home/AdminPageTopic.jsp");
		mv.addObject("fields", fields);
		mv.addObject("topicChoix", topicName);
		mv.addObject("language", language);
		return mv;
	}
	
	@GetMapping("/Admindeletetopic")
	public ModelAndView deltopic(@RequestParam String topicName,@RequestParam String topicImg) throws IOException {
		Files.deleteIfExists(Paths.get("src\\main\\resources\\static\\"+topicImg));
		trepo.deleteById(topicName);
		mv.setViewName("home/AdminPage.jsp");
		topics=trepo.findAll();
		mv.addObject("topics", topics);
		mv.addObject("language", language);
		
		return mv;
	}
	
	
	
	
	@PostMapping("/AdminaddField")
	public ModelAndView addField(@RequestParam String fieldName, @RequestParam String fieldNameArabe,
			@RequestParam String fieldNameFrancais ,@RequestParam MultipartFile fieldImg ,@RequestParam String topicName)
	{
		try {
			Files.write(Paths.get("src\\main\\resources\\static\\"+fieldImg.getOriginalFilename()), fieldImg.getBytes());
			Field f =new Field(fieldName, fieldImg.getOriginalFilename(), fieldNameArabe, fieldNameFrancais, trepo.getOne(topicName));
			frepo.save(f);
			fields = frepo.findAll();
			mv.addObject("fields", frepo.findAll());
			mv.addObject("language", language);
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("home/AdminPageTopic.jsp");
		return mv;
	}
	
	@GetMapping("/AdmingetField")
	public ModelAndView getField(@RequestParam String fieldName) {
		words = wrepo.findByFieldName(frepo.findById(fieldName));
		mv.setViewName("home/AdminPageField.jsp");
		mv.addObject("words", words);
		mv.addObject("fieldChoix", fieldName);
		mv.addObject("language", language);
		return mv;
	}
	
	@GetMapping("/AdmindeleteField")
	public ModelAndView delField(@RequestParam String fieldName,@RequestParam String fieldImg) throws IOException {
		Files.deleteIfExists(Paths.get("src\\main\\resources\\static\\"+fieldImg));
		frepo.deleteById(fieldName);
		mv.setViewName("home/AdminPageTopic.jsp");
		fields =frepo.findAll();
		mv.addObject("fields",fields );
		mv.addObject("language", language);
		
		return mv;
	}
	
	
	
	

	@PostMapping("/AdminaddWord")
	public ModelAndView addWord(@RequestParam String wordName, @RequestParam String wordNameArabe,
			@RequestParam String wordNameFrancais ,@RequestParam MultipartFile wordImg ,@RequestParam String fieldName)
	{
		try {
			Files.write(Paths.get("src\\main\\resources\\static\\"+wordImg.getOriginalFilename()), wordImg.getBytes());
			Word f =new Word(wordName, wordImg.getOriginalFilename(), wordNameArabe, wordNameFrancais, frepo.getOne(fieldName));
			wrepo.save(f);
			words = wrepo.findAll();
			mv.addObject("words", words);
			mv.addObject("language", language);
			
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("home/AdminPageField.jsp");
		return mv;
	}
	
	@GetMapping("/AdmingetWord")
	public ModelAndView getWord(@RequestParam String wordName) {
		mv.setViewName("home/home.jsp");
		
		return mv;
	}
	
	@GetMapping("/AdmindeleteWord")
	public ModelAndView delWord(@RequestParam String wordName,@RequestParam String wordImg) throws IOException {
		Files.deleteIfExists(Paths.get("src\\main\\resources\\static\\"+wordImg));
		wrepo.deleteById(wordName);
		mv.setViewName("home/AdminPageField.jsp");
		words =wrepo.findAll();
		mv.addObject("words",words );
		mv.addObject("language", language);
		
		return mv;
	}
}

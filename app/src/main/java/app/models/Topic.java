package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Entity
public class Topic {

	@Id
	private String topicName;
	private String topicImg;
	private String topicNameArabe;
	private String topicNameFrancais;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Field> fields = new ArrayList<>();
	
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicImg() {
		return topicImg;
	}
	public void setTopicImg(String topicImg) {
		this.topicImg = topicImg;
	}
	public String getTopicNameArabe() {
		return topicNameArabe;
	}
	public void setTopicNameArabe(String topicNameArabe) {
		this.topicNameArabe = topicNameArabe;
	}
	public String getTopicNameFrancais() {
		return topicNameFrancais;
	}
	public void setTopicNameFrancais(String topicNameFrancais) {
		this.topicNameFrancais = topicNameFrancais;
	}
	public Topic(String topicName, String topicImg, String topicNameArabe, String topicNameFrancais) {
		super();
		this.topicName = topicName;
		this.topicImg = topicImg;
		this.topicNameArabe = topicNameArabe;
		this.topicNameFrancais = topicNameFrancais;
	}
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

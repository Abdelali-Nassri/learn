package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Field {

	@Id
	private String fieldName;
	private String fieldImg;
	private String fieldNameArabe;
	private String fieldNameFrancais;
	@ManyToOne
    @JoinColumn(name = "topicName", referencedColumnName = "topicName")
    private Topic topicName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Word> words = new ArrayList<>();
	
	public Field() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Field(String fieldName, String fieldImg, String fieldNameArabe, String fieldNameFrancais, Topic topicName) {
		super();
		this.fieldName = fieldName;
		this.fieldImg = fieldImg;
		this.fieldNameArabe = fieldNameArabe;
		this.fieldNameFrancais = fieldNameFrancais;
		this.topicName = topicName;
	}
	public String getFieldNameArabe() {
		return fieldNameArabe;
	}
	public void setFieldNameArabe(String fieldNameArabe) {
		this.fieldNameArabe = fieldNameArabe;
	}
	public String getFieldNameFrancais() {
		return fieldNameFrancais;
	}
	public void setFieldNameFrancais(String fieldNameFrancais) {
		this.fieldNameFrancais = fieldNameFrancais;
	}
	public Topic getTopicName() {
		return topicName;
	}
	public void setTopicName(Topic topicName) {
		this.topicName = topicName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldImg() {
		return fieldImg;
	}
	public void setFieldImg(String fieldImg) {
		this.fieldImg = fieldImg;
	}
	
	
}

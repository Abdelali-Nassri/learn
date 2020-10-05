package app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Entity
public class Word {

	@Id
	private String WordName;
	private String WordImg;
	private String WordNameArabe;
	private String WordNameFrancais;
	
	@ManyToOne
    @JoinColumn(name = "fieldName", referencedColumnName = "fieldName")
    private Field fieldName;
	
	
	
	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Word(String wordName, String wordImg, String wordNameArabe, String wordNameFrancais, Field fieldName) {
		super();
		WordName = wordName;
		WordImg = wordImg;
		WordNameArabe = wordNameArabe;
		WordNameFrancais = wordNameFrancais;
		this.fieldName = fieldName;
	}
	public String getWordName() {
		return WordName;
	}
	public void setWordName(String wordName) {
		WordName = wordName;
	}
	public String getWordImg() {
		return WordImg;
	}
	public void setWordImg(String wordImg) {
		WordImg = wordImg;
	}
	public String getWordNameArabe() {
		return WordNameArabe;
	}
	public void setWordNameArabe(String wordNameArabe) {
		WordNameArabe = wordNameArabe;
	}
	public String getWordNameFrancais() {
		return WordNameFrancais;
	}
	public void setWordNameFrancais(String wordNameFrancais) {
		WordNameFrancais = wordNameFrancais;
	}
	
	
	
	
	
}

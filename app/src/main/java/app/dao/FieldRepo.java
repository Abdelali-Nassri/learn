package app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import app.models.Admin;
import app.models.Field;
import app.models.Topic;
public interface FieldRepo extends JpaRepository<Field, String>{

	List<Field> findByTopicName(Optional<Topic> optional);
	
}

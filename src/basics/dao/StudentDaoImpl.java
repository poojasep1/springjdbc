package basics.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import basics.model.Student;

public class StudentDaoImpl implements StudentDao {
  //private   JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
  private JdbcTemplate jdbcTemplate;
  
  
	
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
	@Override
	public void insert(Student student) {
		String sql="INSERT INTO STUDENT VALUES (?,?,?,?)";
	Object[] objects=	{student.getId(),student.getName(),student.getSem(),student.getAverage()};
	
	int no_rows_inserted=jdbcTemplate.update(sql,objects);
		System.out.println("no of rows inserted is"+no_rows_inserted);
	}

	public DataSource getDataSource() {
		String url="jdbc:mysql://127.0.0.1:3306/spring_jdbc";
		String username="root";
		String password="";
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource(url,username,password);
		return dataSource;
	}
}
	 



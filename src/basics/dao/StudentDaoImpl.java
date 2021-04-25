package basics.dao;

import java.util.ArrayList;
import java.util.List;

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
	@Override
	public void delRecordById(int id) {
		String delSql="DELETE FROM STUDENT WHERE _id=?";
int noRecordsDeleted=jdbcTemplate.update(delSql,id);
System.out.println("no of records deleted="+noRecordsDeleted);
	}
	@Override
	public int delRecordByNameSem(String studentName, int sem) {
		String sql="DELETE FROM STUDENT WHERE NAME=? AND SEMESTER=?";//replace Or with AND and see the results also
		Object[] objects= {studentName,sem};
		int noRecordsDeleted=jdbcTemplate.update(sql,objects);
		System.out.println("no of records delete="+ noRecordsDeleted);
		return noRecordsDeleted;
	}
	public void cleanUp() {
		String sql="TRUNCATE TABLE STUDENT";
		jdbcTemplate.update(sql);
		System.out.println("table cleaned");
	}
	@Override
	public void insert(List<Student> students) {
		String sql="INSERT INTO STUDENT VALUES (?,?,?,?)";
		ArrayList<Object[]> sqlArgs =new ArrayList<>();
		for(Student student: students) {
			Object[] studentData=	{student.getId(),student.getName(),student.getSem(),student.getAverage()};
			sqlArgs.add(studentData);
		}
		jdbcTemplate.batchUpdate(sql,sqlArgs);
		
		
	}
}
	 



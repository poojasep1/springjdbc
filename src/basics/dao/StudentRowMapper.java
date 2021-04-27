package basics.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import basics.model.Student;

public class StudentRowMapper {
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("_id");
		String name = rs.getString("name");
		int sem = rs.getInt("semester");
		int avg = rs.getInt("average");
		Student newStudent = new Student(id,name,sem,avg);

		return newStudent;
	}

}

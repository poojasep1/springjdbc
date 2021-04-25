package basics;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basics.dao.StudentDao;
import basics.model.Student;
@Service("studentDaoHelper")
public class StudentDaoHelper {
	@Autowired
	StudentDao studentDaoImpl;
	void insertStudents()
	{

		Student s1= new Student(1,"Students_name1",1,11);
		Student s2= new Student(2,"Students_name1",2,22);
		Student s3= new Student(3,"Students_name1",3,33);
		Student s4= new Student(4,"Students_name1",4,44);
		ArrayList<Student> students=new ArrayList<>();

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		studentDaoImpl.insert(students);
		System.out.println("batch students are inserted sucessfully ");
		
		
	}

}

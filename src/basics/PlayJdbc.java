package basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import basics.dao.StudentDao;
import basics.dao.StudentDaoImpl;
import basics.model.Student;

public class PlayJdbc {
	public static void main(String args[]) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		//StudentDaoImpl studentDao=(StudentDaoImpl) context.getBean("studentDao");
		//studentDao.delRecordById(13);
		StudentDaoHelper helper=context.getBean("studentDaoHelper",StudentDaoHelper.class);
		helper.insertStudents();
	//insertStudent(studentDao);
		//studentDao.cleanUp();
		//studentDao.delRecordByNameSem("chandu", 2);
		
		StudentDaoImpl studentDao = (StudentDaoImpl) context.getBean("studentDao");
		List<Student> students = studentDao.getAllStudents();
		printStudents(students);
	}
	private static void printStudents(List<Student> students) {
		for(Student s : students) {
			System.out.println(s);
		}
}
	private static void insertStudent(StudentDao studentDao) {
		Student myStudent=new Student(13,"prathyusha",5,66);
		Student anotherstudent=new Student(14,"bharathi",6,55);
		
				//new StudentDaoImpl();
		
		studentDao.insert(anotherstudent);
	}

}

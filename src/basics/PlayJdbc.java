package basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basics.dao.StudentDao;
import basics.dao.StudentDaoImpl;
import basics.model.Student;

public class PlayJdbc {
	public static void main(String args[]) {
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		Student myStudent=new Student(13,"prathyusha",5,66);
		Student anotherstudent=new Student(14,"bharathi",6,55);
		StudentDao studentDao=(StudentDao) context.getBean("studentDao");
				//new StudentDaoImpl();
		
		studentDao.insert(anotherstudent);
		
	}

}

package basics;

import basics.dao.StudentDao;
import basics.dao.StudentDaoImpl;
import basics.model.Student;

public class PlayJdbc {
	public static void main(String args[]) {
		Student mystudent=new Student(3,"vasanthi",5,66);
		Student anotherstudent=new Student(4,"Aruna",6,55);
		StudentDao studentdao=new StudentDaoImpl();
		
		studentdao.insert(anotherstudent);
		
	}

}

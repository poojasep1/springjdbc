package basics.dao;



import java.util.List;

import basics.model.Student;

public interface StudentDao {
	public void insert(Student student);
	void insert(List<Student> students);
	 void delRecordById(int _id) ;
	 int delRecordByNameSem(String StudentName,int sem );

}

package com.biz;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;

public interface IStudentBiz {
	    //����ѧ������ѧ����
		public boolean save(Student st);
		//��ѯ����ѧ����Ϣ��ҳ��
		public List<Student> findAll();
		//ɾ��ѧ������ӳ�䵽ѧ����
		public boolean delById(int sid);
		//��ѯѧ������ָ��ѧ����Ϣ
		public Student findById(int sid);
		//�޸�ѧ������ָ��ѧ����Ϣ
		public boolean update(Student st);
	    //��ѯ�༶���������Ϣ��
		public List<Clazz> doinit();
		//��ҳ��ѯ��ȡ�������
		public List<Student> findPageAll(int page,int rows);
		//��ȡ��ҳ��
		public int findmaxPage(int rows);
}

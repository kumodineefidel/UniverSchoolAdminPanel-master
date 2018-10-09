package com.fidelit.service;

import java.util.List;

import com.fidelit.model.Exam;
import com.fidelit.model.ExamToSubject;
import com.fidelit.model.MessageBlog;
import com.fidelit.model.SchoolAdmin;
import com.fidelit.model.StudentToExam;

public interface TeacherService {

	void addExam(Exam exam);
	Exam getExamByExamId(int examId);
	void addSubjectInExam(ExamToSubject examtosubject);
	List<Exam> getAllExam();
	ExamToSubject getExamToSubjectByExamId(int examId);
	StudentToExam setStudentToExam(StudentToExam ste,ExamToSubject ets,SchoolAdmin student,Exam exam);
	StudentToExam getStudentToExamById(int Id);
	List<StudentToExam> getStudentToExamByStudentId(int studentId);
	void updateStudentToExam(StudentToExam exam);
	boolean checkUniqueExamForStudent(int examId,int studentId);
	void addBlog(MessageBlog blog);
	List<MessageBlog> getMessageBlogList();
	void deleteBlogMessageById(int id);
}

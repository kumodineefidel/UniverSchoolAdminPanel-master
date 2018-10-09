package com.fidelit.service;
import java.util.List;


import com.fidelit.model.MessageBlog;

public interface StudentService {
	List<MessageBlog> getBlogsByClass(String studentclass);
}

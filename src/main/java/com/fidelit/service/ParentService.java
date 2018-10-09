package com.fidelit.service;

import java.util.List;

import com.fidelit.model.SchoolAdmin;

public interface ParentService {
	
	List<SchoolAdmin> getChildrenByParentId(int parentId);
}

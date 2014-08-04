package com.remind.bpf.common.mapper;

import java.util.List;

import com.remind.bpf.common.page.Page;

public interface CommonMapper<T> {
	
	public void insert(T model);
	
	public void deleteById(Long id);
	
	public void delete(T model);
	
	public void updateAll(T model);
	
	public List<T> query(T model);
	
	public List<T> queryListPage(Page page);
	

}

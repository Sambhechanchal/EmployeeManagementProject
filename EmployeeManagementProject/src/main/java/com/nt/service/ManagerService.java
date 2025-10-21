package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.entity.Manager;

public interface ManagerService {

	public Manager saveManagerData(Manager mng);

	public Manager getManagerById(Long id);

	public List<Manager> getAllManager();
	
	public String deleteManagerById(Long id);
	
	public String deleteAllManager();

	public String  updateManagerData(Manager mng);

	public Page<Manager> getManagerByPage(int pagenumber, int pagesize, String field, String sortOrder);
	

}

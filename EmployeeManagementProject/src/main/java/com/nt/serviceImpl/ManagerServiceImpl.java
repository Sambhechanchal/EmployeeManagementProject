package com.nt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Manager;
import com.nt.repository.ManagerRepository;
import com.nt.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository mngRepo;

	@Override
	public Manager saveManagerData(Manager mng) {
		return mngRepo.save(mng);
	}

	@Override
	public Manager getManagerById(Long id) {
		 Optional<Manager> opt = mngRepo.findById(id);
		 if(opt.isEmpty()) {
			 throw new RuntimeException("Invalid Id");
		 }
		return opt.get();
	}
	
	@Override
	public List<Manager> getAllManager() {
		
		return mngRepo.findAll();
	}

	@Override
	public String deleteManagerById(Long id) {
		Optional<Manager> opt = mngRepo.findById(id);
		 if(opt.isEmpty()) {
			 throw new RuntimeException("Invalid Id");
		 }else {
			 mngRepo.deleteById(id);
		return "Manager Object Deleted successfully....!";
		 }
	}

	@Override
	public String deleteAllManager() {
		mngRepo.deleteAll();
		return "All Manager Records are deleted....!";
	}

	@Override
	public String updateManagerData(Manager mng) {
		if(mng.getId()== null) {
			mngRepo.save(mng);
			return "Manager Object is saved....!";
		}else {
		 Optional<Manager> opt = mngRepo.findById(mng.getId());
		 
		 if(opt.isPresent()) {
			 
			 Manager manager = opt.get();
			 manager.setMngAddrs(mng.getMngAddrs());
			 manager.setMngName(mng.getMngName());
			 mngRepo.save(manager);
			 return "Manager Object is updated...!";
		 }else {
			 throw new RuntimeException("Manager Object not found");
		 }
		}
	}

	@Override
	public Page<Manager> getManagerByPage(int pagenumber, int pagesize, String field, String sortOrder) {

		Sort sort = Sort.by(sortOrder.equalsIgnoreCase("asc")? Sort.Direction.ASC: Sort.Direction.DESC, field);
		
		PageRequest pageRequest = PageRequest.of(pagenumber, pagesize, sort);
		
		return mngRepo.findAll(pageRequest);
	}
	
}

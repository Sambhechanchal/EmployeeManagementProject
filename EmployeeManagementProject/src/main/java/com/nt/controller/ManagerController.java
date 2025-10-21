package com.nt.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.nt.entity.Manager;
import com.nt.model.ResponseMessage;
import com.nt.repository.ManagerRepository;
import com.nt.service.ManagerService;
import com.nt.utility.Constants;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ManagerController {

    private final ManagerRepository managerRepository;

	@Autowired
	private ManagerService mngService;

    ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }
	
	@PostMapping("/savemanager")
	public ResponseEntity<ResponseMessage> postMethodName(@RequestBody Manager mng) {
		try {
	
		if(mng.getMngName()== null || mng.getMngName().isEmpty() || mng.getMngAddrs()== null || mng.getMngAddrs().isEmpty()) {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILUER,"Manage name and address should not empty"));
		}
		  Manager mngObj= mngService.saveManagerData(mng);
		  if(mngObj != null) {
			  return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS,"Manager object saved successfully...!", mngObj));
		  }else {
			  return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILUER,"Manager object is failed to save...!", mngObj));
		  }
		  
		}catch(Exception e) {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR,  Constants.FAILED,"Internal server error...!"));
		}
	}
	
	@GetMapping("/getManager/{id}")
	public ResponseEntity<ResponseMessage> getMethodName(@PathVariable Long id) {
		
		try {
			
			if(id == null){
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,Constants.FAILUER, "Manage name and address should not empty"));
			}
			  Manager mngObj= mngService.getManagerById(id);
			  if(mngObj != null) {
				  return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS,"Manager object saved successfully...!", mngObj));
			  }else {
				  return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,Constants.FAILUER,"Manager object is failed to save...!", mngObj));
			  }
			  
			}catch(Exception e) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR,Constants.FAILED, "Internal server error...!"));
			}
	}
	
	@PutMapping("/updatemanager")
	public ResponseEntity<ResponseMessage> updateManagerData(@RequestBody Manager mng) {
		try {
			if (mng.getMngName() == null || mng.getMngName().isEmpty() || mng.getMngAddrs() == null
					|| mng.getMngAddrs().isEmpty()) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,
						Constants.FAILUER,"Manage name and address should not empty"));
			}
			String mngObj = mngService.updateManagerData(mng);
			if (mngObj != null) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_OK,Constants.SUCCESS, mngObj, mng));
			} else {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,Constants.FAILUER, mngObj, mng));
			}

		} catch (Exception e) {
			return ResponseEntity
					.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILED,"Internal server error...!"));
		}

	}
	
	@DeleteMapping("/deleteManager/{id}")
	public ResponseEntity<ResponseMessage> deleteManagerById(@PathVariable Long id){
		try {
			if(id == null){
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,
						Constants.FAILUER,"Manage name and address should not empty"));
			}
			String mngObj = mngService.deleteManagerById(id);
			if (mngObj != null) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_OK,Constants.SUCCESS, mngObj));
			} else {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILUER,mngObj));
			}

		} catch (Exception e) {
			return ResponseEntity
					.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR,Constants.FAILED, "Internal server error...!"));
		}
	}
	
	@DeleteMapping("/deleteAllManager")
	public ResponseEntity<ResponseMessage> deleteManager(){
		try {
			
			String mngObj = mngService.deleteAllManager();
			if (mngObj != null) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_OK,Constants.SUCCESS, mngObj));
			} else {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,Constants.FAILUER, mngObj));
			}

		} catch (Exception e) {
			return ResponseEntity
					.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR,Constants.FAILED, "Internal server error...!"));
		}
	}
	
	@GetMapping("/getallmanagerwithpagination")
	public ResponseEntity<ResponseMessage> getAllManagerWithPage(@RequestParam int pagenumber, @RequestParam int pagesize, 
			@RequestParam String field , @RequestParam String sortOrder ){
		
		if(pagenumber == -1 || pagesize == 0 || field == null || field.isEmpty() || sortOrder== null || sortOrder.isEmpty()) {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILUER, "passing data should not be empty...!"));
		}
		Page<Manager> managerByPage = mngService.getManagerByPage(pagenumber, pagesize, field, sortOrder);
		 
		 if(managerByPage != null) {
			 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_OK,Constants.SUCCESS, "manager record fetch successfully ...!", managerByPage));
		 }else {
			 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Manager Record faild to Fetch...!"));
		 }
		
	}
	
}

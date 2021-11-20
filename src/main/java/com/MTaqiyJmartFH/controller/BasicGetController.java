package com.MTaqiyJmartFH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.MTaqiyJmartFH.Algorithm;
import com.MTaqiyJmartFH.Serializable;
import com.MTaqiyJmartFH.JsonTable;

@RestController
@RequestMapping()
public interface BasicGetController<T extends Serializable>{
	public abstract JsonTable<T> getJsonTable();
	
	@GetMapping("/page")
	public default
	List<T> getPage(@RequestParam int page, int pageSize) {
		return null;
		//return Algorithm.paginate<T>(getJsonTable(), page, pageSize, object -> true));
	}
	
	@GetMapping("/{id}")
	public default
	T getById(@RequestParam int id) {
		for(T object : getJsonTable()) {
			if (object.id == id) {
				return object;
			}
		}
		return null;
	}
}

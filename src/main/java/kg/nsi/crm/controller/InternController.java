package kg.nsi.crm.controller;

import java.util.List;

import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.dto.InternDto;

import kg.nsi.crm.service.impl.InternServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/interns")
public class InternController {
	final InternServiceImpl iServiceImpl;
	
	@PostMapping("/")
	public SimpleResponse createIntern(@RequestBody InternDto intern){
		return iServiceImpl.createIntern(intern);
	}
	
	@GetMapping("/{internId}")
    public InternDto getInternById(@PathVariable("internId") Long internId) {
        return iServiceImpl.getInternById(internId);
    }

	@PutMapping("/")
	public SimpleResponse updateInternInfo(@RequestBody InternDto intern){
		return iServiceImpl.updateIntern(intern);
		 
	}
	@DeleteMapping("/{internId}")
	public SimpleResponse deleteIntern(@PathVariable("internId") Long id){
		return iServiceImpl.deleteInternById(id);
		 
	}
	@GetMapping("/getAll")
	public List<InternDto> getAll(){
		return iServiceImpl.getAll();
	}
}

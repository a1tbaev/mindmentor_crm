package kg.nsi.crm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.dto.UserDto;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.service.impl.InternServiceImpl;
import kg.nsi.crm.service.impl.UserServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/interns")
public class InternController {
	final InternServiceImpl iServiceImpl;
	
	@PostMapping("/createAccount")
	public ResponseEntity<Intern> createAccount(@RequestBody InternDto intern){
		return ResponseEntity.ok(this.iServiceImpl.createAccount(intern));
	}
	
	@GetMapping("/{internId}")
    public ResponseEntity<Intern> getInternById(@PathVariable("internId") Long internId) {
        return ResponseEntity.ok(this.iServiceImpl.getInternById(internId));
    }

	@PutMapping("/updateIntern")
	public ResponseEntity<Intern> updateInternInfo(@RequestBody InternDto intern){
		return ResponseEntity.ok(this.iServiceImpl.updateIntern(intern));
		 
	}
	@DeleteMapping("/deleteIntern/{internId}")
	public ResponseEntity<String> deleteIntern(@PathVariable("internId") Long id){
		this.iServiceImpl.deleteInternById(id);
		return ResponseEntity.ok("Successfully deleted ");
	}
}

package kg.nsi.crm.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.InternResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import kg.nsi.crm.dto.InternDto;

import kg.nsi.crm.service.impl.InternServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Intern", description = "The Intern API")
@RequestMapping("/api/v1/interns")
public class InternController {
	final InternServiceImpl iServiceImpl;

	@Operation(summary = "Create a new intern", description = "This method to create a new intern")
	@PostMapping("/")
	public SimpleResponse createIntern(@RequestBody InternRequest intern){
		return iServiceImpl.createIntern(intern);
	}

	@Operation(summary = "Get the intern by id", description = "This method to get the intern by id")
	@GetMapping("/{internId}")
    public InternDto getInternById(@PathVariable("internId") Long internId) {
        return iServiceImpl.getInternById(internId);
    }

	@Operation(summary = "Update intern information", description = "This method to update intern information")
	@PutMapping("/")
	public SimpleResponse updateInternInfo(@RequestBody InternDto intern){
		return iServiceImpl.updateIntern(intern);
		 
	}
	@Operation(summary = "Delete intern by id", description = "This method to delete intern")
	@DeleteMapping("/{internId}")
	public SimpleResponse deleteIntern(@PathVariable("internId") Long id){
		return iServiceImpl.deleteInternById(id);
		 
	}
	@GetMapping("/getAll")
	@Operation(summary = "Get all intern", description = "This method to get all intern")
	public List<InternResponse> getAll(@RequestParam(required = false, defaultValue = "0") int page,
									   @RequestParam(required = false, defaultValue = "10") int size){
		return iServiceImpl.getAll(PageRequest.of(page, size));
	}
}

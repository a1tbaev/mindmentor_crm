package kg.nsi.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import kg.nsi.crm.dto.response.SimpleResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.mapper.InternMapper;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.repository.InternRepository;

import kg.nsi.crm.service.GroupService;
import kg.nsi.crm.service.InternService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InternServiceImpl implements InternService{
	
	private final InternRepository internRepository;
	private final GroupRepository groupRepository;
	private final GroupService groupService;

	@Override
	public SimpleResponse createIntern(InternDto intern) {
		Group group = groupService.getGroupEntityById(intern.getGroupId());	
		internRepository.save(InternMapper.toDto(intern,group));
		return new SimpleResponse( "The intern created successfully", HttpStatus.OK);
	}
	
	@Override
	public InternDto getInternById(Long id) {
		return getInternEntityById(id);
	}
	
	@Override
	public 	SimpleResponse deleteInternById(Long id) {
		return new SimpleResponse( "The intern deleted successfully", HttpStatus.OK);
	}
	
	@Override
	public SimpleResponse updateIntern(InternDto internDto) {
		Intern intern = this.internRepository.getInternById(internDto.getId());
		
		if(internDto.getFirstName()!= null)	intern.setFirstName(internDto.getFirstName());
		if(internDto.getLastName()!=null) intern.setLastName(internDto.getLastName());
		if(internDto.getEmail()!=null) intern.setEmail(internDto.getEmail());
		if(internDto.getPhoneNumber()!=null) intern.setPhoneNumber(internDto.getPhoneNumber());
		if(internDto.getIsPaid()!=null) intern.setIsPaid(internDto.getIsPaid());
		if(internDto.getInternStatus()!=null) intern.setInternStatus(internDto.getInternStatus());
		if(internDto.getUpdateDate()!=null) intern.setUpdateDate(internDto.getUpdateDate());
		if(internDto.getGroupId()!=null) {
			Group group = null;
			try {
				group = groupRepository.findById(internDto.getGroupId()).orElseThrow(()-> new Exception());
			} catch (Exception e) {
				e.printStackTrace();
			}
			intern.setGroup(group);
		}	
		internRepository.save(intern);
		return new SimpleResponse( "The mentor updated successfully", HttpStatus.OK);
	}



	@Override
	public List<InternDto> getAll(PageRequest pageRequest) {
		List<InternDto> interns = new ArrayList<>();

		for(Intern intern: internRepository.findAll(pageRequest)) {
			interns.add(InternMapper.toEntity(intern));
		}
		return interns;
	}

	@Override
	public InternDto getInternEntityById(Long id) {
		System.out.println("inside getInternEntityById");
		return InternMapper.toEntity(internRepository.findById(id).orElseThrow(RuntimeException::new)); 
	}
	
	
//	@Override
//	public List<InternDto> getAll() {
//		List<InternDto> interns = new ArrayList<>();
//
//		for(Intern intern: internRepository.findAll()) {
//			 interns.add(InternMapper.toEntity(intern));
//		}
//		return interns;
//	}
//

}

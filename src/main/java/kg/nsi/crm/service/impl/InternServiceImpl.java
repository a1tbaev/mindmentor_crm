package kg.nsi.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.mapper.InternMapper;
import kg.nsi.crm.mapper.UserMapper;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.UserRepository;
import kg.nsi.crm.results.DataResult;
import kg.nsi.crm.results.Result;
import kg.nsi.crm.results.SuccessDataResult;
import kg.nsi.crm.results.SuccessResult;
import kg.nsi.crm.service.GroupService;
import kg.nsi.crm.service.InternService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InternServiceImpl implements InternService{
	
	final InternRepository internRepository;
	final GroupRepository groupRepository;
	final GroupService groupService;

	@Override
	public DataResult<InternDto> createIntern(InternDto intern) {
		Group group = groupService.getGroupEntityById(intern.getGroupId());	
		return new SuccessDataResult<>("Intern created!",InternMapper.toEntity(internRepository.save(InternMapper.toDto(intern,group))));			
	}
	
	@Override
	public DataResult<InternDto> getInternById(Long id) {
		return new SuccessDataResult<>("Intern info:",getInternEntityById(id));				
	}
	
	@Override
	public 	Result deleteInternById(Long id) {
		return new SuccessResult("Intern deleted!");		
	}
	
	@Override
	public DataResult<InternDto> updateIntern(InternDto internDto) {
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
		return new SuccessDataResult<>("Intern info updated!", InternMapper.toEntity(intern));				
	}

	@Override
	public InternDto getInternEntityById(Long id) {
		return InternMapper.toEntity(internRepository.findById(id).orElseThrow(RuntimeException::new)); 
	}
	
	
	@Override
	public DataResult<List<InternDto>> getAll() {
		List<InternDto> interns = new ArrayList<>();
		
		for(Intern intern: internRepository.findAll()) {
			 interns.add(InternMapper.toEntity(intern));
		}	
		return new SuccessDataResult<>("Interns listed",interns);
	}
	

}

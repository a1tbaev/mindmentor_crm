package kg.nsi.crm.service.impl;

import org.springframework.stereotype.Service;

import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.mapper.InternMapper;
import kg.nsi.crm.mapper.UserMapper;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.UserRepository;
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

	@Override
	public Intern createAccount(InternDto intern) {
		Group group = null;
		try {
			 group = groupRepository.findById(intern.getGroupId()).orElseThrow(()-> new Exception());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return internRepository.save(InternMapper.toDto(intern,group));
	}
	
	@Override
	public Intern getInternById(Long id) {
		return getInternEntityById(id);
	}

	@Override
	public void deleteInternById(Long id) {
		this.internRepository.deleteById(id);	
	}
	@Override
	public Intern updateIntern(InternDto internDto) {
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
		this.internRepository.save(intern);
		return intern;
	}

	@Override
	public Intern getInternEntityById(Long id) {
		return this.internRepository.findById(id).orElseThrow(RuntimeException::new); 
	}
	

}

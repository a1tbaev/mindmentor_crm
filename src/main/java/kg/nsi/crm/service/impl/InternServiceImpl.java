package kg.nsi.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.service.PaymentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import kg.nsi.crm.dto.InternDto;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.mapper.InternMapper;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.service.InternService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InternServiceImpl implements InternService{
	
	private final InternRepository internRepository;
	private final MentorRepository mentorRepository;
	private final PaymentService paymentService;

	@Override
	public SimpleResponse createIntern(InternRequest internRequest) {

		Mentor mentor = mentorRepository.findById(internRequest.mentorId()).orElseThrow();

		internRepository.save(InternMapper.toDto(internRequest, mentor));
		return new SimpleResponse( "The intern created successfully", HttpStatus.OK);
	}
	
	@Override
	public InternDto getInternById(Long id) {
		Intern intern = internRepository.findById(id).orElseThrow();
		paymentService.processPayment(intern);

		return getInternEntityById(id);
	}
	
	@Override
	public 	SimpleResponse deleteInternById(Long id) {
		return new SimpleResponse( "The intern deleted successfully", HttpStatus.OK);
	}
	
	@Override
	public SimpleResponse updateIntern(InternDto internRequest) {
		Intern intern = this.internRepository.getInternById(internRequest.getId());
		
		if(internRequest.getFirstName()!= null)	intern.setFirstName(internRequest.getFirstName());
		if(internRequest.getLastName()!=null) intern.setLastName(internRequest.getLastName());
		if(internRequest.getEmail()!=null) intern.setEmail(internRequest.getEmail());
		if(internRequest.getPhoneNumber()!=null) intern.setPhoneNumber(internRequest.getPhoneNumber());
		if(internRequest.getInternStatus()!=null) intern.setInternStatus(internRequest.getInternStatus());
		if(internRequest.getUpdateDate()!=null) intern.setUpdateDate(internRequest.getUpdateDate());

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
		return InternMapper.toEntity(internRepository.findById(id).orElseThrow(RuntimeException::new));
	}
}

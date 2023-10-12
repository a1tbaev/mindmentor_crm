package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.InternRequest;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.enums.InternStatus;
import kg.nsi.crm.repository.InternRepository;
import kg.nsi.crm.repository.MentorRepository;
import kg.nsi.crm.repository.StackRepository;
import kg.nsi.crm.service.impl.InternServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternServiceTest {

    @InjectMocks
    private InternServiceImpl internService;

    @Mock
    private MentorRepository mentorRepository;

    @Mock
    private StackRepository stackRepository;

    @Mock
    private InternRepository internRepository;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateIntern() {
        InternRequest internRequest = InternRequest.builder()
                .name("John")
                .surname("Doe")
                .email("john@example.com")
                .phoneNumber("123-456-7890")
                .stackId(1L)
                .mentorId(2L)
                .paymentCost(100)
                .internStatus(InternStatus.ACTIVE)
                .build();
        Mentor mentor = new Mentor(); // Create a Mentor object
        Stack stack = new Stack(); // Create a Stack object

        Mockito.when(mentorRepository.findById(Mockito.any())).thenReturn(Optional.of(mentor));
        Mockito.when(stackRepository.findById(Mockito.any())).thenReturn(Optional.of(stack));
        Mockito.when(internRepository.save(Mockito.any())).thenReturn(new Intern());

        SimpleResponse response = internService.createIntern(internRequest);

        assertEquals(HttpStatus.OK, response.httpStatus());
        assertEquals("The intern created successfully", response.message());
    }
}

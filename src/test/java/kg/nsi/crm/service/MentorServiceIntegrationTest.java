package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.impl.MentorServiceImpl;
import kg.nsi.crm.service.impl.PdfParserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MentorServiceIntegrationTest {

    @InjectMocks
    private MentorServiceImpl mentorService;

    @Mock
    private PdfParserService pdfParserService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveExtractedDataFromCv() {
        // Mock dependencies and data as needed
        MentorRequest mentorRequest = new MentorRequest(); // Provide necessary data
        MultipartFile file = null; // Provide a MultipartFile or mock it

        ExtractedDataDto extractedDataDto = new ExtractedDataDto(); // Provide extracted data
        Mockito.when(pdfParserService.parse(file)).thenReturn(extractedDataDto);

        SimpleResponse response = mentorService.saveExtractedDataFromCv(mentorRequest, file);

        assertEquals(HttpStatus.OK, response.httpStatus());
        assertEquals("The mentor saved succesfully", response.message());
    }
}

package kg.nsi.crm.controller;


import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.service.ParserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
// TODO: 28.08.2023 Integrate this code into another controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ParserController {
    private final ParserService parser;


    @PostMapping("/process-pdf")
    public ExtractedDataDto processPDF(@RequestParam("file") MultipartFile file) {
        return parser.parse(file);
    }
}


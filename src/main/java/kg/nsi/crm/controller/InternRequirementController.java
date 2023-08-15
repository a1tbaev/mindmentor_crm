package kg.nsi.crm.controller;
import kg.nsi.crm.dto.InternRequirementDto;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.InternRequirement;
import kg.nsi.crm.service.impl.InternRequirementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/internRequirements")
@RequiredArgsConstructor
public class InternRequirementController {

    final InternRequirementServiceImpl internRequirementService;

    @PostMapping("/")
    public SimpleResponse addInternRequirement(@RequestBody InternRequirementDto internRequirement){
        return internRequirementService.addInternRequirement(internRequirement);
    }

}

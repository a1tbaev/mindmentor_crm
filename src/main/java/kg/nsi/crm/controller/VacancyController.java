package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.VacancyRequest;
import kg.nsi.crm.dto.response.ResponseVacancy;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Vacancy",description = "The Vacancy API")
@RequestMapping("/api/v1/vacancy")
public class VacancyController {
    private final VacancyService vacancyService;

    @PostMapping
    @Operation(summary = "Create a new vacancy", description = "This method to create a new vacancy")
    public SimpleResponse createVacancy(VacancyRequest request){
        return vacancyService.saveVacancy(request);
    }

    @DeleteMapping
    @Operation(summary = "Delete the vacancy", description = "This method to delete the vacancy by id")
    public SimpleResponse deletedVacancy(@RequestParam Long id){
        return vacancyService.deleteVacancy(id);
    }

    @GetMapping
    @Operation(summary = "Get vacancy by id", description = "Find by id vacancy!")
    public ResponseVacancy getById(@RequestParam Long id){
        return vacancyService.getById(id);
    }

    @GetMapping("/getAllByVendorId")
    @Operation(summary = "Get all vacancy by vendor id", description = "Find all vacancy by vendor id!")
    public List<ResponseVacancy> getAllByVendorId(@RequestParam Long vendorId){
        return vacancyService.getAllByVendorId(vendorId);
    }


}

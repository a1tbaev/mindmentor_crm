package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import kg.nsi.crm.enums.DeveloperLevel;
import kg.nsi.crm.enums.GroupStatus;
import kg.nsi.crm.enums.InternStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enums_status")
public class EnumsStatus {
    @Operation(summary = "group status")
    @GetMapping("/group_status")
    public GroupStatus[] getAllGroupStatus(){
        return GroupStatus.values();
    }
    @Operation(summary = "intern status")
    @GetMapping("/intern_status")
    public InternStatus[] getAllInternStatus(){
        return InternStatus.values();
    }
    @Operation(summary = "developer level")
    @GetMapping("/developer_level_status")
    public DeveloperLevel[] getAllDeveloperStatus(){
        return DeveloperLevel.values();
    }
}

package kg.nsi.crm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.nsi.crm.dto.request.VendorRequest;
import kg.nsi.crm.dto.response.ResponseVendor;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.VendorResponse;
import kg.nsi.crm.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Vendor",description = "The Vendor API")
@RequestMapping("/api/v1/vendors")
public class VendorController {
    private final VendorService vendorService;

    @PostMapping
    @Operation(summary = "Create a new vendors", description = "This method to create a new vendors")
    public SimpleResponse createVendor(@RequestBody VendorRequest request){
        return vendorService.saveVendor(request);
    }
    @DeleteMapping
    @Operation(summary = "Delete the vendor", description = "This method to delete the vendor by id")
    public SimpleResponse deletedVendor(@RequestParam Long id){
        return vendorService.deleteVendor(id);
    }

    @PutMapping
    @Operation(summary = "Update vendor", description = "This method to update vendor!")
    public SimpleResponse updateVendor(@RequestBody VendorRequest request, @RequestParam Long id){
        return vendorService.updateVendor(request,id);
    }
    @GetMapping
    @Operation(summary = "Get vendor by id", description = "Find by id vendor!")
    public ResponseVendor getById(@RequestParam Long id){
        return vendorService.getById(id);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Get all vendor", description = "Get all vendor!")
    public List<VendorResponse>getAll(){
        return vendorService.getAllVendors();
    }

}

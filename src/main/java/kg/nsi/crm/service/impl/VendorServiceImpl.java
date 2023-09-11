package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.request.VendorRequest;
import kg.nsi.crm.dto.response.ResponseVendor;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.VendorResponse;
import kg.nsi.crm.entity.Vendor;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.repository.VendorRepository;
import kg.nsi.crm.repository.custom.VendorCustom;
import kg.nsi.crm.service.VacancyService;
import kg.nsi.crm.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;
    private final JdbcTemplate jdbcTemplate;
    private final VacancyService vacancyService;

    @Override
    public SimpleResponse saveVendor(VendorRequest request) {
        vendorRepository.save(
                Vendor.builder()
                        .name(request.name())
                        .email(request.email())
                        .address(request.address())
                        .contactNumber(request.phoneNumber())
                        .information(request.information())
                        .image(request.img())
                        .build()
        );
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The vendor created successfully")
                .build();
    }

    @Override
    public SimpleResponse deleteVendor(Long id) {
        vendorRepository.delete(
                vendorRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Stack by " + id + " not found!")));
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The vendor successfully deleted!")
                .build();
    }

    @Override
    public List<VendorResponse> getAllVendors() {
        return jdbcTemplate.query(new VendorCustom().getAllVendorQuery(),
                (resultset, i)
                        -> VendorResponse
                        .builder()
                        .name(resultset.getString("name"))
                        .img(resultset.getString("img"))
                        .address(resultset.getString("address"))
                        .phoneNumber(resultset.getString("phone_number"))
                        .email(resultset.getString("email"))
                        .build());
    }

    @Override
    public SimpleResponse updateVendor(VendorRequest request, Long id) {
        Vendor oldVendor = vendorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Vendor by id " + id + " not found!"));
        if (request.name() != null) oldVendor.setName(request.name());
        if (request.img() != null) oldVendor.setImage(request.img());
        if (request.email() != null) oldVendor.setEmail(request.email());
        if (request.phoneNumber() != null) oldVendor.setContactNumber(request.phoneNumber());
        if (request.address() != null) oldVendor.setAddress(request.address());
        vendorRepository.save(oldVendor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("The vendor successfully updated!")
                .build();
    }

    @Override
    public ResponseVendor getById(Long id) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Vendor by id " + id + " not found!"));
        return ResponseVendor.builder()
                .name(vendor.getName())
                .address(vendor.getAddress())
                .phoneNumber(vendor.getContactNumber())
                .email(vendor.getEmail())
                .information(vendor.getInformation())
                .img(vendor.getImage())
                .vacancy(vacancyService.getAllVacancyByVendorId(vendor.getId()))
                .build();
    }
}

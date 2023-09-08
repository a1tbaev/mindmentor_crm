package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.VendorRequest;
import kg.nsi.crm.dto.response.ResponseVendor;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.dto.response.VendorResponse;

import java.util.List;

public interface VendorService {
    SimpleResponse saveVendor(VendorRequest request);
    SimpleResponse updateVendor(VendorRequest request,Long id);
    SimpleResponse deleteVendor(Long id);
    List<VendorResponse> getAllVendors();
    ResponseVendor getById(Long id);
}

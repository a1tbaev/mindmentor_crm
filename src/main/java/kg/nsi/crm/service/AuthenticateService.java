package kg.nsi.crm.service;

import kg.nsi.crm.dto.request.AuthenticateRequest;
import kg.nsi.crm.dto.response.AuthenticateResponse;

public interface AuthenticateService {
    AuthenticateResponse authenticate (AuthenticateRequest authenticateRequest);
}

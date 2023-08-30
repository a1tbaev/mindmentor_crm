package kg.nsi.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.service.ParserService;
import kg.nsi.crm.util.DataExtractor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.concurrent.TimeUnit;


@RequiredArgsConstructor
@Service
public class PdfParserService implements ParserService {
    @Value("${eden.apikey}")
    private String EDEN_API_KEY;
    @Value("${eden.url}")
    private String EDEN_URL;
    @Value("${eden.provider}")
    private String EDEN_PROVIDER;
    private final DataExtractor extractor;
    @SneakyThrows
    @Override
    public ExtractedDataDto parse(MultipartFile file) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        byte[] pdfContent = file.getBytes();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getOriginalFilename(), RequestBody.create(MediaType.parse(extractor.extractType(file).getValue()), pdfContent))
                .addFormDataPart("response_as_dict", "true")
                .addFormDataPart("attributes_as_list", "false")
                .addFormDataPart("show_original_response", "false")
                .addFormDataPart("providers",EDEN_PROVIDER)
                .build();
        Request request = new Request.Builder()
                .url(EDEN_URL)
                .post(requestBody)
                .addHeader("accept", "application/json")
                .addHeader("authorization", "Bearer %s".formatted(EDEN_API_KEY))
                .build();
        Response response = client.newCall(request).execute();
        ObjectMapper mapper = new ObjectMapper();
        return extractor.extractedData(mapper.readTree(response.body().byteStream()));

    }
}

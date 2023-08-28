package kg.nsi.crm.util;


import com.fasterxml.jackson.databind.JsonNode;
import kg.nsi.crm.dto.ExperienceDto;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.enums.MediaType;
import kg.nsi.crm.exception.UnsupportedMediaTypeException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Component
public class DataExtractor {
    private final String DATE_FORMAT = "yyyy-MM-dd";
    public MediaType extractType(MultipartFile file) throws UnsupportedMediaTypeException {
        if (Objects.equals(file.getContentType(), MediaType.PNG.getValue())) {
            return MediaType.PNG;
        }else if (Objects.equals(file.getContentType(),MediaType.PDF.getValue())) {
            return MediaType.PDF;
        }else throw new UnsupportedMediaTypeException("Type of this file: %s is not supported".formatted(file.getContentType()));
    }
    private ArrayList<String> extractSpecificFieldWithNote(JsonNode node,String nodeName) {
        ArrayList<String> arrayList = new ArrayList<>();
        Optional<JsonNode> dataArray = Optional.ofNullable(node);
        if (dataArray.isPresent()) {
            for (JsonNode jsonNode1 : dataArray.get()) {
                arrayList.add(jsonNode1.get(nodeName).asText());
            }
        }
        return arrayList;
    }
    private ArrayList<ExperienceDto> extractExperience(JsonNode node) {
        ArrayList<ExperienceDto> dataArray = new ArrayList<>();
        Optional<JsonNode> data = Optional.ofNullable(node);
        if (data.isPresent()) {
            for (JsonNode jsonNode1 : data.get()) {
                String startDate = jsonNode1.get("start_date").asText();
                String endDate = jsonNode1.get("end_date").asText();
                LocalDate startLocalDate = null;
                LocalDate endLocalDate = null;
                if (startDate != null) startLocalDate = LocalDate.parse(startDate,DateTimeFormatter.ofPattern(DATE_FORMAT));
                if (endDate != null) endLocalDate = LocalDate.parse(endDate,DateTimeFormatter.ofPattern(DATE_FORMAT));
                dataArray.add(ExperienceDto.builder()
                        .jobTitle(jsonNode1.get("title").asText())
                        .company(jsonNode1.get("company").asText())
                        .description(jsonNode1.get("description").asText())
                        .location(jsonNode1.get("location").get("formatted_location").asText())
                        .endDate(startLocalDate)
                        .startDate(endLocalDate)
                        .build());
            }
        }
        return dataArray;
    }

    private ArrayList<String> extractSpecificField(JsonNode node) {
        ArrayList<String> list = new ArrayList<>();
        Optional<JsonNode> dataArray = Optional.ofNullable(node);
        if (dataArray.isPresent()) {
            for (JsonNode jsonNode1 : dataArray.get()) {
                list.add(jsonNode1.asText());
            }
        }
        return list;
    }

    public ExtractedDataDto extractedData(JsonNode jsonNode) {
        JsonNode node = jsonNode.get("affinda").get("extracted_data");
        JsonNode personalNode = node.get("personal_infos");
        return ExtractedDataDto.builder()
                .fullName(personalNode.get("name").get("raw_name").asText())
                .selfSummary(personalNode.get("self_summary").asText())
                .phoneNumbers(extractSpecificField(personalNode.get("phones")))
                .email(extractSpecificField(personalNode.get("mails")))
                .urls(extractSpecificField(personalNode.get("urls")))
                .stack(extractSpecificFieldWithNote(node.get("skills"),"name"))
                .education(extractSpecificFieldWithNote(node.get("education").get("entries"),"establishment"))
                .experience(extractExperience(node.get("work_experience").get("entries")))
                .build();
    }
}

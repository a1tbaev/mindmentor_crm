package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.dto.response.ExtractedDataDto;
import kg.nsi.crm.dto.response.MentorResponse;
import kg.nsi.crm.entity.Mentor;

public class MentorMapper {

    public static Mentor toEntity(MentorRequest mentorRequest){
        return Mentor.builder()
                .firstName(mentorRequest.getFirstName())
                .lastName(mentorRequest.getLastName())
                .isBillable(mentorRequest.getIsBillable())
                .email(mentorRequest.getEmail())
                .build();
    }

    public static Mentor toEntity(UpdatedMentorRequest updatedMentorRequest) {
        return Mentor.builder()
                .firstName(updatedMentorRequest.firstName())
                .lastName(updatedMentorRequest.lastName())
                .experience(updatedMentorRequest.experience())
                .education(updatedMentorRequest.education())
                .isBillable(updatedMentorRequest.isBillable())
                .email(updatedMentorRequest.email())
                .build();
    }
    public static MentorResponse toResponse(Mentor mentor){
        return MentorResponse.builder()
                .firstname(mentor.getFirstName())
                .lastname(mentor.getLastName())
                .email(mentor.getEmail())
                .skills(mentor.getSkills())
                .education(mentor.getEducation())
                .experience(mentor.getExperience())
                .isBillable(mentor.getIsBillable())
                .build();
    }


}

package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.entity.Mentor;

public class MentorMapper {

    public static Mentor toEntity(MentorRequest mentorRequest){
        return Mentor.builder()
                .firstName(mentorRequest.firstName())
                .lastName(mentorRequest.lastName())
                .isBillable(mentorRequest.isBillable())
                .email(mentorRequest.email())
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
}

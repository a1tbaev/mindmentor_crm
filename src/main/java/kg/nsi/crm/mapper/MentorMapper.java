package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.entity.Mentor;

public class MentorMapper {

    public static Mentor toEntity(MentorRequest mentorRequest){
        return Mentor.builder()
                .firstName(mentorRequest.firstName())
                .lastName(mentorRequest.lastName())
                .email(mentorRequest.email())
                .isBillable(mentorRequest.isBillable())
                .phoneNumber(mentorRequest.phoneNumber())
                .build();
    }
}

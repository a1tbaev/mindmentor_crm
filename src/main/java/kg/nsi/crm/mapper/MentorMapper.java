package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.request.MentorRequest;
import kg.nsi.crm.dto.request.UpdatedMentorRequest;
import kg.nsi.crm.dto.response.MentorResponse;
import kg.nsi.crm.entity.Mentor;
import kg.nsi.crm.entity.Stack;
import kg.nsi.crm.repository.MentorRepository;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Set<Stack> stacks = mentor.getStacks();
        List<String> stackNames = new ArrayList<>();

        for(Stack stack: stacks){
            stackNames.add(stack.getName());
        }
        return MentorResponse.builder()
                .id(mentor.getId())
                .stackNames(stackNames)
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

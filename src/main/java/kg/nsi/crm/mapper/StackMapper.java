package kg.nsi.crm.mapper;

import kg.nsi.crm.dto.response.StackResponse;
import kg.nsi.crm.entity.Stack;
import lombok.Builder;

@Builder
public class StackMapper {
    public static StackResponse toResponse(Stack stack){
        return StackResponse.builder()
                .id(stack.getId())
                .name(stack.getName())
                .build();
    }
}

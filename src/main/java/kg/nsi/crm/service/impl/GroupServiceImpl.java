package kg.nsi.crm.service.impl;

import kg.nsi.crm.dto.GroupDto;
import kg.nsi.crm.dto.request.GroupRequest;
import kg.nsi.crm.dto.response.EventResponse;
import kg.nsi.crm.dto.response.HistoryResponse;
import kg.nsi.crm.dto.response.SimpleResponse;
import kg.nsi.crm.entity.Event;
import kg.nsi.crm.entity.Intern;
import kg.nsi.crm.enums.GroupStatus;
import kg.nsi.crm.exception.exceptions.NotFoundException;
import kg.nsi.crm.mapper.EventMapper;
import kg.nsi.crm.mapper.GroupMapper;
import kg.nsi.crm.repository.EventRepository;
import kg.nsi.crm.repository.InternRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import kg.nsi.crm.service.HistoryGeneratorService;
import kg.nsi.crm.entity.Group;
import kg.nsi.crm.repository.GroupRepository;
import kg.nsi.crm.service.GroupService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final InternRepository internRepository;
	private final HistoryGeneratorService historyGeneratorService;
    private final EventRepository eventRepository;

    @Override
    public SimpleResponse addGroup(GroupRequest groupRequest) {
        List<Intern> internList = internRepository.findAllById(groupRequest.internsId());

        if (internList.isEmpty()) {
            return new SimpleResponse("No interns found for the provided IDs", HttpStatus.BAD_REQUEST);
        }

        Group newGroup = GroupMapper.toEntity(groupRequest, internList);

        internRepository.saveAll(internList);

        for (Intern intern : internList) {
            intern.setGroup(newGroup);
            historyGeneratorService.forSave(new HistoryResponse("Intern has been added to group " + groupRequest.groupName()), intern.getId());
        }

        groupRepository.save(newGroup);

        return new SimpleResponse("The group created successfully", HttpStatus.OK);
    }


    @Override
    public GroupDto getGroupEntityById(Long groupId) {

        Group group = groupRepository.findById(groupId).orElseThrow(() -> new NotFoundException(String.format("Group with id %s is not found!", groupId)));

        return GroupDto.builder()
                .id(groupId)
                .name(group.getName())
                .startDate(group.getStartDate())
                .finishDate(group.getFinishDate())
                .groupStatus(group.getGroupStatus()).build();
    }

    @Override
    public SimpleResponse delete(Long groupId) {

        List<Intern> internsByGroupId = internRepository.getInternsByGroupId(groupId);

        for (Intern intern : internsByGroupId) {
            intern.setGroup(null);
            internRepository.save(intern);
        }

        groupRepository.deleteById(groupId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("group successfully deleted with id: " + groupId)
                .build();
    }

    @Override
    public SimpleResponse update(Long groupId, GroupRequest groupRequest) {

        Group group = groupRepository.findById(groupId).orElseThrow(() -> new NotFoundException(String.format("Group with id %s is not found!", groupId)));
        List<Intern> internList = internRepository.findAllById(groupRequest.internsId());
        for (Intern intern : internList) {
            intern.setGroup(group);
        }

        internRepository.saveAll(internList);
        if (groupRequest.groupName() != null) group.setName(groupRequest.groupName());
        if (groupRequest.groupStatus() != null) group.setGroupStatus(groupRequest.groupStatus());
        if (groupRequest.startDate() != null) group.setStartDate(groupRequest.startDate());
        if (groupRequest.endDate() != null) group.setFinishDate(group.getFinishDate());
        groupRepository.save(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("group successfully updated with id: " + groupId)
                .build();
    }

    @Override
    public List<GroupDto> getAll(String groupStatus) {
        List<Group> groups = groupRepository.findAll();
        List<GroupDto> groupDtos = new ArrayList<>();

        for(Group group: groups){
            if (group.getGroupStatus().equals(GroupStatus.valueOf(groupStatus.toUpperCase()))){
            groupDtos.add(GroupMapper.toDto(group));
            }
        }
        return groupDtos;
    }

    @Override
    public List<EventResponse> getAllEvents(Long groupId) {
        List<Event> events = eventRepository.getAllEventsByGroupId(groupId);
        List<EventResponse> allEvents = new ArrayList<>();

        for(Event event: events){
            allEvents.add(EventMapper.toDto(event));
        }
        return allEvents;
    }
}

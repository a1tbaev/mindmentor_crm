package kg.nsi.crm.repository.custom;

public class InterviewCustom {
    public String getAllInterviews(){
        return """
               select concat(i2.first_name, i2.last_name) as full_name,
               i2.email as email,
               s.name as stack,
               i.start_time as time,
               i.start_date as date,
               i.location as location from interview i
               join interview_interns ii on i.id = ii.interview_id
               join interns i2 on i2.id = ii.interns_id
               join stacks s on i2.stack_id = s.id
                """;
    }
}

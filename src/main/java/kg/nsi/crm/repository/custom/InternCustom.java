package kg.nsi.crm.repository.custom;

public class InternCustom {
    public String getAllQuery(){
        return  """
                SELECT
                    i.first_name AS first_name,
                    i.last_name AS last_name,
                    CASE
                        WHEN i.group_id IS NULL THEN 'Not Assigned to Group'
                        ELSE g.name
                    END AS group_name,
                    s.name AS stack,
                    i.status AS status,
                    CONCAT(m.first_name, ' ', m.last_name) AS mentor_name
                FROM interns i
                LEFT JOIN groups g ON g.id = i.group_id
                JOIN stacks s ON s.id = i.stack_id
                FULL JOIN mentors m ON m.id = i.mentor_id;
                ;
                """;
    }
}

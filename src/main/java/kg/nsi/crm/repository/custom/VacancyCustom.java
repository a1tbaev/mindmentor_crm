package kg.nsi.crm.repository.custom;

public class VacancyCustom {

    public String getAllVacancyByVendorIdQuery(Long id){
        String sql  = """
                SELECT s.name as stack_name,
                       v.level as level ,
                       v.release_day as dates
                FROM vacancy v JOIN stacks s on s.id = v.stack_id
                """;
        sql+=" where v.vendor_id = "+id;
        return sql;
    }
}

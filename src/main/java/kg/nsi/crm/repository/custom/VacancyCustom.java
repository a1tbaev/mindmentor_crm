package kg.nsi.crm.repository.custom;

public class VacancyCustom {

    public String getAllVacancyByVendorIdQuery(Long id){
        String sql  = """
                SELECT v.vacancy_name as stack_name,
                       v.level as level ,
                       v.release_day as dates
                FROM vacancy v 
                """;
        sql+=" where v.vendor_id = "+id;
        return sql;
    }
}

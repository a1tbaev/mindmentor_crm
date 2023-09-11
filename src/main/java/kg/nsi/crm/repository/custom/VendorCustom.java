package kg.nsi.crm.repository.custom;

public class VendorCustom {
    public String getAllVendorQuery(){
        return """
                SELECT v.name           AS name,
                       v.image          AS img,
                       v.address        AS address,
                       v.contact_number AS phone_number,
                       v.email          AS email
                FROM vendors v
                        """;
    }
}

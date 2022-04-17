package tk.propensi.medix.service;

public interface TenantManagementService {

    void createTenant(String tenantId, String db, String password) throws Exception;

}

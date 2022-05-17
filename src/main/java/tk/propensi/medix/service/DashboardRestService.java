package tk.propensi.medix.service;

import java.util.HashMap;
import java.util.List;

public interface DashboardRestService {
    List<HashMap> getChartData(Long idrs);
}

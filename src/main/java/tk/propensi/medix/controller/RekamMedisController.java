gitpackage tk.propensi.medix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tk.propensi.medix.models.RoleModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.*;

import java.util.List;

@Controller

    @Autowired
    private KunjunganService kunjunganService;
    
    @Autowired
    RekamMedisService rekamMedisSer(Model model, @Param("keyword") String keyword)
    @RequestMapping("/rekamMedis").find.fseasearchfindAll()getPasienList(keyword);
        model.addAttribute("listUser", listPasien);

        return "viewal-RM";
    public String viewAllRekamMedis(Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auh.getName());
        List<KunjunganModel> listPasien = kunjunganService.get
    }

    @GetMapping("/rekamMedis/{personID}")
    public String detailRM(@PathVariable("personID") String personID, Authentication auth, Model model){
        List<ResumeMedisModel> listRM = rekamMedisService.getRekamMedisByIdPasien(personID);
        model.addAttribute("listRM", listRM);
        return "detailRM";
    }
}

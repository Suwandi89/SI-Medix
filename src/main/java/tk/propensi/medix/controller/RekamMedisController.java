package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.propensi.medix.models.KunjunganModel;
import tk.propensi.medix.models.ResumeMedisModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.*;

import java.util.List;

@Controller
public class RekamMedisController {

    @Autowired
    private UserService userService;

    @Autowired
    private KunjunganService kunjunganService;

    @Autowired
    private RekamMedisService rekamMedisService;


    @RequestMapping("/rekamMedis")
    public String viewAllRekamMedis(Model model, Authentication auth, @Param("keyword") String keyword){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<KunjunganModel> listPasien = kunjunganService.getPasienList(keyword);
        model.addAttribute("listPasien", listPasien);
        model.addAttribute("authuser", authUser);
        return "viewall-RM";
    }

    @GetMapping("/rekamMedis/{personId}")
    public String detailRM(@PathVariable("personId") String personId, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        KunjunganModel kunjungan = kunjunganService.getKunjunganById(personId);
        List<ResumeMedisModel> listRM = rekamMedisService.getRekamMedisByPersonId(personId);
        model.addAttribute("listRM", listRM);
        model.addAttribute("kunjungan", kunjungan);
        model.addAttribute("authuser", authUser);
        return "detailRM";
    }
}

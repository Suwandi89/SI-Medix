package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import tk.propensi.medix.models.KunjunganModel;
import tk.propensi.medix.models.ResumeMedisModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.*;

import java.util.ArrayList;
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
    public String viewAllRekamMedis(
            Model model,
            Authentication auth,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "keyword", required = false) String keyword
    ){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<String> namaRS = kunjunganService.getnamaRS();
        List<KunjunganModel> listPasien = kunjunganService.getPasienList(keyword);
        List<KunjunganModel> listFilter = kunjunganService.filterList(filter);
        listPasien.retainAll(listFilter);
        model.addAttribute("keywordnya", keyword);
        model.addAttribute("filternya", filter);
        model.addAttribute("listNamaRS", namaRS);
        model.addAttribute("listPasien", listPasien);
        model.addAttribute("authuser", authUser);
        return "viewall-RM";
    }

    @GetMapping("/rekamMedis/{personId}")
    public String detailRM(@PathVariable("personId") String personId, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<KunjunganModel> listKunjungan = kunjunganService.getKunjunganById(personId);
        KunjunganModel kunjungan = listKunjungan.get(0);
        List<ResumeMedisModel> listRM = rekamMedisService.getRekamMedisByPersonId(personId);
        model.addAttribute("listRM", listRM);
        model.addAttribute("kunjungan", kunjungan);
        model.addAttribute("authuser", authUser);
        return "detailRM";
    }

    @GetMapping("/rekamMedis/{personId}/{rekamMedisID}")
    public String detailRM(@PathVariable("personId") String personId, @PathVariable("rekamMedisID") String rekamMedisID, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        ResumeMedisModel rm = rekamMedisService.getRekamMedisByResumeID(rekamMedisID);
        model.addAttribute("rm", rm);
        model.addAttribute("authuser", authUser);
        return "detailRekamMedis";
    }

    @PostMapping("/rekamMedis/flag/{rekamMedisID}")
    public String flagRM(@PathVariable("rekamMedisID") String rekamMedisID, @RequestParam(value = "komen_flag") String komen_flag, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        ResumeMedisModel rm = rekamMedisService.getRekamMedisByResumeID(rekamMedisID);
        KunjunganModel kunjungan = kunjunganService.getKunjunganById(rm.getPersonId());
        rekamMedisService.memberiFlag(rekamMedisID, komen_flag);
        model.addAttribute("rm", rm);
        model.addAttribute("authuser", authUser);
        model.addAttribute("kunjungan", kunjungan);
        return "redirect:/rekamMedis/" + rm.getPersonId() + "/" + rekamMedisID;
    }

    @RequestMapping(value = "/viewall-flagged")
    public String viewAllFlagged(Authentication auth, Model model, @Param("keyword") String keyword) {
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<ResumeMedisModel> listRekamMedis = rekamMedisService.getRekamMedisList(keyword);
        List<ResumeMedisModel> listRekamMedisRes = new ArrayList<>();
        for (ResumeMedisModel rm : listRekamMedis){
            if (rm.getKomen_flag() != null){
                listRekamMedisRes.add(rm);
            }
        }
        model.addAttribute("listRekamMedis", listRekamMedisRes);
        model.addAttribute("authuser", authUser);
        return "viewall-flagged";
    }

    @GetMapping("/rekamMedisFlag/flag/{personId}/{rekamMedisID}")
    public String detailFlaggedRM(@PathVariable("personId") String personId, @PathVariable("rekamMedisID") String rekamMedisID, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        ResumeMedisModel rm = rekamMedisService.getRekamMedisByResumeID(rekamMedisID);
        model.addAttribute("rm", rm);
        model.addAttribute("authuser", authUser);
        return "detailFlaggedRekamMedis";
    }
    @GetMapping("/rekamMedisFlag/unflag/{rekamMedisID}")
    public String unflag(@PathVariable("rekamMedisID") String rekamMedisID, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        ResumeMedisModel rm = rekamMedisService.getRekamMedisByResumeID(rekamMedisID);
        rekamMedisService.unflag(rekamMedisID);
        model.addAttribute("rm", rm);
        model.addAttribute("authuser", authUser);
        return "redirect:/viewall-flagged";
    }
}
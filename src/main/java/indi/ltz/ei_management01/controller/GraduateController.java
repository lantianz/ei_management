package indi.ltz.ei_management01.controller;

import indi.ltz.ei_management01.domain.entity.Graduate;
import indi.ltz.ei_management01.domain.entityVo.AdminVo;
import indi.ltz.ei_management01.domain.entityVo.GraduateVo;
import indi.ltz.ei_management01.service.GraduateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/graduates")
public class GraduateController {

    private final GraduateService graduateService;
    public GraduateController(GraduateService graduateService){
        this.graduateService = graduateService;
    }

    @GetMapping("/graduateInfo")
    public String getAllGraduates(Model model) {
        List<Graduate> graduates = graduateService.getAllGraduates();
        List<GraduateVo> graduateVos = graduates.stream()
                .map(GraduateVo::new)
                .toList();
        model.addAttribute("graduates", graduateVos);
        return "nav/graduateInfo";
    }

    @GetMapping("/{studentId}")
    public Graduate getGraduateById(@PathVariable String studentId) {
        //Graduate graduate = graduateService.getGraduateById(studentId);
        return graduateService.getGraduateById(studentId);
    }

    @PostMapping
    public Graduate addGraduate(@RequestBody Graduate graduate) {
        return graduateService.addGraduate(graduate);
    }

    @PutMapping
    public Graduate updateGraduate(@RequestBody Graduate graduate) {
        return graduateService.updateGraduate(graduate);
    }

    @DeleteMapping("/{studentId}")
    public void deleteGraduate(@PathVariable String studentId) {
        graduateService.deleteGraduate(studentId);
    }
}

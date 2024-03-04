package indi.ltz.ei_management01.controller;

import indi.ltz.ei_management01.domain.entity.EmploymentInfo;
import indi.ltz.ei_management01.service.EmploymentInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employmentInfos")
public class EmploymentInfoController {

    private final EmploymentInfoService employmentInfoService;
    public EmploymentInfoController(EmploymentInfoService employmentInfoService) {
        this.employmentInfoService = employmentInfoService;
    }

    @GetMapping("/employmentInfo")
    public String getAllEmploymentInfos(Model model) {
        List<EmploymentInfo> employmentInfos = employmentInfoService.getAllEmploymentInfos();
        model.addAttribute("employmentInfos", employmentInfos);
        return "nav/employmentInfo";
    }

    @GetMapping("/{studentId}")
    public EmploymentInfo getEmploymentInfoById(@PathVariable String studentId) {
        return employmentInfoService.getEmploymentInfoById(studentId);
    }

    @PostMapping
    public EmploymentInfo addEmploymentInfo(@RequestBody EmploymentInfo employmentInfo) {
        return employmentInfoService.addEmploymentInfo(employmentInfo);
    }

    @PutMapping
    public EmploymentInfo updateEmploymentInfo(@RequestBody EmploymentInfo employmentInfo) {
        return employmentInfoService.updateEmploymentInfo(employmentInfo);
    }

    @DeleteMapping("delete/{studentId}")
    public void deleteEmploymentInfo(@PathVariable String studentId) {
        employmentInfoService.deleteEmploymentInfo(studentId);
    }
}


package org.scaler.universitysystem.controllers;

import org.scaler.universitysystem.models.Program;
import org.scaler.universitysystem.service.ProgramService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programs")
public class ProgramController {
    private ProgramService programService;
    ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/{id}")
    public Program getProgramById(@PathVariable("id") Long id) {
        return programService.getProgramById(id);
    }

    @PostMapping
    public Program createProgram(@RequestBody Program program) {
        return programService.createProgram(program);
    }

    @PutMapping("/{id}")
    public Program updateProgram(@PathVariable("id") Long id, @RequestBody Program program) {
        return programService.updateProgram(id, program);
    }

    @DeleteMapping("/{id}")
    public void deleteProgram(@PathVariable("id") Long id) {
        programService.deleteProgram(id);
    }


    @GetMapping("/department/{departmentId}")
    public List<Program> getProgramsByDepartment(@PathVariable("departmentId") Long departmentId) {
        return programService.getProgramsByDepartment(departmentId);
    }

}

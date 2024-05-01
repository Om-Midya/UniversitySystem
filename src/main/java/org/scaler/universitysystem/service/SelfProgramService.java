package org.scaler.universitysystem.service;

import org.scaler.universitysystem.models.Department;
import org.scaler.universitysystem.models.Program;
import org.scaler.universitysystem.repository.DepartmentRepository;
import org.scaler.universitysystem.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProgramService implements ProgramService {
    private ProgramRepository programRepository;
    private DepartmentRepository departmentRepository;

    public SelfProgramService(ProgramRepository programRepository, DepartmentRepository departmentRepository) {
        this.programRepository = programRepository;
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Program getProgramById(Long id) {
        Optional<Program> optionalProgram = programRepository.findById(id);
        return optionalProgram.get();
    }

    @Override
    public Program createProgram(Program program) {
        Department department = program.getDepartment();
        if (department.getId() == null) {
            department = departmentRepository.save(department);
        }
        Optional<Department> optionalDepartment = departmentRepository.findById(department.getId());
        department.getPrograms().add(program);
        program.setDepartment(optionalDepartment.get());

        return programRepository.save(program);
    }

    @Override
    public Program updateProgram(Long id, Program program) {
        return programRepository.save(program);
    }

    @Override
    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }

    @Override
    public List<Program> getProgramsByDepartment(Long departmentId) {
        return programRepository.findByDepartmentId(departmentId);
    }
}

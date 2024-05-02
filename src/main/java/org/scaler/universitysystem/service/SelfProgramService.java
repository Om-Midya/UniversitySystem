package org.scaler.universitysystem.service;

import org.scaler.universitysystem.exceptions.DepartmentNotFoundException;
import org.scaler.universitysystem.exceptions.ProgramNotFoundException;
import org.scaler.universitysystem.models.Department;
import org.scaler.universitysystem.models.Program;
import org.scaler.universitysystem.repository.DepartmentRepository;
import org.scaler.universitysystem.repository.ProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfProgramService implements ProgramService {
    private ProgramRepository programRepository;
    private DepartmentRepository departmentRepository;

    private DepartmentService departmentService;

    private static final Logger logger = LoggerFactory.getLogger(SelfProgramService.class);

    public SelfProgramService(ProgramRepository programRepository, DepartmentRepository departmentRepository, DepartmentService departmentService) {
        this.programRepository = programRepository;
        this.departmentRepository = departmentRepository;
        this.departmentService = departmentService;
    }


    @Override
    public Program getProgramById(Long id) {
        logger.info("Getting program by id: {}", id);
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isEmpty()) {
            throw new ProgramNotFoundException(id);
        }
        return optionalProgram.get();
    }

    @Override
    public Program createProgram(Program program) {
        logger.info("Creating program with name: {}", program.getName());
        //if name or duration or degreeLevel or department is null, throw an exception
        if (program.getName() == null || program.getDuration() == 0 || program.getDegreeLevel() == null || program.getDepartment() == null) {
            throw new IllegalArgumentException("Name, Duration, Degree Level and Department are mandatory fields");
        }


        Department department = program.getDepartment();
        if (department.getId()!=null){
            Optional<Department> optionalDepartment = departmentRepository.findById(department.getId());
            if (optionalDepartment.isEmpty()) {
                throw new DepartmentNotFoundException(department.getId());
            }
        }
        if (department.getId() == null) {
           department = departmentRepository.save(department);
         //   department = departmentService.createDepartment(department);
        }
        Optional<Department> optionalDepartment = departmentRepository.findById(department.getId());
      //  department.getPrograms().add(program);
        program.setDepartment(optionalDepartment.get());



        return programRepository.save(program);
    }

    @Override
    public Program updateProgram(Long id, Program program) {
        logger.info("Updating program with id: {}", id);
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isPresent()) {
            return programRepository.save(update(optionalProgram.get(), program));
        } else {
            throw new ProgramNotFoundException(id);
        }
    }

    @Override
    public void deleteProgram(Long id) {
        logger.info("Deleting program with id: {}", id);
        Optional<Program> program = programRepository.findById(id);
        if (program.isEmpty()) {
            throw new ProgramNotFoundException(id);
        }
        programRepository.deleteById(id);
    }

    @Override
    public List<Program> getProgramsByDepartment(Long departmentId) {
        logger.info("Getting programs by departmentId: {}", departmentId);
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            throw new DepartmentNotFoundException(departmentId);
        }
        return programRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Program> getAllPrograms() {
        logger.info("Getting all programs");
        return programRepository.findAll();
    }
    public Program update(Program existingProgram, Program updatedProgram) {
        if(updatedProgram.getName() != null)
            existingProgram.setName(updatedProgram.getName());
        if(updatedProgram.getDuration() != 0){
            existingProgram.setDuration(updatedProgram.getDuration());
        }
        if(updatedProgram.getDepartment() != null){
            existingProgram.setDepartment(updatedProgram.getDepartment());
        }
        if(updatedProgram.getDegreeLevel() != null){
            existingProgram.setDegreeLevel(updatedProgram.getDegreeLevel());
        }
        return programRepository.save(existingProgram);
    }
}

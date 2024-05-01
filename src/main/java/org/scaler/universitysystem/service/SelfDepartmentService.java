package org.scaler.universitysystem.service;

import jdk.jfr.Category;
import org.scaler.universitysystem.Exceptions.DepartmentNotFoundException;
import org.scaler.universitysystem.Exceptions.ProgramNotFoundException;
import org.scaler.universitysystem.models.Department;
import org.scaler.universitysystem.models.Program;
import org.scaler.universitysystem.repository.DepartmentRepository;
import org.scaler.universitysystem.repository.ProgramRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SelfDepartmentService implements DepartmentService{

    private DepartmentRepository departmentRepository;
    private ProgramRepository programRepository;

    SelfDepartmentService(DepartmentRepository departmentRepository, ProgramRepository programRepository){
        this.departmentRepository = departmentRepository;
        this.programRepository = programRepository;
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        if(optionalDepartment.isEmpty()){
            throw new DepartmentNotFoundException("The department id "+id+" does not contain any content.");
        }

        Department department = optionalDepartment.get();

        return department;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Program> getAllProductsByDepartmentId(Long id) {
        Department department = getDepartmentById(id);

        return department.getPrograms();
    }

    @Override
    public Department createNewDepartment(Department department) {
        List<Program> programs = department.getPrograms();

        List<Program> tempPrograms = new ArrayList<>();

        for(int i = 0; i<programs.size(); i++){
            Program temp = programs.get(i);
            if(temp.getId() == null){
                tempPrograms.add(programRepository.save(temp));
            }
            else{
                tempPrograms.add(temp);
            }
        }

        Department department1 = departmentRepository.save(department);

        for (int i = 0; i < tempPrograms.size(); i++) {
            Program temp = tempPrograms.get(i);
            Long tempId = temp.getId();

            Optional<Program> optionalProgram = programRepository.findById(temp.getId());

            if(optionalProgram.isEmpty()) {
                throw new ProgramNotFoundException("The Program id " + tempId + " is invalid");
            }
        }

        department1.setPrograms(tempPrograms);

        return department1;
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

}

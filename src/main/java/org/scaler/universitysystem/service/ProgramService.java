package org.scaler.universitysystem.service;

import org.scaler.universitysystem.models.Program;

import java.util.List;

public interface ProgramService {
    Program getProgramById(Long id);
    Program createProgram(Program program);
    Program updateProgram(Long id, Program program);
    void deleteProgram(Long id);

    List<Program> getProgramsByDepartment(Long departmentId);
    List<Program> getAllPrograms();
}

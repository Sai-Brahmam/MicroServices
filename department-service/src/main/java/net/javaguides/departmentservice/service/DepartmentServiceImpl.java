package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements  DepartmentService {

    private DepartmentRepository departmentRepository;

    public  DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository= departmentRepository;
    }
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department jpa entity
        Department department
                = new Department(
                        departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );


        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
         Department department
                  = departmentRepository.findByDepartmentCode(departmentCode);
         DepartmentDto departmentDto = new DepartmentDto(
                 department.getId(),
                 department.getDepartmentName(),
                 department.getDepartmentDescription(),
                 department.getDepartmentCode()
         );
         return  departmentDto;
    }


}

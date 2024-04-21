package com.jcmm.capStrong.service;

import java.util.List;

import com.jcmm.capStrong.model.Class;
import com.jcmm.capStrong.repository.ClassRepository;
import com.jcmm.capStrong.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassRepository classes;

    @Override
    public List<Class> getAllClasses() {
        return classes.findAll();
    }

    @Override
    public Class getClassById(int id) {
        if(classes.findById(id).isPresent()){
            return classes.findById(id).get();
        } else {
            throw new ClassNotFound();
        }
    }

    @Override
    public Class createClass(Class newClass) {
        return classes.save(newClass);
    }

    @Override
    public Class updateClassById(int id, Class updatedClass) {
                
            Class currentClass = classes.findById(id).get();

            if (updatedClass.getClassId() != null) {
                currentClass.setClassId(updatedClass.getClassId());
            }
            if (updatedClass.getTeacher() != null) {
                currentClass.setTeacher(updatedClass.getTeacher());
            }
            if (updatedClass.getSubject() != null) {
                currentClass.setSubject(updatedClass.getSubject());
            }
            if (updatedClass.getGradelevel() != null) {
                currentClass.setGradelevel(updatedClass.getGradelevel());
            }
            return classes.save(currentClass);
        }

    @Override
    public void deleteClassById(int id) {
        classes.deleteById(id);
    }
    
}

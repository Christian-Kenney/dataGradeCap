package com.jcmm.capStrong.service;

import com.jcmm.capStrong.model.Class;

import java.util.List;

public interface ClassService {
    List<Class> getAllClasses();
    Class getClassById (int id);
    Class createClass (Class newClass);
    Class updateClassById (int id, Class updatedClass);
    void deleteClassById (int id);
}

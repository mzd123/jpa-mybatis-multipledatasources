package com.mzd.multipledatasources.dao.test02.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mzd.multipledatasources.bean.Single2.TeachersBean;

@Repository
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public interface TeacherDao extends JpaRepository<TeachersBean, String> {

}

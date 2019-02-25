package com.company.demo.service

import java.util

import com.haulmont.cuba.core.Persistence
import com.haulmont.cuba.security.entity.User
import javax.inject.Inject
import javax.transaction.Transactional
import org.springframework.stereotype.Service

@Service(DemoService.NAME)
class DemoServiceBean extends DemoService {
  @Inject
  private var persistence: Persistence = _

  @Transactional
  override def getUsers: util.List[User] = {
    val em = persistence.getEntityManager
    val q = em.createQuery("select u from sec$User u", classOf[User])

    q.getResultList
  }
}
package com.company.demo.web

import com.company.demo.service.DemoService
import com.haulmont.cuba.gui.model.CollectionContainer
import com.haulmont.cuba.gui.screen.Screen.BeforeShowEvent
import com.haulmont.cuba.gui.screen.{Screen, Subscribe, UiController, UiDescriptor}
import com.haulmont.cuba.security.entity.User
import javax.inject.Inject

@UiController("demo_NewScreen")
@UiDescriptor("new-screen.xml")
class NewScreen extends Screen {

  @Inject
  private var demoService: DemoService = _
  @Inject
  private var usersDc: CollectionContainer[User] = _

  @Subscribe
  private def beforeShow(event: BeforeShowEvent): Unit = {
    val users = demoService.getUsers
    usersDc.setItems(users)
  }
}
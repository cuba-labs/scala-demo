# CUBA Platform with Scala

Here you will find simple project that uses Scala for services and screens.

Build setup:
```groovy
// Enable scala for all modules

subprojects {
    apply plugin: 'scala'

    sourceSets {
        main {
            scala {
                srcDirs = ['src']
            }
        }

        test {
            scala {
                srcDirs = ['test']
            }
        }
    }

    dependencies {
        compile('org.scala-lang:scala-library:2.12.8')
    }
}
```

Service:
```scala
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
```

Screen example:
```scala
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
```
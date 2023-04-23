import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class PlanDePruebasGatling extends Simulation {

  val httpProtocol = http
    .baseUrl("https://petstore.octoperf.com")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:54.0) Gecko/20100101 Firefox/54.0")

  val userData = csv("C://Users//more-//OneDrive//Desktop//DatosDinamicos//datos.csv").random

  val searchLoginRegisterScenario = scenario("All test scenarios")
    .exec(http("Home")
      .get("/actions/Catalog.action"))
    .pause(5 seconds)
    .exec(http("Login")
      .post("/actions/Account.action")
      .formParam("username", "j2ee")
      .formParam("password", "j2ee")
      .formParam("signon", "Login"))
    .pause(5 seconds)
    .exec(http("Search")
      .get("/actions/Catalog.action")
      .queryParam("categoryId", "BIRDS")
      .queryParam("searchString", "parrot"))
    .pause(5 seconds)
    .feed(userData)
    .exec(http("Register")
      .post("/actions/Account.action?newAccountForm=")
      .formParam("username", "${id}")
      .formParam("password", "${password}")
      .formParam("repeatedPassword", "${password}")
      .formParam("account.firstName", "${name}")
      .formParam("account.lastName", "${last_name}")
      .formParam("account.email", "${email}")
      .formParam("account.phone", "${phone}")
      .formParam("account.address1", "${address}")
      .formParam("account.city", "${city}")
      .formParam("account.state", "${state}")
      .formParam("account.zip", "${zip}")
      .formParam("account.country", "${country}"))
    .pause(5 seconds)

  setUp(
    searchLoginRegisterScenario.inject(
      constantConcurrentUsers(100) during (30 minutes)
    )
  ).protocols(httpProtocol)
}
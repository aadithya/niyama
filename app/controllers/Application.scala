package controllers

import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

object Application extends Controller {
  val searchForm = Form(
    tuple(
      "Area" -> text,
      "City" -> text
    )
  )

  def index = Action {
    Ok(views.html.index(searchForm))
  }

  def search = Action{ implicit request =>
    searchForm.bindFromRequest.fold(
       formWithErrors => BadRequest(views.html.index(formWithErrors)),
       {case (area, city) => Ok("Ah! Success")}
    )
  }
}

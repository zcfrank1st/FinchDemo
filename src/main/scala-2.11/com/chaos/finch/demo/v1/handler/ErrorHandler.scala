package com.chaos.finch.demo.v1.handler

import com.twitter.finagle.http.{Request, Response, Status, Version}
import com.twitter.util.Future
import com.typesafe.scalalogging.StrictLogging
import io.finch.Error.{NotParsed, NotPresent, NotValid, RequestErrors}
import io.finch._

/**
  * Created by zcfrank1st on 7/2/16.
  */

trait ErrorHandler extends StrictLogging {
  def apiErrorHandler: PartialFunction[Throwable, Output[Nothing]] = {
    case e: NotPresent => BadRequest(e)
    case e: NotParsed => BadRequest(e)
    case e: NotValid => BadRequest(e)
    case e: RequestErrors => BadRequest(e)
    case e: Exception => InternalServerError(e)
  }

  def topLevelErrorHandler[REQUEST <: Request](request: REQUEST, encoder: EncodeResponse[Throwable]): PartialFunction[Throwable, Future[Response]] = {
    case t: Throwable => unhandledException(request, t, encoder)
  }

  private def unhandledException[REQUEST <: Request](request: REQUEST, t: Throwable, encoder: EncodeResponse[Throwable]): Future[Response] = {
    try {
      logger.info(s"Unhandled exception on URI ${request.uri} with message $t")
      Future.value(Response(Version.Http11, Status.InternalServerError))
    } catch {
      case e: Throwable => {
        Console.err.println(s"Unable to log unhandled exception: $e")
        throw e
      }
    }
  }
}

object ErrorHandler extends ErrorHandler
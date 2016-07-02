package com.chaos.finch.demo.v1.filter

import com.chaos.finch.demo.v1.handler.ErrorHandler
import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.{Future, NonFatal}
import io.finch.EncodeResponse

/**
  * Created by zcfrank1st on 7/2/16.
  */
class ExceptionFilter[REQUEST <: Request](encoder: EncodeResponse[Throwable]) extends SimpleFilter[REQUEST, Response] {
  def apply(request: REQUEST, service: Service[REQUEST, Response]): Future[Response] = {
    val finalResponse = {
      try {
        service(request)
      } catch {
        case NonFatal(e) => Future.exception(e)
      }
    }
    // TODO TJA Is this going to rework the API/Finch level error handling?
    finalResponse.rescue(ErrorHandler.topLevelErrorHandler(request, encoder))
  }
}

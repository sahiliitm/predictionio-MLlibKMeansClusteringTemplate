package org.template.vanilla

import io.prediction.controller.IEngineFactory
import io.prediction.controller.Engine
import org.apache.spark.mllib.linalg.Vector
case class Query(
  val dataPoint: Array[Double]
) extends Serializable

case class PredictedResult(
  val cluster: Double) 
extends Serializable

object VanillaEngine extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map("algo" -> classOf[Algorithm]),
      	classOf[Serving])
  }
}

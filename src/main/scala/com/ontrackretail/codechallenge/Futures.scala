package com.ontrackretail.codechallenge

import scala.concurrent.{ExecutionContext, Future}

object Futures {

  /* The functions given do not have any input parameters,
   * this makes it hard to show a future dependency chain.
   * For the sake of this exercise I have commented on the line
   * with an example which shows dependency usage.
   */

  //Given these functions:
  def f1(): Future[Unit] = ???
  def f2(): Future[Unit] = ???
  def f3(): Future[Unit] = ???
  def f4(): Future[Unit] = ???

  //Write code to:

  /**
    * there are no dependencies between the functions
    *
    * @return
    */
  def noDependency(implicit ec: ExecutionContext): Future[Seq[Unit]] = {
    Future.sequence(Seq(f1, f2, f3, f4))
  }

  /**
    * f4 depends on f3 which depends on f2 which depends on f1
    *
    * @return
    */
  def linearDependency(implicit ec: ExecutionContext): Future[Unit] = {
    f1 flatMap { f1dependency =>
      //do something with f2 with f1dependency eg f2(f1dependency)
      f2 map { f2dependency =>
        //do something with f3 with f2dependency eg f3(f2dependency)
        f3 flatMap { f3dependency =>
          //do something with f4 with f3dependency eg f4(f3dependency)
          f4 map { f4dependency =>
            f4
          }
        }
      }
    }
  }

  /**
    * f4 depends on f3 and f2, and f3 and f2 both depend on f1
    *
    * @return
    */
  def treeDependency(implicit ec: ExecutionContext): Future[Unit] = {
    for {
      f1dependency <- f1
      f2dependency <- f2 //do something with f2 with f1dependency eg f2(f1dependency)
      f3dependency <- f3 //do something with f3 with f1dependency eg f3(f1dependency)
      f4dependency <- f4 //do something with f2 with f1dependency eg f4(f2dependency, f3dependency)
    } yield f4dependency
  }
}

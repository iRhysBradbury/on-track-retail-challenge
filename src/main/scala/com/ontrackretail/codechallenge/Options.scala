package com.ontrackretail.codechallenge

import java.util.NoSuchElementException

object Options {

  //Provide 2 examples of how you can safely use the string in this option:
  val myStringOption = Some("test")

  /**
    * map/flatMap your monad!
    *
    * polymorphic function which accepts a higher order function
    *
    * @param fn higher order function which provides a route from `String` => `T`
    * @tparam T the return type
    * @return the mapped result
    */
  def safely1[T](fn: (String => T)): Option[T] = {
    myStringOption.map(fn)
  }

  /**
    * using for yield comprehension
    *
    * polymorphic function which accepts a higher order function
    *
    * @param fn higher order function which provides a route from `String` => `T`
    * @tparam T the return type
    * @return the result
    */
  def safely2[T](fn: (String => T)): Option[T] = {
    for {
      str <- myStringOption
      result = fn(str)
    } yield result
  }

  //Some extra `freebees` because I still have time remaining

  /**
    * using the Either monad
    *
    * polymorphic function which accepts a higher order function
    *
    * @param fn higher order function which provides a route from `String` => `T`
    * @tparam T the return type
    * @return the result as an Either monad, being `T` or an `NoSuchElementException`
    */
  def safely3[T](fn: (String => T)): Either[T, NoSuchElementException] = {
    myStringOption.map(fn).toLeft(new NoSuchElementException)
  }

  /**
    * not advised but still 'safe'
    *
    * polymorphic function which accepts a higher order function
    *
    * @param fn higher order function which provides a route from `String` => `T`
    * @tparam T the return type
    * @return the result as an Either monad
    */
  def safely4[T](fn: (String => T)): Option[T] = {
    if(myStringOption.isDefined) {
      Some(fn(myStringOption.get))
    } else {
      None
    }
  }
}

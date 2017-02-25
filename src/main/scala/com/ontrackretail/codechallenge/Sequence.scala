package com.ontrackretail.codechallenge

import scala.annotation.tailrec

object Sequence {

  @tailrec
  def increment(seq: Seq[Int], num: Int = 0, steps: Int = 0): Seq[Int] = {
    seq match {
      case head :: tail => increment(
        tail,
        num + head * math.pow(10, seq.length - 1).toInt,
        steps + 1
      )
      case Nil => if (steps == 0) Seq.empty else asSeq(num + 1)
    }
  }

  @tailrec
  def asSeq(num: Int, res: Seq[Int] = Seq.empty): Seq[Int] = {
    if (num > 0) {
      asSeq(num / 10, res :+ (num % 10))
    } else {
      res.reverse
    }
  }
}

package com.ontrackretail.codechallenge

object Sequence {

  def increment(seq: Seq[Int]): Seq[Int] = {
    seq match {
      case Nil => Nil
      case _ => {
        (Integer.valueOf(seq.mkString) + 1).toString.toCharArray.map(x => Integer.valueOf(x.toString).toInt).toSeq
      }
    }
  }
}

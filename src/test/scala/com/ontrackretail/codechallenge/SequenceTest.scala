package com.ontrackretail.codechallenge

import org.scalatest.{FlatSpec, Matchers}

class SequenceTest extends FlatSpec with Matchers {

  it should "produce `Seq.empty` output for `Seq.empty` input" in {
    val input = Seq.empty
    val actual = Sequence.increment(input)
    val expected = Seq.empty

    actual shouldBe expected
  }

  it should "produce `Seq(1)` output for `Seq(0)` input" in {
    val input = Seq(0)
    val actual = Sequence.increment(input)
    val expected = Seq(1)

    actual shouldBe expected
  }

  it should "produce `Seq(1, 2, 4)` output for `Seq(1, 2, 3)` input" in {
    val input = Seq(1, 2, 3)
    val actual = Sequence.increment(input)
    val expected = Seq(1, 2, 4)

    actual shouldBe expected
  }

  it should "produce `Seq(1, 0, 0, 0)` output for `Seq(9, 9, 9)` input" in {
    val input = Seq(9, 9, 9)
    val actual = Sequence.increment(input)
    val expected = Seq(1, 0, 0, 0)

    actual shouldBe expected
  }
}

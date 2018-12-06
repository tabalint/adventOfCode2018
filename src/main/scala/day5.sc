import scala.annotation.tailrec
import scala.io.Source

val lines = Source.fromFile("C:\\Users\\TrevHP\\Dropbox\\IdeaProjects\\AdventOfCode2018\\src\\main\\scala\\input_files\\day_5.txt").getLines.toList.head.toCharArray.toList

@tailrec
def sumAccumulator(ints: List[Char], accum: List[Char]): List[Char] = {
//  println(ints, accum)
  ints match {
    case Nil => accum
    case x :: tail => if ((accum.last.toUpper == x && accum.last == x.toLower) ||
                          (accum.last.toLower == x && accum.last == x.toUpper)) sumAccumulator(accum.tail.take(accum.length-1) ::: tail, List(accum.head))
                      else sumAccumulator(tail, accum :+ x)
  }
}

val test = "dabAcCaCBAcCcaDA".toCharArray.toList

//sumAccumulator(test.tail, List(test.head))
val answer = sumAccumulator(lines.tail, List(lines.head)).length

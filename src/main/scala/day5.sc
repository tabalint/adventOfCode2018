import scala.annotation.tailrec
import scala.io.Source

val lines = Source.fromFile("C:\\Users\\TrevHP\\Dropbox\\IdeaProjects\\AdventOfCode2018\\src\\main\\scala\\input_files\\day_5.txt").getLines.toList.head.toCharArray.toList

@tailrec
def sumAccumulator(ints: List[Char], accum: List[Char]): List[Char] = {
  if (accum.length < 1) sumAccumulator(ints.tail, accum:+ ints.head)
  else {
    ints match {
      case Nil => accum.filterNot(_.toString == "5")
      case x :: tail =>
        if ((accum.last.toUpper == x && accum.last == x.toLower) ||
          (accum.last.toLower == x && accum.last == x.toUpper)) {
          sumAccumulator(accum.reverse.tail.headOption.getOrElse("5".charAt(0)) :: tail, accum.take(accum.length - 2))
        }
        else sumAccumulator(tail, accum :+ x)
    }
  }
}

//val test = "AacAcCaCBAcCcaDA".toCharArray.toList
//sumAccumulator(test, List.empty[Char])

// part 1 answer
val answer1 = sumAccumulator(lines, List.empty[Char]).length

// part 2
val chars = "abcdefghijklmnopqrstuvwxyz".toCharArray.toList
chars.map(a => (a, sumAccumulator(lines.filterNot(b => b==a || b==a.toUpper), List.empty[Char]).length)).sortBy(_._2)

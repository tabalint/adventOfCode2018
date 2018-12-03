import scala.io.Source
val lines = Source.fromFile("C:\\Users\\TrevHP\\Dropbox\\IdeaProjects\\AdventOfCode2018\\src\\main\\scala\\input_files\\day_1.txt").getLines.toList.map(_.toInt)

lines.sum  // end of part 1

//basically need to make this recursive, which is stupid
val intermediate_results = 0 +: lines.foldLeft((0, List[Int]()))
{(acu,i)=>(i+acu._1, i+acu._1 :: acu._2)}._2.reverse
intermediate_results.map((a) => (a,intermediate_results.count(_==a))).takeWhile(_._2 > 1)

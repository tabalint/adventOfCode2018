import scala.io.Source
val lines = Source.fromFile("C:\\Users\\TrevHP\\Dropbox\\IdeaProjects\\AdventOfCode2018\\src\\main\\scala\\input_files\\day_2.txt").getLines.toList

//part1
val listOfMaps = lines.map((str) => str.foldLeft[Map[Char, Int]](Map.empty)((m, c) => m + (c -> (m.getOrElse(c, 0) + 1))))
val part1 = listOfMaps.map(_.filter(_._2>1)).filterNot(_.isEmpty).flatMap(_.values.toList.distinct)
part1.count(_==2) * part1.count(_==3)

//part2
val allPairs = lines.flatMap(x => lines.map(y => (x, y)))
val goodPair = allPairs.map(b => (b, b._1.zip(b._2).toList.filterNot(c => c._1.equals(c._2)).length)).filter(_._2==1).head._1
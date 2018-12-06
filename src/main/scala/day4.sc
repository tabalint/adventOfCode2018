import scala.io.Source
import java.util.Date

val lines = Source.fromFile("C:\\Users\\TrevHP\\Dropbox\\IdeaProjects\\AdventOfCode2018\\src\\main\\scala\\input_files\\day_4.txt").getLines.toList

val formatter = new java.text.SimpleDateFormat("MM-dd HH:mm")
val sortedList = lines.map(b => (new Date(formatter.parse(b.substring(6, 17)).getTime+7200000), b.substring(19).split(' ').map(_.trim).toList)).sortBy(_._1)

sortedList.map(b => (b._1, b._2(1))).groupBy(_._1.getDay)
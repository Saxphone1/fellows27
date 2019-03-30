import scala.collection.mutable

object ScalaMap {
  def main(args: Array[String]): Unit = {
//    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
////    Map(("a",10))
//
//    val map2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> 30)
//
//
//    val map3 = new scala.collection.mutable.HashMap[String, Int]
//
//    var map4 = mutable.Map( ("A", 1), ("B", 2), ("C", 3),("D", 30) )
////    println("map4=" + map4("E"))
////    println(map4.contains("E"))
////    println(map4.get("A").get)
////      println(map4.getOrElse("E","xxx"))
//
//      map4("B") = 666
//      map4("E") = 888
//      map4 += ( "D" -> 4 )
//      map4 += ( "B" -> 50 )
//
//      map4 = map4 + ("E"->1, "F"->3)
//      map4 += ("EE"->1, "FF"->3)
//
////    println(map5)
//    println(map4)

//    val map1 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
//    for ((k, v) <- map1) println(k + " is mapped to " + v)
//    for (v <- map1.keys) println(v)
//    for (v <- map1.values) println(v)
//    for(v <- map1) println(v._1) //v是Tuple?

//    val set = Set(1, 2, 3) //不可变
//    for(i <- set){
//      println(i)
//    }


    val mutableSet = mutable.Set(1, 2, 3) //可变
    mutableSet.add(4)
    mutableSet += 5
    mutableSet.+=(6)
//
//    mutableSet -= 4
//    mutableSet.-=(5)
//    mutableSet.remove(1)

//    val xx = mutableSet.dropRight(2)

//    println(xx)
    println(mutableSet.max)
    println(mutableSet.min)


  }
}

import scala.collection.mutable.Queue
import scala.collection.immutable.List
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object List {

  def main(args: Array[String]): Unit = {
    val arr1 = new Array[Int](10)
    arr1(1) = 222

    for (i <- arr1) {
      println(i)
    }

    val arr2 = Array(1, 2,3,4,5)
    arr2(3) = 222

    println("arr1=" + arr2(1))

    val arr3 = ArrayBuffer[Int]()
    arr3.append(1,2,3,4);
//    arr3(0) = 7
    arr3.remove(1,2)
    println("arr3=" + arr3(1))

//    var arr4 = arr3.toArray
//    arr4(6) = 100

//    val tuple1 = (1, 2, 3, "hello", 4)
//    println(tuple1._1)//从1开始
//    println(tuple1.productElement(0))
//
//    for(xx <- tuple1.productIterator){
//      println(xx)
//    }
//
//    val list01 = scala.collection.immutable.List(1,2,3) //创建时，直接分配元素
//    println(list01)
//    val list02 = Nil  //空集合
//    println(list02)
//
//    val value1 = list01(1) // 1是索引，表示取出第2个元素.
//    println(value1)
//    val list01 = scala.collection.immutable.List(1,2,3)
//    var list03 = list01 :+ 4
//    println(list03)
//
//    var list04 = 4 +: list01 :+ 5
//    println(list04)
//
//    val list5 = 4 :: 5 :: 6 :: list01 ::: Nil
//    println(list5)
//    //下面等价 4 :: 5 :: 6 :: list1val list7 = 4 :: 5 :: 6 :: list1 ::: Nilprintln(list7)
//
//    val lst0 = ListBuffer[Int](1, 2, 3)
//
//
//    val lst1 = new ListBuffer[Int]
//    lst1 += 4
//    lst1.append(5)
//    lst0 ++= lst1
//
//    val lst2 = lst0 ++ lst1
//    val lst3 = lst0 :+ 5

//    println("=====删除=======")
//    println("lst1=" + lst1)
//    lst1.remove(1)
//    for (item <- lst1) {
//      println("item=" + item)
//    }
//
//    val q1 = new Queue[Any]
//    q1 += 20
//    println(q1)
//
//    q1 ++= scala.collection.immutable.List(2,4,6) //
//    println(q1)









    //补充操作符重载...
//    val cat = new Cat
//    println(cat.age)
//    cat += 9
//    println(cat.age)
//
//
//    class Cat {
//      var age: Int = 10
//      def +=(n:Int): Unit = {
//        this.age += n
//        println("xxx")
//      }
//    }

    val q1 = new Queue[Int]//
    q1 += 12
    q1 += 34
    q1 ++= scala.collection.immutable.List(2,9)
    var xx = q1.dequeue() //队列头
    println(q1)
    println(xx)

    q1.enqueue(20,60) //队列位
    println(q1)//34 2 9 20 60

    //返回队列的第一个元素
    println("==============================")
    println(q1.head)
    println(q1)
    //返回队列最后一个元素
    println(q1.last)
    //返回队列的尾部
    //即：返回除了第一个以外剩余的元素， 可以级联使用，这个在递归时使用较多。
    println(q1.tail)
    println(q1.tail.tail.tail.tail)








  }
}

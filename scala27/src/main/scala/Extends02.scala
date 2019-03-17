
object Extends02 {
  def main(args: Array[String]): Unit = {
    val sub = new Sub()
    sub.sayOk()
    println(sub.isInstanceOf[Base])//

    val b = sub.asInstanceOf[Base]//   (Base)sub
    println(b.isInstanceOf[Base])//
    var monster = new Monster {
      var name: String = "牛魔王"
      def cry(): Unit = {
        println("牛魔王哼哼叫唤..")
      }
    }


  }
}

abstract class Base {
  var n1: Int =1
  protected var n2: Int = 2
  private var n3: Int = 3
  def test100(): Unit = {
    println("base 100")
  }
  protected def test200(): Unit = {
    println("base 200")
  }
  private def test300(): Unit = {
    println("base 300")
  }
}
class Sub extends Base {
  def sayOk(): Unit = {
    this.n1 = 20
    this.n2 = 40
    println("范围" + this.n1 + this.n2 )
  }

  override def test100(): Unit = {
    println("base 100")
  }
}

abstract class Monster{
  var name : String
  def cry()
}


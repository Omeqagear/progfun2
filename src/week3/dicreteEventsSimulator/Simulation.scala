package week3.dicreteEventsSimulator

/**
  * Created by Administrador on 29/12/2016.
  */
abstract class Simulation {
  type Action = ()=> Unit
  case class Event(time: Int, action: Action)
  private type Agenda = List[Event]
  private var agenda: Agenda = List()

  private var curtime = 0
  def currentTime: Int = curtime
  def afterDelay(delay: Int)(block: =>Unit): Unit ={
    val item = Event(currentTime + delay, ()=> block)
    agenda = insert(agenda, item)
  }
  private def insert(ag: List[Event], item: Event): List[Event] = ag match {
    case firts :: rest if firts.time <= item.time =>
      firts :: insert(rest, item)
    case _ =>
      item :: ag
  }

  private def loop(): Unit = agenda match {
    case firts :: rest =>
      agenda = rest
      curtime = firts.time
      firts.action()
      loop()
    case Nil =>
  }


  def run(): Unit = {
    afterDelay(0){
      println("*** simulation Started , time =" + currentTime+ "***")
    }
    loop()
  }
}

package ninja.functor

import ninja.functor.BaseTest.USER_SUPPLIER
import ninja.functor.TryScalaTest.toScala
import org.junit.jupiter.api.Test

import java.util.function.Supplier
import scala.util.{Failure, Success, Try};

class TryScalaTest {
  @Test
  def test() = {
    USER_SUPPLIER
      .map { f => Try(f()) }
      .map { t => t.map(_.getEmail) }
      .map {
        case Failure(error) => s"error: $error"
        case Success(value) => s"email: $value"
      }
      .foreach(println)
  }
}

object TryScalaTest {
  implicit def toScala[A](f: Supplier[A]): () => A = () => f.get
}

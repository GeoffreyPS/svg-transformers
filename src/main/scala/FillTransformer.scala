/**
  * Created by geoff on 4/26/16.
  */
import scala.xml._

class FillTransformer(color: String, attribute: String, set: Set[String]) extends scala.xml.transform.RewriteRule {

  override def transform(n: Node): Seq[Node] = {
    if (checkID(n, set)) addFill(n, color)
    else n
  }

  def checkID(n: Node, s: Set[String]): Boolean = {
    val id = n.attribute(attribute).head.text
    s contains id
  }

  def addFill(n: Node, color: String): Elem = {
    n.asInstanceOf[Elem] % Attribute("fill", Text(color), Null)
  }
}
